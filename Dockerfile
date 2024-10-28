FROM openjdk:23-jdk-slim
ARG JAR_FILE=target/ucobet-generales-0.0.1-SNAPSHOT.jar
COPY ${JAR_FILE} ucobet-generales.jar
EXPOSE 8080
ENTRYPOINT ["java","-jar","/ucobet-generales.jar"]
