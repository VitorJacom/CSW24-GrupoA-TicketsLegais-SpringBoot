output "lambda_bucket_name" {
  value = aws_s3_bucket.lambda_bucket.id
}

output "api_id" {
  value = aws_api_gateway_rest_api.api.id
}

output "proxy_resource_id" {
  value = aws_api_gateway_resource.proxy.id
}

output "account_id" {
  value = data.aws_caller_identity.current.account_id
}

output "my_db_address" {
  value = aws_db_instance.my_db.address
}

output "my_db_name" {
  value = aws_db_instance.my_db.db_name
}

output "my_db_username" {
  value = aws_db_instance.my_db.username
}

output "my_db_password" {
  value = aws_db_instance.my_db.password
}

output "api_invoke_url" {
  value = "https://${aws_api_gateway_rest_api.api.id}.execute-api.${var.aws_region}.amazonaws.com/prod"
}