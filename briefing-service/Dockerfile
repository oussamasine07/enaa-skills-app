# Utiliser une image officielle OpenJDK légère (JDK 21)
FROM openjdk:21-jdk-slim

# Déclarer une variable pour le nom du fichier JAR
ARG JAR_FILE=target/briefing-service-0.0.1-SNAPSHOT.jar

# Copier le fichier JAR dans l'image Docker et le renommer
COPY ${JAR_FILE} app.jar

# Définir la commande à exécuter lors du démarrage du conteneur
ENTRYPOINT ["java", "-jar", "/app.jar"]
