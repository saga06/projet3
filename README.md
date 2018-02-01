projet3

Ce projet a pour but d'�changer des infos sur les diff�rents sites d'escalade.

Il permet : - de partager des informations sur les sites, leurs secteurs et les voies de chaque secteur (hauteur, cotation, nombre de points�) - de faire une recherche multi-crit�res pour trouver votre prochain site de grimpe - de laisser des commentaires - de pr�senter les topo qui existent et les sites/secteurs qu�ils couvrent - d�avoir un espace de pr�t de topo (les propri�taires de topo peuvent proposer le pr�t de leur topo et les gens int�ress�s peuvent voir les topo disponibles et les r�server pour une p�riode)

C'est une application web en Java/JEE (JDK 8).

L�application est � d�ployer sur un serveur Apache Tomcat 9 et utilise une base de donn�es PostgreSQL 9.x.

L�application web est packag�e (WAR) avec Apache Maven.

Des scripts SQL de cr�ation de la base de donn�es et d'un jeu de donn�es de d�mo sont pr�sents dans le dossier "Base de donn�ees" � la racine du projet.

C'est un projet fait avec IntelliJ, avec un jdk 1.8.0_111, et tomcat.

Un seul fichier est � modifier. Il s'agit du fichier "dao.properties" qui est peut-�tre trouv� � ce chemin : projet3\projet3-webapp\src\main\resources\dao.properties

Il vous suffit de modifier le "nomutilisateur" et le "motdepasse" en fonction de vos param�tres de connexion � votre PostgreSQL.
