FROM openjdk:17-jdk-slim

WORKDIR /app

COPY target/protech-hire-*.jar app.jar

EXPOSE 8080

ENV JAVA_OPTS="-Xmx512m -Xms256m"

ENTRYPOINT ["sh", "-c", "java $JAVA_OPTS -jar app.jar"]