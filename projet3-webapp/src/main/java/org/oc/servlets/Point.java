package org.oc.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.oc.beans.InfoPoint;
import org.oc.beans.InfoSecteur;
import org.oc.dao.*;

public class Point extends HttpServlet {

    private InfoPointDao infoPointDao;

    // Cette méthode init() appelée au début de la servlet, au moment du chargement de la servlet
    // avant même les méthodes doGet ou doPost, elle appelle la méthode DaoFactory.getInstance()
    // pour créer un nouvel objet daoFactory qui sera du coup connecté et on
    // va stocker l'objet qui est l'implementation d'infositeDao
    // ce qui permet ensuite d'appeler infoSiteDao.ajouter() ou .lister()
    public void init() throws ServletException {
        DaoFactory daoFactory = DaoFactory.getInstance();
        this.infoPointDao = daoFactory.getInfoPointDao();

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws
            ServletException, IOException {
        //On appelle la méthode infosecteurdao.lister() qui va renvoyer une liste d'objet infosecteur que l'on transmet ensuite à la jsp pour afficher les infos de la table
        // Ainsi la jsp possède une liste d'infosites dans laquelle on va faire une boucle
        int ID = Integer.parseInt(request.getParameter("ID"));
        request.setAttribute("ID", ID);
        request.setAttribute("infoPoints", infoPointDao.lister(ID));
        this.getServletContext().getRequestDispatcher("/WEB-INF/views/points.jsp").forward(request,response);
    }


    public void doPost( HttpServletRequest request, HttpServletResponse response ) throws ServletException, IOException {

        InfoPoint infoPoint = new InfoPoint();
        infoPoint.setName(request.getParameter("name"));
        infoPoint.setLength_id(Integer.parseInt(request.getParameter("length_id")));

        infoPoint.setDescription(request.getParameter("description"));
        infoPointDao.ajouter(infoPoint);

        int ID = infoPoint.getLength_id();
        request.setAttribute("infoPoints", infoPointDao.lister(ID));

        response.sendRedirect("/points?ID="+ID);

    }




}
