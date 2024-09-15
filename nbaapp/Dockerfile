FROM openjdk:17-jdk-slim
ARG JAR_FILE=target/nbaapp-0.0.1.jar
COPY ${JAR_FILE} app_nba.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "app_nba.jar"]