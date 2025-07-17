FROM eclipse-temurin:21-jdk-jammy
ARG JAR_FILE=target/parcialIntegracion-0.0.1-SNAPSHOT.jar
COPY ${JAR_FILE} app_parcialIntegracion.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "app_parcialIntegracion.jar"]

