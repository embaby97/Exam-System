/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Models;

import static java.lang.System.out;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author LOL
 */
public class User 
{
    private String first_name,last_name,user,pwd;
    
    public User()
    {
        first_name="";
        last_name="";
        user="";
        pwd="";
    }        
 
    //----------------------------------//
    
    public String getFirst_name() 
    {
        return first_name;
    }
    
    public String getLast_name() 
    {
        return last_name;
    }

    public String getUser() 
    {
        return user;
    }

    public String getPwd() 
    {
        return pwd;
    }
    
    //----------------------------------//
    
    public void setFirst_name(String first_name) 
    {
        this.first_name =first_name;
    }

    public void setLast_name(String last_name) 
    {
        this.last_name =last_name;
    }

    public void setUser(String user) 
    {
        this.user=user;
    }

    public void setPwd(String pwd) 
    {
        this.pwd=pwd;
    }
    
    //----------------------------------//
      
    public void RegisterUser(String s_name,String l_name, String user,String pwd) throws ClassNotFoundException, InstantiationException, IllegalAccessException
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
            out.println(s_name+"','"+l_name+"','"+user+"','"+pwd);
            
            String sqlString="INSERT INTO users (first_name,last_name,username,password) VALUES "
                    + "('"+s_name+"','"+l_name+"','"+user+"','"+pwd+"')";
            
            stat.executeUpdate(sqlString);
            
            try
            {    
                //myStatement.executeUpdate(sqlString);
                stat.close();
                Con.close();
            } catch (SQLException ex) {Logger.getLogger(User.class.getName()).log(Level.SEVERE, null, ex);}
        } catch (SQLException ex) {Logger.getLogger(User.class.getName()).log(Level.SEVERE, null, ex);}  
    }
    
    //----------------------------------//
    
    public static boolean LoginUser(String user,String pwd) 
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
                 
         

                PreparedStatement ps1 =Con.prepareStatement("select * from users where username=? and password=?");

                ps1.setString(1, user);
                ps1.setString(2, pwd);
                ResultSet rs1 =ps1.executeQuery();
                check = rs1.next();

                Con.close();        
            }catch(Exception e){e.printStackTrace();}
            
            return check;    
    }
    
    //----------------------------------//
    public static boolean SignupUser(String f,String l_name,String user,String pwd) 
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
                 
            String sqlString="INSERT INTO users (first_name,last_name,username,password) VALUES "
                    + "('"+f+"','"+l_name+"','"+user+"','"+pwd+"')";
                    stat.executeUpdate(sqlString);

                PreparedStatement ps1 =Con.prepareStatement("select * from users where username=? and password=?");

                ps1.setString(1, user);
                ps1.setString(2, pwd);
                ResultSet rs1 =ps1.executeQuery();
                check = rs1.next();

                Con.close();        
            }catch(Exception e){e.printStackTrace();}
            
            return check;    
    }
    
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
                
                String sqlString = "SELECT * FROM users WHERE username = '"+user+"'";
                Statement myStatement = Con.createStatement();
                ResultSet rs=myStatement.executeQuery(sqlString);

                while(rs.next())
                {
                    first_name= rs.getString("first_name");
                    last_name = rs.getString("last_name");
                    user= rs.getString("username");
                    pwd = rs.getString("password");
                }
                
                myStatement.close();
                Con.close();
                
            } catch (SQLException ex) {Logger.getLogger(User.class.getName()).log(Level.SEVERE, null, ex);} 
            
    }
    
    //----------------------------------//

}