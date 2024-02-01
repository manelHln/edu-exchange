FROM eclipse-temurin:17-jdk-alpine as build


WORKDIR /app


COPY mvnw .
COPY .mvn/ .mvn
COPY pom.xml .
RUN ./mvnw dependency:resolve
COPY src ./src
EXPOSE 9898
CMD ["./mvnw", "spring-boot:run"]
