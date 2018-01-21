package org.oc.dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;


import org.oc.beans.InfoPoint;

// C'est ici que l'on trouve véritablement les requêtes SQL
// Quand on instancie les objets, on récupère la factory
// ce qui permet d'avoir accès directement à l'objet connecté
public class InfoPointDaoImpl implements InfoPointDao {
    private DaoFactory daoFactory;

    InfoPointDaoImpl(DaoFactory daoFactory) {
        this.daoFactory = daoFactory;
    }


    public void ajouter(InfoPoint infoPoint) {
        Connection connexion = null;
        PreparedStatement preparedStatement = null;

        try {
            connexion = daoFactory.getConnection();
            //On récupère l'objet daoFactory.getConnection(), qui représente la connexion,
            // Ainsi on n'a pas besoin de refaire la connexion systématiquement
            // On récupère la connexion qui a déjà été faite en amont dans la factory
            preparedStatement = connexion.prepareStatement("INSERT INTO point( name, description, length_id) VALUES(?, ?, ?);");
            preparedStatement.setString(1, infoPoint.getName());
            preparedStatement.setString(2, infoPoint.getDescription());
            preparedStatement.setInt(3, infoPoint.getLength_id());

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }



    @Override
    public List<InfoPoint> lister(int ID) {
        List<InfoPoint> infoPoints = new ArrayList<InfoPoint>();
        Connection connexion = null;
        PreparedStatement ps = null;
        ResultSet resultat = null;


        try {
            connexion = daoFactory.getConnection();
            ps = connexion.prepareStatement("SELECT name, description, length_id, point_id FROM point WHERE length_id=?");
            ps.setInt(1, ID);

            resultat = ps.executeQuery();



            // Récupération des données
            // On récupère un résultat brut de la bdd difficilement manipulable, donc on en extrait les donnés pour les stocker de manière plus propre et facile à manipuler grace au while
            while (resultat.next()) {
                // on récupère les entrées grace à la méthode getString ou getInt qui permettent de récupérer des données de types string ou int
                //resultat.getString => je m'attends à récupérer une chaine de caractère ou un nombre ou une date etc... puis on les tocke dans des objets de type string, int, etc...
                String name = resultat.getString("name");
                String description = resultat.getString("description");
                int point_id = resultat.getInt("point_id");
                int length_id =resultat.getInt("length_id");


                // On créé un java bean et on lui définit un nom et un prénom correspond à ceux que l'on vient de récupérer dans la bdd
                InfoPoint infoPoint = new InfoPoint();
                infoPoint.setName(name);
                infoPoint.setDescription(description);
                infoPoint.setPoint_id(point_id);
                infoPoint.setLength_id(length_id);

                // on ajoute cet objet à un array (ou liste) grace à la méthode add. on ajout infoSecteur à infoSecteurs
                infoPoints.add(infoPoint);
                // ensuite on boucle encore et encore grace au while jusqu'à tout récupérer
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } return infoPoints;

    }



}

