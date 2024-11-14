provider "aws" {
  region = "us-east-1"
}

# Obtém a VPC padrão
data "aws_vpc" "default" {
  default = true
}

# Obtém todas as subnets associadas à VPC padrão
data "aws_subnets" "default" {
  filter {
    name   = "vpc-id"
    values = [data.aws_vpc.default.id]
  }
  filter {
    name   = "default-for-az"
    values = ["true"]  # Filtra para subnets padrão para a zona de disponibilidade
  }
}

# Criar a instância do banco de dados MySQL
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

  vpc_security_group_ids = ["sg-066726b00c88c4c28"]  # Substitua pelo seu ID do Security Group

  publicly_accessible = true
  db_subnet_group_name = aws_db_subnet_group.default.name
}

# Criar o grupo de sub-rede (Subnets) associadas à VPC padrão
resource "aws_db_subnet_group" "default" {
  name       = "default-db-subnet-group"
  subnet_ids = data.aws_subnets.default.ids  # Aqui usamos a lista de subnets

  tags = {
    Name = "Default DB Subnet Group"
  }
}
