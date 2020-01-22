# JAVA MICROSERVICE IMAGE
FROM openjdk:8-jdk-alpine
LABEL Author="Oleg Kaluzny", Version=0.1
ADD target/assistant-app.jar assistant-app.jar
EXPOSE 8088
ENTRYPOINT ["java","-jar", "assistant-app.jar"]
