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

variable "db_password_secret_arn" {
  type = string
  description = "ARN do segredo do Secrets Manager que contém a senha do banco de dados"
}
