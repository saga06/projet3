import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.sql.*;

public class Register extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();

        String firstname = request.getParameter("firstname");
        String surname = request.getParameter("surname");
        String email = request.getParameter("email");
        String pass = request.getParameter("pass");

        try{

            //loading drivers for mysql
            Class.forName("org.postgresql.Driver");


            //creating connection with the database
            Connection con=DriverManager.getConnection
                    ("jdbc:postgresql://localhost:5432/projet3","postgres","root");

            PreparedStatement ps=con.prepareStatement
                    ("insert into users(email,pass,firstname,surname) values(?,?,?,?)");



            ps.setString(1, email);
            ps.setString(2, pass);
            ps.setString(3, firstname);
            ps.setString(4, surname);
            int i=ps.executeUpdate();

            if(i>0)
            {
                RequestDispatcher rs = request.getRequestDispatcher("/Welcome");
                rs.forward(request, response);
                out.println("Vous êtes maintenant membre de notre communauté !");
            }

        }
        catch(Exception se)
        {
            se.printStackTrace();
        }

    }
}