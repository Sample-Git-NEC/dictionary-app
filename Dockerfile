FROM openjdk:17-jdk-slim
WORKDIR /app
COPY target/dictionary-app-0.0.1-SNAPSHOT.jar app.jar
EXPOSE 8083
ENV API_BASE_URL=https://api.dictionaryapi.dev/api/v2/entries/en/
CMD ["java", "-jar", "app.jar"]
