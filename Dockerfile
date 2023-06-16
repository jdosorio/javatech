FROM maven:3.8.3-eclipse-temurin-11 AS build
COPY . .
RUN mvn clean package -DskipTests

FROM openjdk:11
COPY --from=build /target/demo-0.0.1-SNAPSHOT.jar demo-0.0.1-SNAPSHOT.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "demo-0.0.1-SNAPSHOT.jar"]