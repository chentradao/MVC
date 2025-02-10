<%-- 
    Document   : loginEmployees
    Created on : Oct 20, 2024, 10:32:41 AM
    Author     : nguye
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
         <%
            String error = (String)request.getAttribute("error");
        %>
        <form action="EmployeeURL" method="get">
            <input type="hidden" name="service" value="loginEmployees">
                              <p>
                                  UserName: <input type="number" name="userName">
                                  <br>
                                  password:<input type="password" name="pass">
                                  <br>
                              <p style="color: red"><%=(error!=null?error:"")%></p>
                                  <input type="submit" name="Login" value="Login">
                                  
                              </p>
                          </form>
    </body>
</html>
