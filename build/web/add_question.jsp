<%-- 
    Document   : add_question
    Created on : Dec 21, 2019, 4:33:46 PM
    Author     : A.Embaby
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <form  id="forml"  action="AddQuestion" method="post" >
            <center>
                <table border="2" width="15%" cellpadding="5">
                    <thead>
                        <tr>
                            <th colspan="2">Add Question</th>
                        </tr>
                    </thead>
                    <tbody>
                        <tr>    
                            <td>exam name : </td>
                            <td><input type="text" name="exam"  ></td>
                        </tr>
                       <tr>    
                            <td>Question : </td>
                            <td><input type="text" name="question"  ></td>
                        </tr>
                        
                        <tr>  
                            <td><center></center></td>
                <td><center><input type="submit" value="submit"></center></td>
                        </tr>
                    </tbody>             
                </table>
            </center>
        </form>
    </body>
</html>
