<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="Models.User"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Welcome Page</title>
    </head>
    <body>
        
        <%  
            HttpSession sessionUser=request.getSession(false);  
            String us= (String) sessionUser.getAttribute("user");
            
            User user_of_techworld3g = new User();
            
            
            out.print("Welcome ");
            out.print("Username "+us);
            out.print(" ");
           
            out.print("!!!");
        %>
                
        <br><br>
        <a href="logout.jsp">Log Out</a>
        <br><br>
        
        <div style="position: relative">
            <div style="position: fixed ; bottom: 0 ; width:100% ; text-align:center ">
                <p><a href="https://www.youtube.com/user/TechWorld3g?sub_confirmation=1">CLICK HERE TO SUBSCRIBE</a></p>
            </div>
        </div>    
                    
    </body>
</html>
