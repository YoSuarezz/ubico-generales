FROM openjdk:23
ADD ./ucobet-generales.jar ucobet-generales.jar
ENTRYPOINT ["java","-jar","ucobet-generales.jar"]
