# Este arquivo pode ser usado para qualquer atualização adicional após o GitHub Actions

resource "aws_api_gateway_stage" "prod" {
  stage_name    = "prod"
  rest_api_id   = aws_api_gateway_rest_api.api.id
  deployment_id = aws_api_gateway_deployment.deployment.id

  variables = {
    # Adicione variáveis de estágio aqui, se necessário
  }
}

