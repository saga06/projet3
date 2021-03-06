package org.oc.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.oc.beans.InfoVoie;
import org.oc.dao.*;

public class Voie extends HttpServlet {

    private InfoVoieDao infoVoieDao;

    // Cette méthode init() appelée au début de la servlet, au moment du chargement de la servlet
    // avant même les méthodes doGet ou doPost, elle appelle la méthode DaoFactory.getInstance()
    // pour créer un nouvel objet daoFactory qui sera du coup connecté et on
    // va stocker l'objet qui est l'implementation d'infositeDao
    // ce qui permet ensuite d'appeler infoSiteDao.ajouter() ou .lister()
    public void init() throws ServletException {
        DaoFactory daoFactory = DaoFactory.getInstance();
        this.infoVoieDao = daoFactory.getInfoVoieDao();

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws
            ServletException, IOException {
        //On appelle la méthode infosecteurdao.lister() qui va renvoyer une liste d'objet infosecteur que l'on transmet ensuite à la jsp pour afficher les infos de la table
        // Ainsi la jsp possède une liste d'infosites dans laquelle on va faire une boucle
        int ID = Integer.parseInt(request.getParameter("ID"));
        request.setAttribute("ID", ID);
        request.setAttribute("infoVoies", infoVoieDao.lister(ID));
        this.getServletContext().getRequestDispatcher("/WEB-INF/views/voies.jsp").forward(request,response);
    }


    public void doPost( HttpServletRequest request, HttpServletResponse response ) throws ServletException, IOException {

        InfoVoie infoVoie = new InfoVoie();
        infoVoie.setName(request.getParameter("name"));
        infoVoie.setHeight(Integer.parseInt(request.getParameter("height")));
        infoVoie.setQuotation(request.getParameter("quotation"));
        infoVoie.setSector_id(Integer.parseInt(request.getParameter("sector_id")));
        infoVoie.setNb_point((Integer.parseInt(request.getParameter("nb_point"))));
        infoVoieDao.ajouter(infoVoie);


        int ID = infoVoie.getSector_id();
        request.setAttribute("infoVoies", infoVoieDao.lister(ID));

        response.sendRedirect("/voies?ID="+ID);

        }




}
