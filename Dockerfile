FROM openjdk:8-jdk-slim
COPY "./build/libs/BCP-0.0.1-RELEASE.jar" "app.jar"
EXPOSE 8082
ENTRYPOINT ["java","-jar","app.jar"]

