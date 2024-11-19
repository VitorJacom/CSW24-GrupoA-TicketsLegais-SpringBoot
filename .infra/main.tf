provider "aws" {
  region = "us-east-1"
}

variable "aws_region" {
  default = "us-east-1"
}

data "aws_vpc" "default" {
  default = true
}

data "aws_subnets" "default" {
  filter {
    name   = "vpc-id"
    values = [data.aws_vpc.default.id]
  }
  filter {
    name   = "default-for-az"
    values = ["true"]
  }
}

data "aws_caller_identity" "current" {}

# Security Group para a Lambda
resource "aws_security_group" "lambda_sg" {
  name        = "lambda-sg"
  description = "Security Group para a funcao Lambda"
  vpc_id      = data.aws_vpc.default.id

  egress {
    from_port   = 0
    to_port     = 0
    protocol    = "-1"
    cidr_blocks = ["0.0.0.0/0"]
    description = "Permitir todo o trafego de saida"
  }
}

# Security Group para o banco de dados
resource "aws_security_group" "db_sg" {
  name        = "db-sg"
  description = "Security Group para o banco de dados"
  vpc_id      = data.aws_vpc.default.id

  ingress {
    from_port       = 3306
    to_port         = 3306
    protocol        = "tcp"
    security_groups = [aws_security_group.lambda_sg.id]
    description     = "Permitir trafego MySQL da funcao Lambda"
  }

  egress {
    from_port   = 0
    to_port     = 0
    protocol    = "-1"
    cidr_blocks = ["0.0.0.0/0"]
    description = "Permitir todo o trafego de saida"
  }
}

resource "random_id" "bucket_suffix" {
  byte_length = 4
}

resource "aws_s3_bucket" "lambda_bucket" {
  bucket = "tickets-legais-lambda-code-${random_id.bucket_suffix.hex}"

  tags = {
    Name        = "Lambda Code Bucket"
    Environment = "Development"
  }
}

resource "aws_s3_bucket_versioning" "lambda_bucket_versioning" {
  bucket = aws_s3_bucket.lambda_bucket.id

  versioning_configuration {
    status = "Enabled"
  }
}

resource "aws_s3_bucket_policy" "lambda_bucket_policy" {
  bucket = aws_s3_bucket.lambda_bucket.id

  policy = jsonencode({
    Version = "2012-10-17",
    Statement = [
      {
        Sid       = "AllowLambdaServiceToReadCode"
        Effect    = "Allow"
        Principal = {
          Service = "lambda.amazonaws.com"
        }
        Action    = "s3:GetObject"
        Resource  = "${aws_s3_bucket.lambda_bucket.arn}/*"
      }
    ]
  })
}

resource "aws_db_subnet_group" "default" {
  name       = "tickets-legais-db-subnet-group"
  subnet_ids = data.aws_subnets.default.ids

  tags = {
    Name = "Tickets Legais DB Subnet Group"
  }
}

resource "aws_db_instance" "my_db" {
  allocated_storage    = 20
  engine               = "mysql"
  engine_version       = "8.0"
  instance_class       = "db.t3.micro"
  db_name              = "mydatabase"
  username             = "admin"
  password             = "admin123"
  parameter_group_name = "default.mysql8.0"
  skip_final_snapshot  = true

  vpc_security_group_ids = [aws_security_group.db_sg.id]
  db_subnet_group_name   = aws_db_subnet_group.default.name
  publicly_accessible    = false
}

resource "aws_api_gateway_rest_api" "api" {
  name        = "tickets-legais-api"
  description = "API Gateway para a aplicacao Tickets Legais"
}

resource "aws_api_gateway_resource" "proxy" {
  rest_api_id = aws_api_gateway_rest_api.api.id
  parent_id   = aws_api_gateway_rest_api.api.root_resource_id
  path_part   = "{proxy+}"
}

resource "aws_api_gateway_method" "any_method" {
  rest_api_id   = aws_api_gateway_rest_api.api.id
  resource_id   = aws_api_gateway_resource.proxy.id
  http_method   = "ANY"
  authorization = "NONE"
}

# Adicionar integração MOCK para permitir o deployment inicial
resource "aws_api_gateway_integration" "proxy_mock_integration" {
  rest_api_id       = aws_api_gateway_rest_api.api.id
  resource_id       = aws_api_gateway_resource.proxy.id
  http_method       = aws_api_gateway_method.any_method.http_method
  type              = "MOCK"
  request_templates = {
    "application/json" = jsonencode({})
  }
}

resource "aws_api_gateway_deployment" "deployment" {
  depends_on = [
    aws_api_gateway_method.any_method,
    aws_api_gateway_integration.proxy_mock_integration
  ]

  rest_api_id = aws_api_gateway_rest_api.api.id
}

# Recurso para o estágio 'prod'
resource "aws_api_gateway_stage" "prod" {
  stage_name    = "prod"
  rest_api_id   = aws_api_gateway_rest_api.api.id
  deployment_id = aws_api_gateway_deployment.deployment.id

  variables = {
    # Adicione variáveis de estágio aqui, se necessário
  }
}

# Output do endpoint da API
output "api_invoke_url" {
  value = "https://${aws_api_gateway_rest_api.api.id}.execute-api.${var.aws_region}.amazonaws.com/prod"
}
