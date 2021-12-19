FROM gradle:7.2-jdk11 AS build

COPY build.gradle /app/
COPY src /app/src/

WORKDIR /app/

RUN gradle build --no-daemon

FROM adoptopenjdk/openjdk11:latest

COPY --from=build /app/build/libs/*.jar spring-boot-ms1.jar

RUN apt-get update && apt-get install -y netcat tcpdump inetutils-ping jq net-tools

COPY src/dockertools /dockertools
RUN chmod +x /dockertools/*
