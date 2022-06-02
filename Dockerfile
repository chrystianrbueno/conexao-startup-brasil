
# example file
FROM openjdk:17-jdk-alpine
LABEL maintainer=""
COPY . /app
EXPOSE 8080
ENTRYPOINT ["java", "-jar","/app/app.jar"]


