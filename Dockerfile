# Stage 1: Build stage i.e. install maven dependancies
FROM maven:latest AS build

WORKDIR /app

# Copy source code
COPY . .

# Build the application
RUN mvn clean package -DskipTests

FROM openjdk:17

COPY --from=build /app/target/cps_demo.jar /cps_demo.jar

ENTRYPOINT ["java", "-jar", "/cps_demo.jar"]