package org.oc.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.oc.beans.InfoComment;
import org.oc.beans.InfoSecteur;
import org.oc.dao.*;

public class Secteur extends HttpServlet {

    private InfoSecteurDao infoSecteurDao;
    private InfoCommentDao infoCommentDao;


    // Cette méthode init() appelée au début de la servlet, au moment du chargement de la servlet
    // avant même les méthodes doGet ou doPost, elle appelle la méthode DaoFactory.getInstance()
    // pour créer un nouvel objet daoFactory qui sera du coup connecté et on
    // va stocker l'objet qui est l'implementation d'infositeDao
    // ce qui permet ensuite d'appeler infoSiteDao.ajouter() ou .lister()
    public void init() throws ServletException {
        DaoFactory daoFactory = DaoFactory.getInstance();
        this.infoSecteurDao = daoFactory.getInfoSecteurDao();
        this.infoCommentDao = daoFactory.getInfoCommentDao();

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws
            ServletException, IOException {
        //On appelle la méthode infosecteurdao.lister() qui va renvoyer une liste d'objet infosecteur que l'on transmet ensuite à la jsp pour afficher les infos de la table
        // Ainsi la jsp possède une liste d'infosites dans laquelle on va faire une boucle
        int ID = Integer.parseInt(request.getParameter("ID"));
        request.setAttribute("ID", ID);
        request.setAttribute("infoSecteurs", infoSecteurDao.lister(ID));
        request.setAttribute("infoComments", infoCommentDao.lister(ID));
        this.getServletContext().getRequestDispatcher("/WEB-INF/views/secteurs.jsp").forward(request,response);
    }


    public void doPost( HttpServletRequest request, HttpServletResponse response ) throws ServletException, IOException {

        String hiddenParam=request.getParameter("Parameter-Name");

        if(hiddenParam.equals("value1"))
        {
            InfoSecteur infoSecteur = new InfoSecteur();
            infoSecteur.setName(request.getParameter("name"));
            infoSecteur.setSite_id(Integer.parseInt(request.getParameter("site_id")));
            infoSecteur.setDescription(request.getParameter("description"));
            infoSecteurDao.ajouter(infoSecteur);

            int ID = infoSecteur.getSite_id();
            request.setAttribute("infoSecteurs", infoSecteurDao.lister(ID));

            response.sendRedirect("/secteurs?ID="+ID);
        }
        else if (hiddenParam.equals("value2"))
        {
            InfoComment infoComment = new InfoComment();
            infoComment.setContent(request.getParameter("content"));
            infoComment.setSite_id(Integer.parseInt(request.getParameter("site_id")));
            infoComment.setUser_nickname(request.getParameter("user_nickname"));
            infoCommentDao.ajouter(infoComment);

            int ID = infoComment.getSite_id();
            request.setAttribute("infoComments", infoCommentDao.lister(ID));

            response.sendRedirect("/secteurs?ID="+ID);         }


    }




}
