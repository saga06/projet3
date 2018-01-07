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
import org.oc.escalade.webapp.Test;
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
            resultat = statement.executeQuery("SELECT name, location, zipcode, description, site_id, latitude, longitude FROM site;");

            // Récupération des données
            while (resultat.next()) {
                String name = resultat.getString("name");
                String location = resultat.getString("location");
                int zipcode = resultat.getInt("zipcode");
                String description = resultat.getString("description");
                int site_id = resultat.getInt("site_id");
                String latitude = resultat.getString("latitude");
                String longitude = resultat.getString("longitude");



                InfoSite infoSite = new InfoSite();

                infoSite.setName(name);

                infoSite.setLocation(location);

                infoSite.setZipcode(zipcode);

                infoSite.setDescription(description);

                infoSite.setSite_id(site_id);

                infoSite.setLatitude(latitude);

                infoSite.setLongitude(longitude);

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
            Class.forName("org.postgresql.Driver");
        } catch (ClassNotFoundException e) {
        }

        try {
            connexion = DriverManager.getConnection("jdbc:postgresql://localhost:5432/projet3","postgres", "root");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void addInfoSite(InfoSite infoSite) {
        loadDatabase();

        try {
            PreparedStatement preparedStatement = connexion.prepareStatement("INSERT INTO site( name, location, zipcode, description, latitude, longitude) VALUES(?, ?, ?, ?, ?, ?);");
            preparedStatement.setString(1, infoSite.getName());
            preparedStatement.setString(2, infoSite.getLocation());
            preparedStatement.setInt(3,infoSite.getZipcode());
            preparedStatement.setString(4,infoSite.getDescription());
            preparedStatement.setString(5,infoSite.getLatitude());
            preparedStatement.setString(6,infoSite.getLongitude());


            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}