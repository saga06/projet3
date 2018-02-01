Projet 3

Ce projet a pour but d'échanger des infos sur les différents sites d'escalade.

Il permet : 
- de partager des informations sur les sites, leurs secteurs et les voies de chaque secteur (hauteur, cotation, nombre de points…) - de faire une recherche multi-critères pour trouver votre prochain site de grimpe 
- de laisser des commentaires 
- de présenter les topo qui existent et les sites/secteurs qu’ils couvrent 
- d’avoir un espace de prêt de topo (les propriétaires de topo peuvent proposer le prêt de leur topo et les gens intéressés peuvent voir les topo disponibles et les réserver pour une période)

C'est une application web en Java/JEE (JDK 8).

L’application est à déployer sur un serveur Apache Tomcat 9 et utilise une base de données PostgreSQL 9.x.

L’application web est packagée (WAR) avec Apache Maven.

Des scripts SQL de création de la base de données et d'un jeu de données de démo sont présents dans le dossier "Base de donnéees" à la racine du projet.

C'est un projet fait avec IntelliJ, avec un jdk 1.8.0_111, et tomcat.

Un seul fichier est à modifier. Il s'agit du fichier "dao.properties" que l'on trouve à cet emplacement : projet3\projet3-webapp\src\main\resources\dao.properties

Il vous suffit de modifier le "nomutilisateur" et le "motdepasse" en fonction de vos paramètres de connexion à votre PostgreSQL.
