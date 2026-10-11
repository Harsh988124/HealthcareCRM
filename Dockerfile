# Build stage
FROM eclipse-temurin:17-jdk-alpine AS builder
WORKDIR /build

# Copy pom.xml and mvn wrapper
COPY pom.xml .
COPY .mvn .mvn
COPY mvnw mvnw
COPY mvnw.cmd mvnw.cmd

# Copy source code
COPY src src

# Build the application
RUN chmod +x mvnw && ./mvnw clean package -DskipTests

# Runtime stage
FROM eclipse-temurin:17-jre-alpine
WORKDIR /app

# Copy JAR from builder
COPY --from=builder /build/target/crm-0.0.1-SNAPSHOT.jar app.jar

# Run the application
ENTRYPOINT ["java", "-jar", "app.jar"]
