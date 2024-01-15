FROM openjdk:19

COPY target/graphql-movie-0.0.1-SNAPSHOT.jar graphql-movie.jar

ENTRYPOINT ["java", "-jar", "/graphql-movie.jar"]