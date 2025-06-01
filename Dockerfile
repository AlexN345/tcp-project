# Используем официальный образ OpenJDK
FROM maven:3.9.6-eclipse-temurin-17 AS builder

# Рабочая директория
WORKDIR /app

# Копируем pom.xml и скачиваем зависимости
COPY pom.xml .
RUN mvn dependency:go-offline

# Копируем исходный код
COPY src ./src

# Собираем приложение
RUN mvn clean package -DskipTests

# Финальный образ (только с JRE)
FROM eclipse-temurin:17-jre-jammy
WORKDIR /app

# Копируем собранный JAR из builder-стадии
COPY --from=builder /app/target/*.jar app.jar


# Указываем команду для запуска приложения
ENTRYPOINT ["java", "-jar", "app.jar"]

