# syntax=docker/dockerfile:1
FROM eclipse-temurin:21-jre-alpine
VOLUME /tmp
COPY *.jar app.jar
ENTRYPOINT ["java","-jar","/app.jar"]