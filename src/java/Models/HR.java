/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Models;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author A.Embaby
 */
@WebServlet(name = "HR", urlPatterns = {"/HR"})

public class HR 
{
    private String username,password;
    
    public HR()
    {
        username="";
        password="";

    }        
 
    //----------------------------------//
    
    public String getname() 
    {
        return username;
    }
   
    public String getPassword() 
    {
        return password;
    }
    
    //----------------------------------//
    
    public void setFirst_name(String first_name) 
    {
        this.username =first_name;
    }

    public void setPwd(String pwd) 
    {
        this.password=pwd;
    }
    
    //----------------------------------//
    
    //----------------------------------//
    
    public static boolean Login(String user,String pwd) 
    {
            boolean check =false;
            try 
            {      
            String user_name = "root";
            String pass = "root";
            Connection Con = null;
            Statement stat = null;
            String dataBaseName = "project_ai";
            String url = "jdbc:mysql://localhost:3306/" + dataBaseName;
            try {

                Class.forName("com.mysql.jdbc.Driver").newInstance();

                Con = DriverManager.getConnection(url, user_name, pass);

                stat = Con.createStatement();
                
            }
            catch (SQLException e) {
                e.printStackTrace();
            }
                 
            
//select * from hr where username='lulu' and password='lulu'//select * from hr where username=? and password=?
                PreparedStatement ps1 =Con.prepareStatement("select * from hr where username=? and password=?");

                ps1.setString(1, user);
                ps1.setString(2, pwd);
                ResultSet rs1 =ps1.executeQuery();
                check = rs1.next();

                Con.close();        
            }catch(Exception e){e.printStackTrace();}
            
            return check;    
    }
    
    //----------------------------------//
    
    //----------------------------------//
    
    public void GetUser() throws ClassNotFoundException, InstantiationException, IllegalAccessException
    {
            try 
            {      
             String user_name = "root";
            String pass = "root";
            Connection Con = null;
            Statement stat = null;
            String dataBaseName = "project_ai";
            String url = "jdbc:mysql://localhost:3306/" + dataBaseName;
            try {

                Class.forName("com.mysql.jdbc.Driver").newInstance();

                Con = DriverManager.getConnection(url, user_name, pass);

                stat = Con.createStatement();
                
            }
            catch (SQLException e) {
                e.printStackTrace();
            }
                
                String sqlString = "SELECT * FROM hr WHERE username = '"+username+"'";
                Statement myStatement = Con.createStatement();
                ResultSet rs=myStatement.executeQuery(sqlString);

                while(rs.next())
                {
                    username= rs.getString("username");
                    password = rs.getString("password");
                }
                
                myStatement.close();
                Con.close();
                
            } catch (SQLException ex) {Logger.getLogger(User.class.getName()).log(Level.SEVERE, null, ex);} 
            
    }
}
    
    //----------------------------------//

