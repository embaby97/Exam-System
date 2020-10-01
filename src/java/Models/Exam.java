/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Models;

import java.io.IOException;
import java.io.PrintWriter;
import static java.lang.System.out;
import java.sql.Connection;
import java.sql.*;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author A.Embaby
 */
@WebServlet(name = "Exam", urlPatterns = {"/Exam"})
public class Exam extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    private String exam_name;
    private String exam_type;
    private int num_question;
    public static int exam_id;

    public Exam() {
        exam_name = "";
        exam_type = "";
        num_question = 0;
    }

    //----------------------------------//
    public String getExam_name() {
        return exam_name;
    }

    public String getExam_type() {
        return exam_type;
    }

    public Integer getExam_num_question() {
        return num_question;
    }

    //----------------------------------//
    public void setExam_name(String name) {
        this.exam_name = name;
    }

    public void setExam_type(String type) {
        this.exam_type = type;
    }

    public void setExam_type(int num) {
        this.num_question = num;
    }
    //----------------------------------//

    //----------------------------------//
    public static boolean Exam_name(String name, String type) {
        boolean check = false;
        try {
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

            } catch (SQLException e) {
                e.printStackTrace();
            }
            PreparedStatement ps1 = Con.prepareStatement("select * from exam where exam_name=? ");

            ps1.setString(1, name);
            ResultSet rs1 = ps1.executeQuery();
            check = rs1.next();

            if (!check) {
                String sqlString = "INSERT INTO exam (exam_name , exam_type) VALUES "
                        + "('" + name + "','" + type + "')";
                stat.executeUpdate(sqlString);

                ps1 = Con.prepareStatement("select * from exam where exam_name=? ");

                ps1.setString(1, name);
                rs1 = ps1.executeQuery();
                check = rs1.next();

            } else {
                check = false;
            }

            Con.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return check;
    }

    //---------------------------------
    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>
    //----------------------------------//

    public static boolean Add_Q_Exam(String exam_name, String discription) {
        boolean check = false;
        try {
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

            } catch (SQLException e) {
                e.printStackTrace();
            }
            /*SELECT * FROM project_ai.exam e
             select exam_id from project_ai.exam where exam_name='java'*/

            /*PreparedStatement ps1 =Con.prepareStatement("select * from exame where exam_name=? ");

             ps1.setString(1, name);
             ResultSet rs1 =ps1.executeQuery();
             check = rs1.next();
             */
            PreparedStatement ps1 = Con.prepareStatement("select exam_id from exam where exam_name=? ");
            ps1.setString(1, exam_name);
            ResultSet rs1 = ps1.executeQuery();
            check = rs1.next();

            out.println("id === " + exam_id);

            String val = rs1.getString("exam_id");
            exam_id = Integer.parseInt(val);

            if (check) {
                String sqlString = "INSERT INTO quistion (exam_id, q_discription) VALUES "
                        + "('" + exam_id + "','" + discription + "')";
                stat.executeUpdate(sqlString);

                ps1 = Con.prepareStatement("select * from quistion where exam_id=? and q_discription=?");

                ps1.setString(2, discription);
                rs1 = ps1.executeQuery();
                check = rs1.next();

            } else {
                check = false;
            }

            Con.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return check;
    }

    //----------------------------------//
    public static boolean Add_answer_Exam(String exam_name, String Q_discription, String answer, int correct) {
        boolean check = false;
        boolean check_Q = false;
        try {
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

            } catch (SQLException e) {
                e.printStackTrace();
            }

            PreparedStatement ps1 = Con.prepareStatement("select exam_id from exam where exam_name=? ");
            ps1.setString(1, exam_name);
            ResultSet rs1 = ps1.executeQuery();
            check = rs1.next();
            String val = rs1.getString("exam_id");
            exam_id = Integer.parseInt(val);

            //qid, exam_id, q_discription
            PreparedStatement ps2 = Con.prepareStatement("select qid from quistion where q_discription=? ");
            ps2.setString(1, Q_discription);
            ResultSet rs2 = ps2.executeQuery();
            check_Q = rs2.next();
            String val2 = rs2.getString("qid");
            int q_id = Integer.parseInt(val2);

            if (check && check_Q) {
                //a_id, answer, q_id, exam_id, correct
                String sqlString = "INSERT INTO answer (answer, q_id , exam_id , correct) VALUES "
                        + "('" + answer + "','" + q_id + "','" + exam_id + "','" + correct + "')";
                
               /* String sqlString = "INSERT INTO answer (answer, q_id , exam_id , correct) VALUES "
                        + "('mmm','5566','555','1' )";*/
                
                stat.executeUpdate(sqlString);

                /*ps1 = Con.prepareStatement("select * from answer where exam_id=? and answer=?");
                ps1.setString(1, val);
                ps1.setString(2, answer);
                rs1 = ps1.executeQuery();
               // check = rs1.next();*/
                check=true;
            } else {
                check = false;
            }

            Con.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return check;
    }

    private void processRequest(HttpServletRequest request, HttpServletResponse response) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
