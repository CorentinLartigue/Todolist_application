# ToDoList Application

## Description

ToDoList est une application web permettant aux utilisateurs de gérer leurs tâches quotidiennes. Elle permet de créer, modifier, supprimer et organiser des tâches dans une interface simple et intuitive. Chaque tâche peut être marquée comme terminée, offrant ainsi une gestion efficace de vos priorités.

## Fonctionnalités principales

- **Créer une tâche** : Ajoutez rapidement de nouvelles tâches avec une description.
- **Modifier une tâche** : Mettez à jour les détails de vos tâches à tout moment.
- **Supprimer une tâche** : Supprimez les tâches que vous n'avez plus besoin de suivre.
- **Interface réactive** : Une interface moderne et responsive pour une utilisation fluide sur tous les appareils.

## Architecture du projet

- **Front-end** : Développé avec **Angular**, pour une expérience utilisateur dynamique et réactive.
- **Back-end** : Utilisation de **Spring Boot** pour la gestion des données et des fonctionnalités logiques de l’application.
- **Base de données** : Les tâches sont stockées dans une base de données **MySQL**, permettant une gestion rapide et fiable des informations.

## Installation

### Prérequis

Avant de lancer le projet, assurez-vous d'avoir installé les éléments suivants sur votre machine :

- **Java 11+** pour le back-end (Spring Boot).
- **Node.js** et **npm** pour le front-end (Angular).
- **MySQL** pour la gestion de la base de données.

---

### Cloner le dépôt

Clonez le projet depuis le dépôt GitHub : `git clone https://github.com/votre-utilisateur/todolist-application.git`

---

### Front-end (Angular)

1. Allez dans le répertoire du front-end.

2. Installez les dépendances avec npm.

  cd front-end npm install

3. Lancez l'application Angular.

   ng serve

L'application sera accessible à l'adresse [http://localhost:4200](http://localhost:4200).

---

### Back-end (Spring Boot)

1. Allez dans le répertoire du back-end.

2. Compilez et lancez le back-end avec Gradle.

  cd back-end mvn spring-boot


L'API back-end sera accessible à l'adresse [http://localhost:8080](http://localhost:8080).

---

### Configuration de la base de données

1. Créez une base de données **todolist_db** dans MySQL.

2. Configurez les paramètres de connexion à la base de données dans le fichier `application.properties` du back-end

3. Assurez-vous que les tables sont créées automatiquement lors du démarrage de l'application Spring Boot.






