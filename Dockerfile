FROM gradle:6.9-jdk8 as build

COPY --chown=gradle:gradle . /app
WORKDIR /app
RUN gradle clean build -x test

FROM amazoncorretto:11.0.16

ENV PORT 8080
EXPOSE 8080

COPY --from=build /app/build/libs/opentelemetry-integration-with-gradle-0.0.1-SNAPSHOT.jar /opt/app.jar
COPY --from=build /app/config-extension/build/libs/*.jar /opt/config-extension.jar
COPY --from=build /app/build/otel/opentelemetry-javaagent.jar /opt/

WORKDIR /opt
CMD ["java", "-jar", "app.jar"]