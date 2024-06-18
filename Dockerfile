# Stufe 1: Build des Java-Projekts mit Gradle
FROM gradle:jdk17 AS build

# Kopiere den Quellcode ins Arbeitsverzeichnis des Gradle-Containers
COPY . /home/gradle/src
WORKDIR /home/gradle/src

# Führe den Gradle-Build aus
RUN gradle build --no-daemon

# Stufe 2: Laufzeitumgebung für das Java-Programm
FROM adoptopenjdk/openjdk17:alpine-jre

# Kopiere das kompilierte JAR aus dem Build-Container
COPY --from=build /home/gradle/src/build/libs/webtech-0.0.1-SNAPSHOT.jar app.jar

# Setze den Startbefehl für das Java-Programm
ENTRYPOINT ["java", "-jar", "/app.jar"]
