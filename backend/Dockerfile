# Paso 1: Compilación (Build)
FROM container-registry.oracle.com/java/openjdk:23 AS build
WORKDIR /app

# Copiamos los archivos de maven
COPY .mvn/ .mvn
COPY mvnw pom.xml ./
# Corregimos permisos para que el script sea ejecutable
RUN chmod +x mvnw
# Descargamos dependencias (esto puede tardar la primera vez)
RUN ./mvnw dependency:go-offline

# Copiamos el código fuente y compilamos
COPY src ./src
RUN ./mvnw clean package -DskipTests

# Paso 2: Ejecución (Runtime)
FROM container-registry.oracle.com/java/openjdk:23
WORKDIR /app
# Copiamos el jar generado
COPY --from=build /app/target/*.jar app.jar

# El puerto por defecto de Spring Boot
EXPOSE 8080

# Comando de arranque
ENTRYPOINT ["java", "-jar", "app.jar"]