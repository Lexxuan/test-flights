FROM openjdk:8-jdk-alpine
VOLUME /tmp
ADD target/flights-1.0.0.jar app.jar
ENV MY_SERVICE_PORT 8080
EXPOSE ${MY_SERVICE_PORT}
ENTRYPOINT ["java", "-Djava.security.egd=file:/dev/./urandom","-Dserver.port=${MY_SERVICE_PORT}","-jar","/app.jar"]
