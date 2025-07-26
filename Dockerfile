FROM eclipse-temurin:21-jdk

# Install netcat for wait-for-it.sh
RUN apt-get update && apt-get install -y netcat-openbsd

WORKDIR /app

COPY target/app.jar app.jar
COPY wait-for-it.sh wait-for-it.sh
RUN chmod +x wait-for-it.sh

EXPOSE 8080

ENTRYPOINT ["./wait-for-it.sh", "mysql", "java", "-jar", "app.jar"]
