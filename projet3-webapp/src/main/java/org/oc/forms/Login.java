package org.oc.forms;

import org.oc.bdd.Validate;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.sql.*;

public class Login extends HttpServlet {
    
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();

        String nickname = request.getParameter("nickname");
        String pass = request.getParameter("pass");


        if(Validate.checkUser(nickname, pass))
        {
            HttpSession session = request.getSession();
            session.setAttribute("nickname", nickname);
            RequestDispatcher rs = request.getRequestDispatcher("/accueil");
            rs.forward(request, response);

        }

        else
        {
            out.println("Identifiant ou mot de passe incorrect");
            RequestDispatcher rs = request.getRequestDispatcher("/");
            rs.include(request, response);
        }
    }

}