#!/bin/sh

while ! nc -z eureka 8761 ; do
    echo "Waiting for the Eureka Server"
    sleep 3
done

java $JAVA_OPTS -Djava.security.egd=file:/dev/./urandom -jar spring-boot-admin.jar
#java -jar spring-boot-admin.jar
