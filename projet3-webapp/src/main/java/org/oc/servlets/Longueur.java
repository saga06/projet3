package org.oc.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.oc.beans.InfoLongueur;
import org.oc.beans.InfoSecteur;
import org.oc.dao.*;

public class Longueur extends HttpServlet {

    private InfoLongueurDao infoLongueurDao;

    // Cette méthode init() appelée au début de la servlet, au moment du chargement de la servlet
    // avant même les méthodes doGet ou doPost, elle appelle la méthode DaoFactory.getInstance()
    // pour créer un nouvel objet daoFactory qui sera du coup connecté et on
    // va stocker l'objet qui est l'implementation d'infositeDao
    // ce qui permet ensuite d'appeler infoSiteDao.ajouter() ou .lister()
    public void init() throws ServletException {
        DaoFactory daoFactory = DaoFactory.getInstance();
        this.infoLongueurDao = daoFactory.getInfoLongueurDao();

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws
            ServletException, IOException {
        //On appelle la méthode infosecteurdao.lister() qui va renvoyer une liste d'objet infosecteur que l'on transmet ensuite à la jsp pour afficher les infos de la table
        // Ainsi la jsp possède une liste d'infosites dans laquelle on va faire une boucle
        int ID = Integer.parseInt(request.getParameter("ID"));
        request.setAttribute("ID", ID);
        request.setAttribute("infoLongueurs", infoLongueurDao.lister(ID));
        this.getServletContext().getRequestDispatcher("/WEB-INF/views/longueurs.jsp").forward(request,response);
    }


    public void doPost( HttpServletRequest request, HttpServletResponse response ) throws ServletException, IOException {

        InfoLongueur infoLongueur = new InfoLongueur();
        infoLongueur.setName(request.getParameter("name"));
        infoLongueur.setWay_id(Integer.parseInt(request.getParameter("way_id")));
        infoLongueur.setDescription(request.getParameter("description"));
        infoLongueurDao.ajouter(infoLongueur);

        int ID = infoLongueur.getWay_id();
        request.setAttribute("infoLongueurs", infoLongueurDao.lister(ID));

        response.sendRedirect("/longueurs?ID="+ID);

    }




}
