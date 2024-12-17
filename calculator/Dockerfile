# Use a imagem oficial do OpenJDK
FROM openjdk:17-jdk-slim

# Diretório de trabalho dentro do container
WORKDIR /app

# Copiar o arquivo JAR gerado para o container
COPY target/calculator-0.0.1-SNAPSHOT.jar app.jar

# Expor a porta que o Spring Boot utiliza
EXPOSE 3000

# Comando para executar a aplicação
ENTRYPOINT ["java", "-jar", "app.jar"]
