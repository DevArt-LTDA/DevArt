FROM eclipse-temurin:21-jdk-alpine

# Carpeta base dentro del contenedor
WORKDIR /DEVART

# Copiar todo el repo
COPY . ./

# Ir a la raíz del proyecto Gradle (donde está gradlew)
WORKDIR /DEVART/DevArt-main

# Construir solo el módulo Usuarios (si es un submódulo Gradle)
# Ajusta el nombre del módulo si en settings.gradle se llama distinto
RUN ./gradlew :Usuarios:bootJar -x test

# Ejecutar el JAR del módulo Usuarios
CMD ["sh", "-c", "java -jar Usuarios/build/libs/*.jar"]
