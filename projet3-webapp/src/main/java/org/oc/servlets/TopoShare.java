package org.oc.servlets;

import java.io.IOException;

import org.oc.beans.InfoBooking;
import org.oc.beans.InfoTopo;
import org.oc.dao.*;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class TopoShare extends HttpServlet {

    private InfoBookingDao infoBookingDao;

    public void init() throws ServletException {
        DaoFactory daoFactory = DaoFactory.getInstance();
        this.infoBookingDao= daoFactory.getInfoBookingDao();

    }


    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int ID = Integer.parseInt(request.getParameter("ID"));
        request.setAttribute("ID", ID);
        request.setAttribute("infoBookings",infoBookingDao.lister(ID));
        this.getServletContext().getRequestDispatcher("/WEB-INF/views/topos-share.jsp").forward(request, response);
    }


    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        InfoBooking infoBooking = new InfoBooking();
        infoBooking.setTopoBooking_topo_id(Integer.parseInt(request.getParameter("topo_id")));
        infoBooking.setBorrower_nickname(request.getParameter("nickname"));
        //infoBooking.setDate(Integer.parseInt(request.getParameter("date")));
        infoBooking.setDate(request.getParameter("date"));
        infoBookingDao.ajouter(infoBooking);

        int ID = infoBooking.getTopoBooking_topo_id();
        request.setAttribute("infoBookings", infoBookingDao.lister(ID));
        response.sendRedirect("/topos-share?ID="+ID);

    }

}
