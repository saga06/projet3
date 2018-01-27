package org.oc.forms;

import org.oc.bdd.Validate;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.sql.*;

public class Login extends HttpServlet {
    
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        PrintWriter out = response.getWriter();


        String nickname = request.getParameter("nickname");
        String pass = request.getParameter("pass");


        if(Validate.checkUser( nickname,pass))
        {
            HttpSession session = request.getSession();
            session.setAttribute("nickname", nickname);
            RequestDispatcher rs = request.getRequestDispatcher("/accueil");
            rs.forward(request, response);

        }

        else
        {

            RequestDispatcher rs = request.getRequestDispatcher("index.html");
            rs.include(request, response);
            out.println("<div class='messageBox'>Identifiant  ou mot de passe incorrect</div>");

        }
    }

}