<%-- 
    Document   : banner
    Created on : Oct 31, 2024, 11:51:25 AM
    Author     : nguye
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="entity.Customer" %>
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
        <%Customer cus = (Customer)session.getAttribute("cus");%>
        <table>
            <%if(cus == null){%>
        <tr>
            <td colspan="2">rollNumber</td>
            <td colspan="2">Welcome</td>
        
        </tr>
        <tr class="pannerBottom">
            <td><a href="adminIndexURL?service=login">login</a></td>
            <td><a href="CustomerURL?service=logout">logout</a></td>
            <td><a href="CustomerURL?service=insertCustomer">Register</a></td>
            <td><a href="CartURL?service=showCart">Cart</a></td>
        </tr>
        <%}else{%>
            <tr>
            <td colspan="2">rollNumber: <%= cus.getCustomerID() %></td>
            <td colspan="2">Welcome: <%= cus.getContactName() %></td>
        
        </tr>
        <tr class="pannerBottom">
            <td><a href="adminIndexURL?service=login">login</a></td>
            <td><a href="CustomerURL?service=logout">logout</a></td>
            <td><a href="indexURL?service=Information">Accout Information</a></td>
            <td><a href="CartURL?service=showCart">Cart</a></td>
        </tr>
        <%}%>
        </table>
    </body>
</html>
