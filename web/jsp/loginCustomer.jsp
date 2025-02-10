<%-- 
    Document   : loginCustomer
    Created on : Oct 17, 2024, 10:57:59 AM
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
        <%=(error!=null?error:"")%>
        <form action="CustomerURL" method="get">
            <input type="hidden" name="service" value="loginCustomer">
                              <p>
                                  UserName: <input type="text" name="userName">
                                  <br>
                                  password:<input type="password" name="pass">
                                  <br>
                              <div style="color: red"><%=error%></div>
                                  <input type="submit" name="Login" value="Login">
                                  
                              </p>
                          </form>
    </body>
</html>
