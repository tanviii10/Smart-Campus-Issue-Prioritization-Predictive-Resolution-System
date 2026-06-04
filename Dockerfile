FROM eclipse-temurin:21-jdk

RUN apt-get update && apt-get install -y python3 python3-pip

WORKDIR /app

COPY . .

RUN chmod +x mvnw

RUN ./mvnw clean package -DskipTests

EXPOSE 8080

CMD ["java", "-jar", "target/campusissue-0.0.1-SNAPSHOT.jar"]