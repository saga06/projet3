package org.oc.bdd;

import java.sql.*;

public class Validate
{
    public static boolean checkUser(String email,String pass)
    {
        boolean st =false;
        try{

            //loading drivers for mysql
            Class.forName("org.postgresql.Driver");


            //creating connection with the database
            Connection con=DriverManager.getConnection
                    ("jdbc:postgresql://localhost:5432/projet3","postgres","root");

            PreparedStatement ps = con.prepareStatement
                    ("select * from users where email=? and pass=?");
            ps.setString(1, email);
            ps.setString(2, pass);
            ResultSet rs = ps.executeQuery();
            st = rs.next();

        }catch(Exception e)
        {
            e.printStackTrace();
        }
        return st;
    }
}