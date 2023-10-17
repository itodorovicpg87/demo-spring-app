# Use an official OpenJDK runtime as a parent image
FROM openjdk:17-jdk-slim

# Set the working directory to /app
WORKDIR /app

# Copy the "wait-for-it" script to the /app directory in the image
COPY wait-for-it.sh /app/wait-for-it.sh

# Make the "wait-for-it" script executable
RUN chmod +x /app/wait-for-it.sh

# Copy the JAR file into the container
COPY target/your-application.jar /app/your-application.jar

# Use the "wait-for-it" script to wait for the MySQL container to be ready, and then run your application
CMD ["./wait-for-it.sh", "my-mysql-db:3306", "--", "java", "-jar", "your-application.jar"]


