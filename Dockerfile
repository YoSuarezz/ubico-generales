FROM openjdk:23
ARG JAR_FILE=target/ucobet-generales.jar
COPY ${JAR_FILE} ucobet-generales.jar
EXPOSE 8080
ENTRYPOINT ["java","-jar","ucobet-generales.jar"]
