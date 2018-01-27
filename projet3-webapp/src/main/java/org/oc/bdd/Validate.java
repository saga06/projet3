package org.oc.bdd;


import java.sql.*;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Properties;

public class Validate
    //this class is ONLY for the login verification part of the app
{
    private static final String FICHIER_PROPERTIES       = "/dao.properties";
    private static final String PROPERTY_URL             = "url";
    private static final String PROPERTY_DRIVER          = "driver";
    private static final String PROPERTY_NOM_UTILISATEUR = "nomutilisateur";
    private static final String PROPERTY_MOT_DE_PASSE    = "motdepasse";


    public static boolean checkUser(String nickname,String pass)
    {

        boolean st =false;
        Properties properties = new Properties();
        String url;
        String driver;
        String nomUtilisateur;
        String motDePasse;
        ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
        InputStream fichierProperties = classLoader.getResourceAsStream( FICHIER_PROPERTIES );

        try{

            properties.load( fichierProperties );
            url = properties.getProperty( PROPERTY_URL );
            driver = properties.getProperty( PROPERTY_DRIVER );
            nomUtilisateur = properties.getProperty( PROPERTY_NOM_UTILISATEUR );
            motDePasse = properties.getProperty( PROPERTY_MOT_DE_PASSE );

            //loading drivers for postgreSQL
            Class.forName(driver);

            //creating connection with the database
            Connection con=DriverManager.getConnection
                    (url, nomUtilisateur, motDePasse);

            PreparedStatement ps = con.prepareStatement
                    ("select * from users where nickname=? and pass=?");

            ps.setString(1, nickname);
            ps.setString(2, pass);
            ResultSet rs = ps.executeQuery();
            st = rs.next();

        }catch(Exception e)
        {
            e.printStackTrace();
        }
        return st;
    }
}

