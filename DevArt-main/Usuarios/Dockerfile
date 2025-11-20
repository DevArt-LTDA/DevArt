# Use the Ecplise temurin apline official image
# https://hub.docker.com/_/eclipse-temurin
FROM eclipse-temurin:17-jdk-alpine

# Set the working directory inside the container
WORKDIR /app
# Copy the current directory contents into the container at /app
COPY . /app

#Build the application
# RUN ./mvnw clean package -DskipTests
RUN ./gradlew clean build -x test 

#run the app by dinamically finding the jar file
CMD [java -jar $(ls build/libs/*.jar | head -n 1)]