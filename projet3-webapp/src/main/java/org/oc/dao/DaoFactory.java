package org.oc.dao;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.io.InputStream;
import java.util.Properties;

//Dans ce fichier on initialise le DAO, c'est ici qu'on fait la connexion à la bdd
//puis qu'on va préchargé un objet en mémoire où la connexion est déjà faite
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

    private static final String FICHIER_PROPERTIES       = "/dao.properties";
    private static final String PROPERTY_URL             = "url";
    //private static final String PROPERTY_DRIVER          = "driver";
    private static final String PROPERTY_NOM_UTILISATEUR = "nomutilisateur";
    private static final String PROPERTY_MOT_DE_PASSE    = "motdepasse";

    // Dans cette méthode static getInstance(), on charge le driver JDBC et on se connecte à la BDD
    public static DaoFactory getInstance() {
        Properties properties = new Properties();
        String url = null;
        String driver;
        String nomUtilisateur = null ;
        String motDePasse = null ;
        ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
        InputStream fichierProperties = classLoader.getResourceAsStream( FICHIER_PROPERTIES );

        try {
            properties.load( fichierProperties );
            url = properties.getProperty( PROPERTY_URL );
            driver = "org.postgresql.Driver";
            nomUtilisateur = properties.getProperty( PROPERTY_NOM_UTILISATEUR );
            motDePasse = properties.getProperty( PROPERTY_MOT_DE_PASSE );

            //loading drivers for postgreSQL
            Class.forName(driver);
        } catch (ClassNotFoundException e) {
        } catch (IOException e) {
            e.printStackTrace();
        }

        DaoFactory instance = new DaoFactory (url, nomUtilisateur, motDePasse);
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