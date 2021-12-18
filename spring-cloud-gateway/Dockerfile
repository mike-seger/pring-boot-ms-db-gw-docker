FROM gradle:7.2-jdk11 AS build

COPY build.gradle /app/
COPY src /app/src/

WORKDIR /app/

RUN gradle build --no-daemon

FROM adoptopenjdk/openjdk11:latest

COPY --from=build /app/build/libs/*.jar spring-cloud-gateway.jar

RUN apt-get update && apt-get install -y netcat

COPY wait.sh /wait.sh
RUN chmod +x /wait.sh
