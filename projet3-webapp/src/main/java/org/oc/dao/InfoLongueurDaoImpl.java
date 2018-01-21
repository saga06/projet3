package org.oc.dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;


import org.oc.beans.InfoLongueur;

// C'est ici que l'on trouve véritablement les requêtes SQL
// Quand on instancie les objets, on récupère la factory
// ce qui permet d'avoir accès directement à l'objet connecté
public class InfoLongueurDaoImpl implements InfoLongueurDao {
    private DaoFactory daoFactory;

    InfoLongueurDaoImpl(DaoFactory daoFactory) {
        this.daoFactory = daoFactory;
    }


    public void ajouter(InfoLongueur infoLongueur) {
        Connection connexion = null;
        PreparedStatement preparedStatement = null;

        try {
            connexion = daoFactory.getConnection();
            //On récupère l'objet daoFactory.getConnection(), qui représente la connexion,
            // Ainsi on n'a pas besoin de refaire la connexion systématiquement
            // On récupère la connexion qui a déjà été faite en amont dans la factory
            preparedStatement = connexion.prepareStatement("INSERT INTO length( name, description, way_id) VALUES(?, ?, ?);");
            preparedStatement.setString(1, infoLongueur.getName());
            preparedStatement.setString(2, infoLongueur.getDescription());
            preparedStatement.setInt(3, infoLongueur.getWay_id());

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }



    @Override
    public List<InfoLongueur> lister(int ID) {
        List<InfoLongueur> infoLongueurs = new ArrayList<InfoLongueur>();
        Connection connexion = null;
        PreparedStatement ps = null;
        ResultSet resultat = null;


        try {
            connexion = daoFactory.getConnection();
            ps = connexion.prepareStatement("SELECT name, description, way_id, length_id FROM length WHERE way_id=?");
            ps.setInt(1, ID);

            resultat = ps.executeQuery();



            // Récupération des données
            // On récupère un résultat brut de la bdd difficilement manipulable, donc on en extrait les donnés pour les stocker de manière plus propre et facile à manipuler grace au while
            while (resultat.next()) {
                // on récupère les entrées grace à la méthode getString ou getInt qui permettent de récupérer des données de types string ou int
                //resultat.getString => je m'attends à récupérer une chaine de caractère ou un nombre ou une date etc... puis on les tocke dans des objets de type string, int, etc...
                String name = resultat.getString("name");
                String description = resultat.getString("description");
                int way_id = resultat.getInt("way_id");
                int length_id =resultat.getInt("length_id");


                // On créé un java bean et on lui définit un nom et un prénom correspond à ceux que l'on vient de récupérer dans la bdd
                InfoLongueur infoLongueur = new InfoLongueur();
                infoLongueur.setName(name);
                infoLongueur.setDescription(description);
                infoLongueur.setWay_id(way_id);
                infoLongueur.setLength_id(length_id);

                // on ajoute cet objet à un array (ou liste) grace à la méthode add. on ajout infoSecteur à infoSecteurs
                infoLongueurs.add(infoLongueur);
                // ensuite on boucle encore et encore grace au while jusqu'à tout récupérer
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } return infoLongueurs;

    }



}

