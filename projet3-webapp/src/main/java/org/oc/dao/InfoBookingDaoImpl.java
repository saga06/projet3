package org.oc.dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import org.oc.beans.InfoBooking;

// C'est ici que l'on trouve véritablement les requêtes SQL
// Quand on instancie les objets, on récupère la factory
// ce qui permet d'avoir accès directement à l'objet connecté
public class InfoBookingDaoImpl implements InfoBookingDao {
    private DaoFactory daoFactory;

    InfoBookingDaoImpl(DaoFactory daoFactory) {
        this.daoFactory = daoFactory;
    }


    public void ajouter(InfoBooking infoBooking) {
        Connection connexion = null;
        PreparedStatement preparedStatement = null;

        try {
            connexion = daoFactory.getConnection();
            //On récupère l'objet daoFactory.getConnection(), qui représente la connexion,
            // Ainsi on n'a pas besoin de refaire la connexion systématiquement
            // On récupère la connexion qui a déjà été faite en amont dans la factory
            preparedStatement = connexion.prepareStatement("INSERT INTO topo_booking(topo_booking_topo_id,topo_booking_borrower_nickname,topo_booking_date ) VALUES (?, ?, ?);");
            preparedStatement.setInt(1, infoBooking.getTopoBooking_topo_id());
            preparedStatement.setString(2,infoBooking.getBorrower_nickname());
            preparedStatement.setString(3,infoBooking.getDate());

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }



    @Override
    public List<InfoBooking> lister(int ID) {
        List<InfoBooking> infoBookings = new ArrayList<InfoBooking>();
        Connection connexion = null;
        PreparedStatement ps = null;
        ResultSet resultat = null;


        try {
            connexion = daoFactory.getConnection();
            ps = connexion.prepareStatement("SELECT topo_booking_id, topo_booking_topo_id, topo_booking_borrower_nickname, topo_booking_date FROM topo_booking WHERE topo_booking_topo_id = ?");
            ps.setInt(1, ID);

            resultat = ps.executeQuery();



            // Récupération des données
            // On récupère un résultat brut de la bdd difficilement manipulable, donc on en extrait les donnés pour les stocker de manière plus propre et facile à manipuler grace au while
            while (resultat.next()) {
                // on récupère les entrées grace à la méthode getString ou getInt qui permettent de récupérer des données de types string ou int
                //resultat.getString => je m'attends à récupérer une chaine de caractère ou un nombre ou une date etc... puis on les tocke dans des objets de type string, int, etc...
                int topo_id = resultat.getInt("topo_booking_topo_id");
                String borrower_nickname = resultat.getString("topo_booking_borrower_nickname");
                String date = resultat.getString("topo_booking_date");


                // On créé un java bean et on lui définit un nom et un prénom correspond à ceux que l'on vient de récupérer dans la bdd
                InfoBooking infoBooking = new InfoBooking();
                infoBooking.setTopoBooking_topo_id(topo_id);
                infoBooking.setBorrower_nickname(borrower_nickname);
                infoBooking.setDate(date);

                // on ajoute cet objet à un array (ou liste) grace à la méthode add. on ajout infoSecteur à infoSecteurs
                infoBookings.add(infoBooking);
                // ensuite on boucle encore et encore grace au while jusqu'à tout récupérer
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } return infoBookings;

    }



}

