FROM --platform=linux/amd64 openjdk:21-ea-jdk
VOLUME /tmp
COPY target/*.jar app.jar
ENTRYPOINT ["java","-jar","/app.jar"]
