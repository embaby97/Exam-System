<%-- 
    Document   : add_answer
    Created on : Dec 21, 2019, 9:16:52 PM
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
       <form  id="formp"  action="AddAnswer" method="post" >
            <center>
                <table border="2" width="15%" cellpadding="5">
                    <thead>
                        <tr>
                            <th colspan="2">Add Answers</th>
                        </tr>
                    </thead>
                    <tbody>
                        <tr>    
                            <td>exam name : </td>
                            <td><input type="text" name="exam"  ></td>
                        </tr>
                       <tr>    
                            <td>Question Description : </td>
                            <td><input type="text" name="question"  ></td>
                        </tr>
                        <tr>    
                            <td>Answer Description : </td>
                            <td><input type="text" name="answer"  ></td>
                        </tr>
                        <tr>    
                            <td>True OR False: </td>
                            <td><input type="number" name="flag"  ></td>
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
