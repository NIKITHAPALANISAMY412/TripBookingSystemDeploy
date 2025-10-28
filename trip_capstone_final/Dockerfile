# # Stage 1: Build the application
# FROM maven:3.9.4-eclipse-temurin-21 AS build
# WORKDIR /app

# # Copy only the necessary files
# COPY pom.xml ./
# COPY src ./src

# # Build the application
# RUN mvn -B -DskipTests package
# RUN mvn clean package -DskipTests 

# # Stage 2: Create the runtime image
# FROM eclipse-temurin:21-jre
# WORKDIR /app

# # Copy the JAR from the build stage
# COPY --from=build /app/target/*.jar trip_final_capstone-1.0-SNAPSHOT.jar

# # Create the data directory for H2
# RUN mkdir -p /app/data && chmod -R 777 /app/data

# EXPOSE 9090
# ENTRYPOINT ["java", "-jar", "trip_final_capstone-1.0-SNAPSHOT.jar"]

# Stage 1: Build the application
FROM maven:3.9.4-eclipse-temurin-21 AS build
WORKDIR /app

# Copy project files
COPY pom.xml .
COPY src ./src

# Build the JAR
RUN mvn -B -DskipTests clean package

# Stage 2: Runtime image
FROM eclipse-temurin:21-jre
WORKDIR /app

# Copy built jar
COPY --from=build /app/target/*.jar trip_final_capstone-1.0-SNAPSHOT.jar

EXPOSE 9090
ENTRYPOINT ["java", "-jar", "trip_final_capstone-1.0-SNAPSHOT.jar"]
