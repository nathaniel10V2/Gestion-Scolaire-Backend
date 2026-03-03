🏫 Gestion Scolaire – Backend API

Ce dépôt contient le backend de l’application de gestion d’un établissement scolaire.

Il s’agit d’une API REST développée avec Java 21 et Spring Boot 3, permettant de gérer les étudiants, enseignants, classes et opérations administratives via une architecture MVC robuste et structurée.

🚀 Technologies utilisées

☕ Java 21

🌱 Spring Boot 3

Spring Web (MVC)

Spring Data JPA

🗄️ Oracle Database

🔁 API REST

🛠️ Maven

📚 Fonctionnalités principales

👨‍🎓 Gestion des étudiants

Création d’un étudiant

Modification des informations

Suppression

Consultation de la liste

👩‍🏫 Gestion des enseignants

Ajout / Modification / Suppression

Affectation aux classes

🏫 Gestion des classes

Création de classes

Association étudiants / enseignants

🗄️ Persistance des données

Mapping des entités avec JPA

Relations (@OneToMany, @ManyToOne, etc.)

Connexion Oracle via configuration application.properties

🌐 API REST

Endpoints CRUD

Architecture basée sur les contrôleurs REST

Gestion centralisée des exceptions

🏗️ Architecture du projet

Structure typique :

src/main/java/com/gestion/scolaire
│
├── controller/
├── service/
├── repository/
├── model/

Architecture basée sur le modèle MVC :

Controller → Gestion des requêtes HTTP

Service → Logique métier

Repository → Accès aux données (JPA)

Model → Entités

🌐 Exemple d’endpoints
GET     /api/etudiants
POST    /api/etudiants
PUT     /api/etudiants/{id}
DELETE  /api/etudiants/{id}
🚀 Démarrer le projet
📦 Prérequis

Java 21

Maven

Oracle Database

IDE (IntelliJ / Eclipse / VS Code)

⚙️ Installation
git clone https://github.com/nathaniel10V2/Gestion-Scolaire-Backend.git
cd Gestion-Scolaire-Backend
mvn clean install
mvn spring-boot:run
⚙️ Configuration de la base de données

Dans src/main/resources/application.properties :

spring.datasource.url=jdbc:oracle:thin:@localhost:1521:XE
spring.datasource.username=YOUR_USERNAME
spring.datasource.password=YOUR_PASSWORD
spring.datasource.driver-class-name=oracle.jdbc.OracleDriver

spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
spring.jpa.database-platform=org.hibernate.dialect.OracleDialect
🎯 Objectif du projet

Ce backend a pour objectif de :

Mettre en place une architecture REST propre et maintenable

Exploiter les bonnes pratiques Spring Boot

Gérer la persistance avec JPA

Connecter une base de données Oracle

Servir d’API pour un frontend (ex : Angular)

La gestion des données

Les bonnes pratiques backend
