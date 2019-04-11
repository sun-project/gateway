FROM openjdk:8-jdk-alpine

RUN mkdir /application

WORKDIR /application

COPY target/gateway-0.0.1-SNAPSHOT.jar gateway.jar

ENTRYPOINT ["java", "-Dspring.profiles.active=production", "-jar", "gateway.jar"]
