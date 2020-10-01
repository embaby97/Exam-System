<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="Models.User"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        
<script src="https://code.jquery.com/jquery-1.10.2.js"
	type="text/javascript"></script>
<script src="appajax.js" type="text/javascript"></script>
        <title>Login Form</title>
         <script>
            
            
   /* $(document).ready(function(){
       $('#login').click(function()
       {   
          var user=$('#name').val();
          var pwd=$('#password').val();
          $.ajax({
               type: "POST",
               url:"LoginController",
               data:{"user":user,"password":pwd},
               success: function (data) {
                  if(data=='True'){
                    $(location).attr('href','welcome_page.jsp');
                  }else{
                      alert('Fail....');
                  }
               }
             });                                
           });
         });*/
   
        </script>
    </head>
    <body>
        
        

        <form  id="formL" onsubmit=" checkform(this);return false" action="LoginController" method="post" >
            <center>
                <table border="2" width="15%" cellpadding="5">
                    <thead>
                        <tr>
                            <th colspan="2">Login Form</th>
                        </tr>
                    </thead>
                    <tbody>
                        <tr>    
                            <td>Username : </td>
                            <td><input type="text" name="user" id="user" ></td>
                        </tr>
                        <tr>
                            <td>Password : </td>
                            <td><input type="password" name="pwd" id="pwd" ></td>
                        </tr>
                        <tr>  
                            <td><center><a href="register_form.jsp">Register</a></center></td>
                <td><center><input type="submit" value="login" id="login"></center></td>
                        </tr>
                    </tbody>             
                </table>
            </center>
        </form>
        <div id="targetDiv" style="display: none;">
            
</div>
         
        <!-- <div style="position: relative">
       <div style="position: fixed ; bottom: 0 ; width:100% ; text-align:center ">
                <p><a href="https://www.youtube.com/user/TechWorld3g?sub_confirmation=1">CLICK HERE TO SUBSCRIBE</a></p>
            </div>
        </div>    -->
       <div id="targetDiv" style="display: none;">
                </div>
                        
    </body>
</html>
