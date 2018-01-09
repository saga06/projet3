package org.oc.forms;

import org.oc.bdd.Sites;
import org.oc.beans.InfoSite;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;



public class Test extends HttpServlet {



    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //Pour la récupération de données en BDD, on créé un objet de type "Sites" qui correspond à la connection à la BDD et effectue la requête SQL.
        //Cet objet est volontairement séparé de la servlet pour éviter de mélanger le code sql et le controleur
        Sites tableSites = new Sites();

        //On appelle la méthode recupererInfosites() qui va renvoyer une liste d'objet infosite que l'on transmet ensuite à la jsp pour afficher les infos de la table
        // Ainsi la jsp possède une liste d'infosites dans laquelle on va faire une boucle
        request.setAttribute("infoSites", tableSites.recupererInfoSites());


        this.getServletContext().getRequestDispatcher("/WEB-INF/views/sites.jsp").forward(request,response);
    }


    public void doPost( HttpServletRequest request, HttpServletResponse response ) throws ServletException, IOException {
        InfoSite infoSite = new InfoSite();

        infoSite.setName(request.getParameter("name"));

        infoSite.setLocation(request.getParameter("location"));

        infoSite.setZipcode(Integer.parseInt(request.getParameter("zipcode")));

        infoSite.setDescription(request.getParameter("description"));

        infoSite.setLatitude(request.getParameter("latitude"));

        infoSite.setLongitude(request.getParameter("longitude"));


        Sites tableSites = new Sites();


        tableSites.addInfoSite(infoSite);

        request.setAttribute("infoSites", tableSites.recupererInfoSites());

        this.getServletContext().getRequestDispatcher("/WEB-INF/views/sites.jsp").forward(request,response);

    }




}
