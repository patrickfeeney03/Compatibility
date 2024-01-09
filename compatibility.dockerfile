FROM amazoncorretto:19

WORKDIR /app

COPY target/Compatibility-0.0.1-SNAPSHOT.jar /app

EXPOSE 8081

CMD ["java", "-jar", "Compatibility-0.0.1-SNAPSHOT.jar", "--spring.profiles.active=docker"]