package org.oc.dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;


import org.oc.beans.InfoSecteur;

// C'est ici que l'on trouve véritablement les requêtes SQL
// Quand on instancie les objets, on récupère la factory
// ce qui permet d'avoir accès directement à l'objet connecté
public class InfoSecteurDaoImpl implements InfoSecteurDao {
    private DaoFactory daoFactory;

    InfoSecteurDaoImpl(DaoFactory daoFactory) {
        this.daoFactory = daoFactory;
    }

    @Override
    public void ajouter(InfoSecteur infoSecteur) {
        Connection connexion = null;
        PreparedStatement preparedStatement = null;

        try {
            connexion = daoFactory.getConnection();
            //On récupère l'objet daoFactory.getConnection(), qui représente la connexion,
            // Ainsi on n'a pas besoin de refaire la connexion systématiquement
            // On récupère la connexion qui a déjà été faite en amont dans la factory
            preparedStatement = connexion.prepareStatement("INSERT INTO sector( name, description, site_id) VALUES(?, ?, ?);");
            preparedStatement.setString(1, infoSecteur.getName());
            preparedStatement.setString(2, infoSecteur.getDescription());
            preparedStatement.setInt(3, infoSecteur.getSite_id());

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<InfoSecteur> lister() {
        List<InfoSecteur> infoSecteurs = new ArrayList<InfoSecteur>();
        Connection connexion = null;
        Statement statement = null;
        ResultSet resultat = null;

        try {
            connexion = daoFactory.getConnection();
            statement = connexion.createStatement();
            resultat = statement.executeQuery("SELECT name, description, site_id FROM sector;");

            // Récupération des données
            // On récupère un résultat brut de la bdd difficilement manipulable, donc on en extrait les donnés pour les stocker de manière plus propre et facile à manipuler grace au while
            while (resultat.next()) {
                // on récupère les entrées grace à la méthode getString ou getInt qui permettent de récupérer des données de types string ou int
                //resultat.getString => je m'attends à récupérer une chaine de caractère ou un nombre ou une date etc... puis on les tocke dans des objets de type string, int, etc...
                String name = resultat.getString("name");
                String description = resultat.getString("description");
                int site_id = resultat.getInt("site_id");


                // On créé un java bean et on lui définit un nom et un prénom correspond à ceux que l'on vient de récupérer dans la bdd
                InfoSecteur infoSecteur = new InfoSecteur();
                infoSecteur.setName(name);
                infoSecteur.setDescription(description);
                infoSecteur.setSite_id(site_id);

                // on ajoute cet objet à un array (ou liste) grace à la méthode add. on ajout infoSecteur à infoSecteurs
                infoSecteurs.add(infoSecteur);
                // ensuite on boucle encore et encore grace au while jusqu'à tout récupérer
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } return infoSecteurs;

    }


}

