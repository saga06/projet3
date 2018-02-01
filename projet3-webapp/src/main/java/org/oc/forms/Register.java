package org.oc.forms;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.sql.*;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Properties;

public class Register extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();

        String firstname = request.getParameter("firstname");
        String surname = request.getParameter("surname");
        String email = request.getParameter("email");
        String pass = request.getParameter("pass");
        String nickname = request.getParameter("nickname");

        String FICHIER_PROPERTIES       = "/dao.properties";
        //String PROPERTY_URL             = "url";
        //String PROPERTY_DRIVER          = "driver";
        String PROPERTY_NOM_UTILISATEUR = "nomutilisateur";
        String PROPERTY_MOT_DE_PASSE    = "motdepasse";

        Properties properties = new Properties();
        String url;
        String driver;
        String nomUtilisateur;
        String motDePasse;
        ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
        InputStream fichierProperties = classLoader.getResourceAsStream( FICHIER_PROPERTIES );

        try{
            properties.load( fichierProperties );
            url = "jdbc:postgresql://localhost:5432/projet3";
            driver = "org.postgresql.Driver";
            nomUtilisateur = properties.getProperty( PROPERTY_NOM_UTILISATEUR );
            motDePasse = properties.getProperty( PROPERTY_MOT_DE_PASSE );

            //loading drivers for mysql
            Class.forName(driver);

            //creating connection with the database
            Connection con=DriverManager.getConnection
                    (url, nomUtilisateur, motDePasse);


            PreparedStatement ps=con.prepareStatement
                    ("insert into users(email,pass,firstname,surname,nickname) values(?,?,?,?,?)");



            ps.setString(1, email);
            ps.setString(2, pass);
            ps.setString(3, firstname);
            ps.setString(4, surname);
            ps.setString(5, nickname);

            int i=ps.executeUpdate();

            if(i>0)
            {
                response.sendRedirect("/welcome");
            }

        }
        catch(Exception se)
        {
            se.printStackTrace();
        }

    }
}