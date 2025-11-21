# Use the Eclipse temurin alpine official image
FROM eclipse-temurin:21-jdk-alpine

# Create and change to the app directory.
WORKDIR /app

# Copy local code to the container image.
COPY . ./

# Dar permiso de ejecución al wrapper de Gradle
RUN chmod +x ./gradlew

# Build the app.
RUN ./gradlew clean build -x test

# Run the app by dynamically finding the JAR file in the target directory
CMD ["sh", "-c", "java -jar build/libs/njdemo-0.0.1-SNAPSHOT.jar"]
