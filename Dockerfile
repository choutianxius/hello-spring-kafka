# build
FROM maven:3.9.9-eclipse-temurin-22-jammy AS build
WORKDIR /home/app
COPY . .
RUN --mount=type=cache,target=/root/.m2 ./mvnw clean package -Dspring.profiles.active=docker

# deploy
FROM eclipse-temurin:22-jre-jammy
WORKDIR /home/app
COPY --from=build /home/app/target/*.jar /home/app/app.jar
EXPOSE 8080
CMD ["java", "-jar", "/home/app/app.jar", "--spring.profiles.active=docker"]
