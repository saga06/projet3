package org.oc.escalade.webapp;

import org.oc.sites.Site;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;


public class test extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //Récupérer le name dans la barre d'adresse :
        String name = request.getParameter("name");
        request.setAttribute("name",name);

        Site site = new Site();
        site.setName("premier");
        site.setPlace("Nice");
        site.setZipcode(06000);
        site.setDescription("un très beau site d'escalade");
        site.setLatitude("43° 41' 20\" N");
        site.setLongitude("7° 17' 39\" E");
        request.setAttribute("site",site);
        this.getServletContext().getRequestDispatcher("/WEB-INF/sites.jsp").forward(request,response);
    }
}
