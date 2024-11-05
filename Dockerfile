FROM openjdk:23
ADD ./ucobet-generales-0.0.1-SNAPSHOT.jar ucobet-generales-0.0.1-SNAPSHOT.jar
ENTRYPOINT ["java","-jar","ucobet-generales-0.0.1-SNAPSHOT.jar"]