# Use an official OpenJDK runtime as a parent image
FROM openjdk:21-jdk-slim

# Set the working directory to /app
WORKDIR /app

# Copy the current directory contents into the container at /app
COPY . /app

# Package and run the Spring Boot application
RUN ./gradlew bootJar && ls -la build/libs

# Run the jar file
ENTRYPOINT ["java", "-jar", "build/libs/urlcheck-0.0.1-SNAPSHOT.jar"]
