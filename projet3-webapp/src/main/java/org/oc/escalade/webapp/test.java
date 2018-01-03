package org.oc.escalade.webapp;

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



public class test extends HttpServlet {



    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //Noms tableNoms = new Noms();
        Sites tableSites = new Sites();

        //request.setAttribute("utilisateurs", tableNoms.recupererUtilisateurs());
        request.setAttribute("infoSites", tableSites.recupererInfoSites());


        this.getServletContext().getRequestDispatcher("/WEB-INF/sites.jsp").forward(request,response);
    }


    public void doPost( HttpServletRequest request, HttpServletResponse response ) throws ServletException, IOException {
        //Utilisateur utilisateur = new Utilisateur();
        InfoSite infoSite = new InfoSite();

        //utilisateur.setNom(request.getParameter("nom"));
        infoSite.setName(request.getParameter("name"));

        //utilisateur.setPrenom(request.getParameter("prenom"));
        infoSite.setLocation(request.getParameter("location"));

        //Noms tableNoms = new Noms();
        Sites tableSites = new Sites();


        //tableNoms.ajouterUtilisateur(utilisateur);
        tableSites.addInfoSite(infoSite);

        //request.setAttribute("utilisateurs", tableNoms.recupererUtilisateurs());
        request.setAttribute("infoSites", tableSites.recupererInfoSites());

        this.getServletContext().getRequestDispatcher("/WEB-INF/sites.jsp").forward(request,response);

    }




}
