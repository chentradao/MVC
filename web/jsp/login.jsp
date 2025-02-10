<%-- 
    Document   : login
    Created on : Nov 4, 2024, 2:16:49 AM
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
        
        <form action="adminIndexURL" method="post">
            <input type="hidden" name="service" value="login">
                              <p>
                                  UserName: <input type="text" name="userName">
                                  <br>
                                  password:<input type="password" name="pass">
                                  <br>
                              <div style="color: red"><%=(error!=null?error:"")%></div>
                                  <input type="submit" name="Login" value="Login">
                                  
                              </p>
                          </form>
    </body>
</html>
