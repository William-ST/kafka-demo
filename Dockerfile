# Usar una imagen base de OpenJDK
FROM openjdk:21-jdk-slim

# Crear un directorio temporal para la aplicación
VOLUME /tmp

# Copiar el JAR generado por Spring Boot al contenedor
COPY target/demo-0.0.1-SNAPSHOT.jar app.jar

# Ejecutar la aplicación
ENTRYPOINT ["java", "-jar", "/app.jar"]



