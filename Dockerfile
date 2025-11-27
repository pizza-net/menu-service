# Krok 1: Budowanie aplikacji (używamy obrazu z Mavenem i Javą)
FROM maven:3.9.9-eclipse-temurin-21 AS build
WORKDIR /app

# Kopiujemy pliki projektu do środka kontenera
COPY pom.xml .
COPY src ./src

# Budujemy plik .jar (pomijamy testy dla szybkości przy budowaniu obrazu)
RUN mvn clean package -DskipTests

# Krok 2: Uruchomienie aplikacji (używamy lekkiego obrazu Javy)
FROM eclipse-temurin:21-jre-jammy
WORKDIR /app

# Kopiujemy zbudowany plik .jar z pierwszego kroku
COPY --from=build /app/target/*.jar app.jar

# Wystawiamy port 8080 (standardowy dla Springa)
EXPOSE 8080

# Komenda startowa
ENTRYPOINT ["java", "-jar", "app.jar"]