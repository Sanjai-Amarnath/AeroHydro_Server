# Use OpenJDK base image
FROM eclipse-temurin:21-jdk

# Set the working directory inside the container
WORKDIR /app

# Copy the fat JAR from your local project
COPY target/aerohydro-0.0.1-SNAPSHOT.jar app.jar

# Expose the port that Render will assign
EXPOSE 8080

# Start the Spring Boot app
CMD ["java", "-jar", "app.jar"]
