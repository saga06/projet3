package org.oc.dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;


import org.oc.beans.InfoSite;

// C'est ici que l'on trouve véritablement les requêtes SQL
// Quand on instancie les objets, on récupère la factory
// ce qui permet d'avoir accès directement à l'objet connecté
public class InfoSiteDaoImpl implements InfoSiteDao {
    private DaoFactory daoFactory;

    InfoSiteDaoImpl(DaoFactory daoFactory) {
        this.daoFactory = daoFactory;
    }

    @Override
    public void ajouter(InfoSite infoSite) {
        Connection connexion = null;
        PreparedStatement preparedStatement = null;

        try {
            connexion = daoFactory.getConnection();
            //On récupère l'objet daoFactory.getConnection(), qui représente la connexion,
            // Ainsi on n'a pas besoin de refaire la connexion systématiquement
            // On récupère la connexion qui a déjà été faite en amont dans la factory
            preparedStatement = connexion.prepareStatement("INSERT INTO site( name, location, zipcode, description, latitude, longitude) VALUES(?, ?, ?, ?, ?, ?);");
            preparedStatement.setString(1, infoSite.getName());
            preparedStatement.setString(2, infoSite.getLocation());
            preparedStatement.setString(3, infoSite.getZipcode());
            preparedStatement.setString(4, infoSite.getDescription());
            preparedStatement.setString(5, infoSite.getLatitude());
            preparedStatement.setString(6, infoSite.getLongitude());


            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<InfoSite> lister() {
        List<InfoSite> infoSites = new ArrayList<InfoSite>();
        Connection connexion = null;
        Statement statement = null;
        ResultSet resultat = null;


        try {
            connexion = daoFactory.getConnection();
            statement = connexion.createStatement();
            resultat = statement.executeQuery("SELECT name, location, zipcode, description, site_id, latitude, longitude FROM site;");

            // Récupération des données
            // On récupère un résultat brut de la bdd difficilement manipulable, donc on en extrait les donnés pour les stocker de manière plus propre et facile à manipuler grace au while
            while (resultat.next()) {
                // on récupère les entrées grace à la méthode getString ou getInt qui permettent de récupérer des données de types string ou int
                //resultat.getString => je m'attends à récupérer une chaine de caractère ou un nombre ou une date etc... puis on les tocke dans des objets de type string, int, etc...
                String name = resultat.getString("name");
                String location = resultat.getString("location");
                String zipcode = resultat.getString("zipcode");
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
                e.printStackTrace();
            } return infoSites;

    }


}

