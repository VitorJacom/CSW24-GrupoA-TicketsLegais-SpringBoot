# Etapa 1: Build da aplicação
FROM maven:3.8.5-openjdk-17 AS builder
WORKDIR /app

# Copia o pom.xml e outras dependências para o diretório de trabalho
COPY ingressoLegais/pom.xml ./
RUN mvn dependency:go-offline -B

# Copia o restante do código para o contêiner
COPY ingressoLegais /app

# Compila o projeto
RUN mvn clean package -DskipTests

# Etapa 2: Imagem de execução
FROM openjdk:17-jdk-slim
WORKDIR /app
COPY --from=builder /app/target/*.jar app.jar

EXPOSE 8080
ENTRYPOINT ["java", "-jar", "app.jar"]
