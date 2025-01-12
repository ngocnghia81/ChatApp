# Stage 1: Build the application
FROM maven:3.8.3-openjdk-17 AS build
COPY . .
RUN mvn clean package -DskipTests

FROM openjdk:17-jdk-slim

COPY --from=build /target/websocket-0.0.1-SNAPSHOT.jar websocket-0.0.1-SNAPSHOT.jar

ENV PORT=9192

EXPOSE $PORT

CMD ["java", "-jar", "websocket-0.0.1-SNAPSHOT.jar"]