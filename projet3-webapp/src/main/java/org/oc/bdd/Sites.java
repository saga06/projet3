package org.oc.bdd;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.util.List;

import org.oc.beans.InfoSite;
import org.oc.escalade.webapp.test;
//public class Noms {
public class Sites {
    private Connection connexion;

    public List<InfoSite> recupererInfoSites() {
        List<InfoSite> infoSites = new ArrayList<InfoSite>();
        Statement statement = null;
        ResultSet resultat = null;

        loadDatabase();

        try {
            statement = connexion.createStatement();

            // Exécution de la requête
            resultat = statement.executeQuery("SELECT name, location FROM site;");

            // Récupération des données
            while (resultat.next()) {
                String name = resultat.getString("name");
                String location = resultat.getString("location");

                //Utilisateur utilisateur = new Utilisateur();
                InfoSite infoSite = new InfoSite();

                //utilisateur.setNom(nom);
                infoSite.setName(name);

                //utilisateur.setPrenom(prenom);
                infoSite.setLocation(location);

                //utilisateurs.add(utilisateur);
                infoSites.add(infoSite);
            }
        } catch (SQLException e) {
        } finally {
            // Fermeture de la connexion
            try {
                if (resultat != null)
                    resultat.close();
                if (statement != null)
                    statement.close();
                if (connexion != null)
                    connexion.close();
            } catch (SQLException ignore) {
            }
        }

        return infoSites;
    }

    private void loadDatabase() {
        // Chargement du driver
        try {
            //Class.forName("com.mysql.jdbc.Driver");
            Class.forName("org.postgresql.Driver");
        } catch (ClassNotFoundException e) {
        }

        try {
            //connexion = DriverManager.getConnection("jdbc:mysql://localhost:3306/javaee", "root", "root");
            connexion = DriverManager.getConnection("jdbc:postgresql://localhost:3306/projet3","root", "root");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    //public void ajouterUtilisateur(Utilisateur utilisateur) {
    public void addInfoSite(InfoSite infoSite) {
        loadDatabase();

        try {
            PreparedStatement preparedStatement = connexion.prepareStatement("INSERT INTO site(name, location) VALUES(?, ?);");
            preparedStatement.setString(1, infoSite.getName());
            preparedStatement.setString(2, infoSite.getLocation());

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}