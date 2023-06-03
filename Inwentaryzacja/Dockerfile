FROM eclipse-temurin:17-jdk-focal
 
WORKDIR /app
 
COPY .mvn/ .mvn
COPY mvnw pom.xml ./
RUN ./mvnw dependency:go-offline
 
COPY src ./src
RUN ./mvnw clean install -Dmaven.test.skip=true
ENTRYPOINT ["java", "-jar", "/app/target/Inwentaryzacja-0.0.1-SNAPSHOT.jar"]