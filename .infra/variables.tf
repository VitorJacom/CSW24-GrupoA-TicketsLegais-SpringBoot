# variables.tf

variable "aws_region" {
  description = "Região AWS para provisionamento"
  type        = string
  default     = "us-east-1"
}

variable "db_name" {
  description = "Nome do banco de dados"
  type        = string
  default     = "mydatabase"
}

variable "db_username" {
  description = "Nome de usuário do banco de dados"
  type        = string
  default     = "admin"
}

variable "db_password" {
  description = "Senha do banco de dados"
  type        = string
  default     = "admin123"
  sensitive   = true
}

# Se estiver usando Secrets Manager
variable "db_password_secret_arn" {
  description = "ARN do segredo no AWS Secrets Manager para a senha do banco de dados"
  type        = string
}
