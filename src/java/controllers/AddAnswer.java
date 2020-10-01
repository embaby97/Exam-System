/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import Models.Exam;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author A.Embaby
 */
@WebServlet(name = "AddAnswer", urlPatterns = {"/AddAnswer"})
public class AddAnswer extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
           
//    public static boolean Add_answer_Exam(String exam_name, String Q_discription, String answer, boolean correct) {
                Exam e=new Exam ();
               String f= request.getParameter( "flag");
               int flag = Integer.parseInt(f);
                if(e.Add_answer_Exam(request.getParameter("exam") 
                        ,request.getParameter( "question")
                        ,request.getParameter( "answer"),flag))
                {
                    Exam us = new Exam();
                    us.setExam_name(String.valueOf(request.getParameter("exam")));
                    us.getExam_name();   
//out.print(request.getParameter("user"));
                    HttpSession sessionUser = request.getSession();
                    sessionUser.setAttribute("exam",us.getExam_name());
                    
                    
                    out.print("<a href = 'HR_Home_page.jsp'>Home Page</a>");
                    out.print("<a href = 'add_question.jsp'>Add Question</a>");
                    out.print("<a href = 'add_answer.jsp'>Add Answers</a>");

                   
                }  
                else
                {
                    out.println("  invalid already exist!");
                    out.println("<a href=\"add_answer.jsp\">Try again...</a>");
                }
        }
    }

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

}
