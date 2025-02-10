<%-- 
    Document   : CustomerID
    Created on : Oct 18, 2024, 11:45:35 AM
    Author     : nguye
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="entity.Customer,java.util.Vector" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <%
            Customer cus = (Customer)request.getAttribute("cus");
        %>
        <h2 align="right">
            <%if(cus==null){%>
                <a href="CustomerURL?service=loginCustomer">login</a>
            <%}else{%>
            <a href="CustomerURL?service=logoutCustomer">logout</a>
            <br>
            <h1 align="center" style="color: red">Hello <%= cus.getContactName() %></h1>
            <%}%>
        </h2>
        <table border 1px>
                          <tr>
                              <th>CustomerID</th>
                              <th>CompanyName</th>
                              <th>ContactName</th>
                              <th>ContactTitle</th>
                              <th>Address</th>
                              <th>City</th>
                              <th>Region</th>
                              <th>PostalCode</th>
                              <th>Country</th>
                              <th>Phone</th>
                              <th>Fax</th>
                              <th>CustomerStatus</th>
                          </tr>
            
            <tr>
                                <td><%= cus.getCustomerID() %></td>
                                <td><%= cus.getCompanyName() %></td>
                                <td><a href="indexURL?service=findOrder&cid=<%= cus.getCustomerID() %>" style="text-decoration: none"><%= cus.getContactName() %></a></td>
                                <td><%= cus.getContactTitle() %></td>
                                <td><%= cus.getAddress() %></td>
                                <td><%= cus.getCity() %></td>
                                <td><%= cus.getRegion() %></td>
                                <td><%= cus.getPostalCode() %></td>
                                <td><%= cus.getCountry() %></td>
                                <td><%= cus.getPhone() %></td>
                                <td><%= cus.getFax() %></td>
                                <td><%= cus.getCustomerStatus() %></td>
                            </tr>
            
            </table>   
    </body>
</html>
