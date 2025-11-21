# Use the Eclipse Temurin alpine official image
FROM eclipse-temurin:21-jdk-alpine

# Carpeta de trabajo base
WORKDIR /app

# Copiar todo el repo al contenedor
COPY . ./

# Cambiar a la carpeta donde está el proyecto Gradle
WORKDIR /app/DevArt-main


# Construir la app
RUN ./gradlew clean build -x test

# Ejecutar la app (usamos comodín por si cambia el nombre del JAR)
CMD ["sh", "-c", "java -jar build/libs/*.jar"]
