<%-- 
    Document   : adminPanner
    Created on : Nov 3, 2024, 9:28:39 PM
    Author     : nguye
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="entity.Employees" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <style>
            table 
            {
                border-collapse: collapse; 
                width: 100%; 
            } 
            th, td
            { 
                padding: 8px;
            }
        </style>
    </head>
    <body>
        <%
            Employees emp = (Employees)request.getAttribute("emp");
        %>
        <table>
            <%if(emp == null){%>
        <tr>
            <td colspan="2">rollNumber</td>
            <td colspan="2">Welcome</td>
        
        </tr>
        <tr class="pannerBottom">
            <td><a href="adminIndexURL?service=login">login</a></td>
            <td><a href="CustomerURL?service=logout">logout</a></td>
        </tr>
        <%}else{%>
            <tr>
            <td colspan="2">rollNumber: <%= emp.getEmployeeID() %></td>
            <td colspan="2">Welcome: <%= emp.getLastName() %></td>
        
        </tr>
        <tr class="pannerBottom">
            <td><a href="CustomerURL?service=logout">logout</a></td>
        </tr>
        <%}%>
        </table>
    </body>
</html>
