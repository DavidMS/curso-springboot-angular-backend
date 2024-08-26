# Fase 1: Construcción
FROM maven:3.8.5-openjdk-17-slim AS build

# Establece el directorio de trabajo dentro del contenedor
WORKDIR /app

# Copia el archivo pom.xml y las dependencias de Maven
COPY pom.xml .

# Descarga las dependencias necesarias
RUN mvn dependency:go-offline -B

# Copia todo el código fuente
COPY src ./src

# Compila la aplicación y empaqueta en un archivo JAR
RUN mvn clean package -DskipTests

# Fase 2: Ejecución
FROM openjdk:17-jdk-alpine

# Establece el directorio de trabajo dentro del contenedor
WORKDIR /app

# Copia el archivo JAR generado en la fase de construcción
COPY --from=build /app/target/*.jar app.jar

# Expone el puerto que tu aplicación utilizará
EXPOSE 8080

# Define el comando para ejecutar la aplicación
ENTRYPOINT ["java", "-jar", "app.jar"]
