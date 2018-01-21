package org.oc.dao;

import org.oc.beans.InfoVoie;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


    // C'est ici que l'on trouve véritablement les requêtes SQL
// Quand on instancie les objets, on récupère la factory
// ce qui permet d'avoir accès directement à l'objet connecté
    public class InfoVoieDaoImpl implements InfoVoieDao {
        private DaoFactory daoFactory;

        InfoVoieDaoImpl(DaoFactory daoFactory) {
            this.daoFactory = daoFactory;
        }


        public void ajouter(InfoVoie infoVoie) {
            Connection connexion = null;
            PreparedStatement preparedStatement = null;

            try {
                connexion = daoFactory.getConnection();
                //On récupère l'objet daoFactory.getConnection(), qui représente la connexion,
                // Ainsi on n'a pas besoin de refaire la connexion systématiquement
                // On récupère la connexion qui a déjà été faite en amont dans la factory
                preparedStatement = connexion.prepareStatement("INSERT INTO way( name, height, quotation, sector_id, nb_point) VALUES(?, ?, ?, ?, ?);");
                preparedStatement.setString(1, infoVoie.getName());
                preparedStatement.setInt(2, infoVoie.getHeight());
                preparedStatement.setString(3, infoVoie.getQuotation());
                preparedStatement.setInt(4,infoVoie.getSector_id());
                preparedStatement.setInt(5,infoVoie.getNb_point());


                preparedStatement.executeUpdate();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        public List<InfoVoie> lister(int ID) {
            List<InfoVoie> infoVoies = new ArrayList<InfoVoie>();
            Connection connexion = null;
            PreparedStatement ps = null;
            ResultSet resultat = null;


            try {
                connexion = daoFactory.getConnection();
                ps = connexion.prepareStatement("SELECT name, height, quotation, way_id, nb_point,sector_id FROM way WHERE sector_id=?");
                ps.setInt(1, ID);

                resultat = ps.executeQuery();



                // Récupération des données
                // On récupère un résultat brut de la bdd difficilement manipulable, donc on en extrait les donnés pour les stocker de manière plus propre et facile à manipuler grace au while
                while (resultat.next()) {
                    // on récupère les entrées grace à la méthode getString ou getInt qui permettent de récupérer des données de types string ou int
                    //resultat.getString => je m'attends à récupérer une chaine de caractère ou un nombre ou une date etc... puis on les tocke dans des objets de type string, int, etc...
                    String name = resultat.getString("name");
                    int height = resultat.getInt("height");
                    String quotation = resultat.getString("quotation");
                    int way_id = resultat.getInt("way_id");
                    int sector_id = resultat.getInt("sector_id");
                    int nb_point =resultat.getInt("nb_point");


                    // On créé un java bean et on lui définit un nom et un prénom correspond à ceux que l'on vient de récupérer dans la bdd
                    InfoVoie infoVoie = new InfoVoie();
                    infoVoie.setName(name);
                    infoVoie.setHeight(height);
                    infoVoie.setQuotation(quotation);
                    infoVoie.setWay_id(way_id);
                    infoVoie.setSector_id(sector_id);
                    infoVoie.setNb_point(nb_point);


                    // on ajoute cet objet à un array (ou liste) grace à la méthode add. on ajout infoSecteur à infoSecteurs
                    infoVoies.add(infoVoie);
                    // ensuite on boucle encore et encore grace au while jusqu'à tout récupérer
                }
            } catch (SQLException e) {
                e.printStackTrace();
            } return infoVoies;

        }



    }



