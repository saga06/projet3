package org.oc.dao;

import org.oc.beans.InfoTopo;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;


public class InfoTopoDaoImpl implements InfoTopoDao {
    private DaoFactory daoFactory;

    InfoTopoDaoImpl(DaoFactory daoFactory) {
        this.daoFactory = daoFactory;
    }

    @Override
    public void ajouter(InfoTopo infoTopo) {
        Connection connexion = null;
        PreparedStatement preparedStatement = null;

        try {
            connexion = daoFactory.getConnection();
            //On récupère l'objet DAOFactory.getConnection(), qui représente la connexion,
            // Ainsi on n'a pas besoin de refaire la connexion systématiquement
            // On récupère la connexion qui a déjà été faite en amont dans la factory
            preparedStatement = connexion.prepareStatement("INSERT INTO topo( topo_name, description, site_id,owner_nickname) VALUES(?, ?, ?,?);");
            preparedStatement.setString(1, infoTopo.getTopo_name());
            preparedStatement.setString(2, infoTopo.getDescription());
            preparedStatement.setInt(3, infoTopo.getSite_id());
            preparedStatement.setString(4, infoTopo.getOwner_nickname());


            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<InfoTopo> lister() {
        List<InfoTopo> infoTopos = new ArrayList<InfoTopo>();
        Connection connexion = null;
        Statement statement = null;
        ResultSet resultat = null;


        try {
            connexion = daoFactory.getConnection();
            statement = connexion.createStatement();
            resultat = statement.executeQuery("SELECT site.site_id, site.name, topo.topo_name,topo.topo_id,topo.site_id, topo.description, topo.free, topo.owner_nickname,users.nickname FROM site INNER JOIN topo ON site.site_id=topo.site_id  INNER JOIN users ON users.nickname = topo.owner_nickname");

            // Récupération des données
            // On récupère un résultat brut de la bdd difficilement manipulable, donc on en extrait les donnés pour les stocker de manière plus propre et facile à manipuler grace au while
            while (resultat.next()) {
                // on récupère les entrées grace à la méthode getString ou getInt qui permettent de récupérer des données de types string ou int
                //resultat.getString => je m'attends à récupérer une chaine de caractère ou un nombre ou une date etc... puis on les tocke dans des objets de type string, int, etc...
                int site_id = resultat.getInt("site_id");
                String site_name = resultat.getString("name");
                String topo_name = resultat.getString("topo_name");
                int topo_id = resultat.getInt("topo_id");
                String description = resultat.getString("description");
                boolean free = resultat.getBoolean("free");
                String owner_nickname = resultat.getString("owner_nickname");


                // On créé un java bean et on lui définit un nom et un prénom correspond à ceux que l'on vient de récupérer dans la bdd
                InfoTopo infoTopo = new InfoTopo();
                infoTopo.setSite_id(site_id);
                infoTopo.setSite_name(site_name);
                infoTopo.setTopo_name(topo_name);
                infoTopo.setTopo_id(topo_id);
                infoTopo.setDescription(description);
                infoTopo.setFree(free);
                infoTopo.setOwner_nickname(owner_nickname);

                // on ajoute cet objet à un array (ou liste) grace à la méthode add. on ajout infoSite à infoSites
                infoTopos.add(infoTopo);
                // ensuite on boucle encore et encore grace au while jusqu'à tout récupérer
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } return infoTopos;

    }


}





