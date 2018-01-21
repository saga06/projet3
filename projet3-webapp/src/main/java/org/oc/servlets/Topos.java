package org.oc.servlets;

import java.io.IOException;
import org.oc.beans.InfoTopo;
import org.oc.dao.InfoSiteDao;
import org.oc.dao.InfoTopoDao;
import org.oc.dao.DaoFactory;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class Topos extends HttpServlet {

    private InfoTopoDao infoTopoDao;
    private InfoSiteDao infoSiteDao;

    public void init() throws ServletException {
        DaoFactory daoFactory = DaoFactory.getInstance();
        this.infoTopoDao = daoFactory.getInfoTopoDao();
        this.infoSiteDao = daoFactory.getInfoSiteDao();

    }


    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("infoTopos",infoTopoDao.lister());
        request.setAttribute("infoSites", infoSiteDao.lister());
        this.getServletContext().getRequestDispatcher("/WEB-INF/views/topos.jsp").forward(request, response);
    }


    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        InfoTopo infoTopo = new InfoTopo();
        infoTopo.setTopo_name(request.getParameter("topo_name"));
        infoTopo.setDescription(request.getParameter("description"));
        //infoTopo.setFree(Boolean.parseBoolean(request.getParameter("free")));
        infoTopo.setSite_id(Integer.parseInt(request.getParameter("site_id")));
        infoTopo.setOwner_nickname(request.getParameter("owner_nickname"));

        infoTopoDao.ajouter(infoTopo);
        request.setAttribute("infoTopos", infoTopoDao.lister());
        request.setAttribute("infoSites", infoSiteDao.lister());
        this.getServletContext().getRequestDispatcher("/WEB-INF/views/topos.jsp").forward(request, response);

    }

}
