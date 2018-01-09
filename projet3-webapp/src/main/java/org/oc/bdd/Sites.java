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

public class Sites {
    private Connection connexion;

    public List<InfoSite> recupererInfoSites() { //renvoie une liste d'objet Infosite
        // Cette méthode fait les requêtes sql dans la bdd et créé un array Infosite
        // On l'initialise ici
        List<InfoSite> infoSites = new ArrayList<InfoSite>();
        // on créé un objet de type statement qui va représenter la requête SQL
        Statement statement = null;
        // on créé un objet Resultset de type resultat qu'on pourra manipuler et stocker dans l'array
        ResultSet resultat = null;

        loadDatabase();

        try {
            //
            statement = connexion.createStatement();

            // Exécution de la requête
            resultat = statement.executeQuery("SELECT name, location, zipcode, description, site_id, latitude, longitude FROM site;");

            // Récupération des données
            // On récupère un résultat brut de la bdd difficilement manipulable, donc on en extrait les donnés pour les stocker de manière plus propre et facile à manipuler grace au while
            while (resultat.next()) {
                // on récupère les entrées grace à la méthode getString ou getInt qui permettent de récupérer des données de types string ou int
                //resultat.getString => je m'attends à récupérer une chaine de caractère ou un nombre ou une date etc... puis on les tocke dans des objets de type string, int, etc...
                String name = resultat.getString("name");
                String location = resultat.getString("location");
                int zipcode = resultat.getInt("zipcode");
                String description = resultat.getString("description");
                int site_id = resultat.getInt("site_id");
                String latitude = resultat.getString("latitude");
                String longitude = resultat.getString("longitude");


                // On créé un java bean et on lui définit un nom et un prénom correspond à ceux que l'on vient de récupérer dans la bdd
                InfoSite infoSite = new InfoSite();

                infoSite.setName(name);

                infoSite.setLocation(location);

                infoSite.setZipcode(zipcode);

                infoSite.setDescription(description);

                infoSite.setSite_id(site_id);

                infoSite.setLatitude(latitude);

                infoSite.setLongitude(longitude);

                // on ajoute cet objet à un array (ou liste) grace à la méthode add. on ajout infoSite à infoSites
                infoSites.add(infoSite);
                // ensuite on boucle encore et encore grace au while jusqu'à tout récupérer
            }
        } catch (SQLException e) {
        } finally {
            // Fermeture de la connexion
            // à la fin de ferme la connexion grace à finally (bonne pratique)
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
        // et finalement on retourne notre liste d'infoSites !!!!! on a donc une liste d'infoSites qu'on envoi à la méthode do get de la servlet
        return infoSites;
    }

    private void loadDatabase() {
        // Chargement du driver de postgresql présent dans le dossier lib
        try {
            Class.forName("org.postgresql.Driver");
        // En cas d'échec création d'une exception (qui ne fait rien ici)
        } catch (ClassNotFoundException e) {
        }

        try {
            // On créé un objet de type connexion qui va faire la connexion à la bdd
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