package org.oc.servlets;

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

        String email = request.getParameter("email");
        String pass = request.getParameter("pass");

        if(Validate.checkUser(email, pass))
        {
            RequestDispatcher rs = request.getRequestDispatcher("/welcome");
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