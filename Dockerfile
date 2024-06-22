FROM openjdk:21-jdk-slim
ARG JAR_NAME
COPY ${JAR_NAME} app.jar
ENTRYPOINT ["java","-jar","/app.jar"]