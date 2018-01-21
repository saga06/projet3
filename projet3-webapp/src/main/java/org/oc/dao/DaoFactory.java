package org.oc.dao;

import org.oc.beans.InfoComment;
import org.oc.beans.InfoPoint;
import org.oc.beans.InfoVoie;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

//Dans ce fichier on initialise le DAO, c'est ici qu'on fait la connexion à la bdd
// puis qu'on va préchargé un objet en mémoire où la connexion est déjà faite
//
public class DaoFactory {

    private String url;
    private String username;
    private String password;

    DaoFactory(String url, String username, String password) {
        this.url = url;
        this.username = username;
        this.password = password;

    }

    // Dans cette méthode static getInstance(), on charge le driver JDBC et on se connecte à la BDD
    public static DaoFactory getInstance() {
        try {
            Class.forName("org.postgresql.Driver");
        } catch (ClassNotFoundException e) {
        }

        DaoFactory instance = new DaoFactory (
                "jdbc:postgresql://localhost:5432/projet3","postgres", "root");
        return instance;
    }

    // Grace à cette méthode on peut à tout moment récupérer la connexion à la BDD
    public Connection getConnection() throws SQLException {
        return DriverManager.getConnection(url, username, password);
    }

    // Récupération du Dao
    // En gros, récupération des tables de la bdd, ça retourne l'implémentation
    // et ça lui envoie la factory elle même, pour que l'objet (ici l'implémentation) puisse accéder directement
    // à la bdd connectée.
    // on peut y ajouter d'autres méthodes qui accèdent à d'autres tables de la bdd
    // comme getMessageDao, etc...
    public InfoSiteDao getInfoSiteDao() {
        return new InfoSiteDaoImpl(this);
    }
    public InfoSecteurDao getInfoSecteurDao() {
        return  new InfoSecteurDaoImpl(this);
    }
    public InfoVoieDao getInfoVoieDao() {return  new InfoVoieDaoImpl(this);}
    public InfoLongueurDao getInfoLongueurDao() {return  new InfoLongueurDaoImpl(this);}
    public InfoPointDao getInfoPointDao() {return new InfoPointDaoImpl(this);}
    public InfoCommentDao getInfoCommentDao() {return  new InfoCommentDaoImpl(this);}
    public InfoTopoDao getInfoTopoDao() {return  new InfoTopoDaoImpl(this);}
    public InfoBookingDao getInfoBookingDao() {return  new InfoBookingDaoImpl(this);}

}