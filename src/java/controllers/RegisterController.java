package controllers;

import Models.User;
import java.io.IOException;
import java.io.PrintWriter;
import static java.lang.System.out;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = {"/RegisterController"})
public class RegisterController extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, ClassNotFoundException, InstantiationException, IllegalAccessException {

        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();

        try {

            User user = new User();

            /* user.setFirst_name(String.valueOf(request.getParameter("first_name")));//                user.setFirst_name(String.valueOf(request.getParameter("first_name")));//
             user.setLast_name(request.getParameter("last_name"));
             user.setUser(request.getParameter("user"));
             user.setPwd(request.getParameter("pwd"));*/
            out.println("<br>");
            out.println("<br>");
            out.println("<center>Great!!! </center>" + String.valueOf(user.getFirst_name())
                    + "','" + user.getLast_name() + "','" + user.getPwd());
                 //out.println(String.valueOf(user.getFirst_name())+"','"+user.getLast_name()+"','"+user.getPwd());

            // user.RegisterUser(request.getParameter("first_name") ,request.getParameter("last_name") , request.getParameter("user") , request.getParameter("pwd") );
            User.SignupUser(request.getParameter("fullname"),
                    request.getParameter("email"),
                    request.getParameter("username"),
                    request.getParameter("password"));

            out.println("<br>");
            out.println("<br>");
            out.println("<center>Great!!!</center>");
            //  RequestDispatcher rd = request.getRequestDispatcher("login_form.jsp");
            //rd.forward(request,response);
        } finally {
            out.close();
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(LoginController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            Logger.getLogger(LoginController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            Logger.getLogger(LoginController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(LoginController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            Logger.getLogger(LoginController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            Logger.getLogger(LoginController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }

}
