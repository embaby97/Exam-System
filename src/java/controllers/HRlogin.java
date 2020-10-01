/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;
import Models.HR;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.logging.Level;
import java.util.logging.Logger;
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
@WebServlet(name = "HRlogin", urlPatterns = {"/HRlogin"})
public class HRlogin extends HttpServlet {

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
        response.setContentType("text/html;charset=UTF-8");
            PrintWriter out = response.getWriter();
            try 
            {
                HR hr = new HR();
                hr.setFirst_name(request.getParameter( "user"));
                
                out.print(request.getParameter( "user"));
                out.print(request.getParameter("pwd"));
                hr.setPwd(request.getParameter( "pwd"));
              

                if(hr.Login(request.getParameter("user"),request.getParameter("pwd")))
                {
                    HR us = new HR();
                    us.setFirst_name(String.valueOf(request.getParameter("user")));
                    us.getname();   
//out.print(request.getParameter("user"));
                    HttpSession sessionUser = request.getSession();
                    sessionUser.setAttribute("user",us.getname());
                    
                    
                    out.print("<a href = 'HR_Home_page.jsp'>click</a>");

                   
                }  
                else
                {
                    out.println("username or password is incorrect!");
                    out.println("<a href=\"hr_login.jsp\">Try again...</a>");
                }    
            } finally {out.close();}
        }
        
        @Override
        protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException 
        {
            processRequest(request, response);
        }
        
        @Override
        protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException 
        {
            processRequest(request, response);
        }
        
        @Override
        public String getServletInfo() 
        {
            return "Short description";
        }
}   