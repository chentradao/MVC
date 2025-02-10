<%-- 
    Document   : displaySupplier
    Created on : Oct 13, 2024, 1:34:03 PM
    Author     : nguye
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="entity.Supplier,java.util.Vector,entity.Employees" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link href="css/styleDisplay.css" rel="stylesheet">
    </head>
    <body>
        <%
            Vector<Supplier> vector= (Vector<Supplier>)request.getAttribute("data");
            String title = (String)request.getAttribute("title");            
            Employees emp = (Employees)request.getAttribute("emp");
        %>
        <div class="panner">
            <jsp:include page="/admin/adminPanner.jsp" />
        </div>
        <div class="main">
            <div class="menu">
                <jsp:include page="/admin/adminMenu.jsp" />
            </div>
            <div class="content">
                <form action="SupplierURL" method="get">
                    <p>Search name: <input type="text" name="sname">
                        <input type="submit" name="submit" value="Search">
                        <input type="reset" value="Clear">
                        <input type="hidden" name="service" value="listAllSuppliers">
                    </p>
                </form>
                <p><a href="SupplierURL?service=insertSupplier">Insert Supplier</a>
                <body>
                    <table border="1px">
                        <caption><h1><%=title%></h1></caption>
                        <tr>
                            <th>SupplierID</th>
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
                            <th>HomePage</th>
                            <th>SupplierStatus</th>
                            <th>update</th>
                            <th>delete</th>
                        </tr>
                        <% for (Supplier sup : vector) {%>    
                        <tr>\n"
                            <td><%= sup.getSupplierID() %></td>
                            <td><%= sup.getCompanyName() %></td>
                            <td><a href="ProductURL?service=findSupplier&sid=<%= sup.getSupplierID() %>" style="text-decoration: none"><%= sup.getContactName() %></td>
                            <td><%= sup.getContactTitle() %></td>
                            <td><%= sup.getAddress() %></td>
                            <td><%= sup.getCity() %></td>
                            <td><%= sup.getRegion() %></td>
                            <td><%= sup.getPostalCode() %></td>
                            <td><%= sup.getCountry() %></td>
                            <td><%= sup.getPhone() %></td>
                            <td><%= sup.getFax() %></td>
                            <td><%= sup.getHomePage() %></td>
                            <td><%= sup.getSupplierStatus() %></td>
                            <td><a href="SupplierURL?service=updateSupplier&sid=<%= sup.getSupplierID() %>">update</a></td>
                            <td><a href="SupplierURL?service=deleteSupplier&sid=<%= sup.getSupplierID() %>">delete</a></td>
                        </tr>
                        <%}%>
                    </table>   
            </div>
        </div>
    </body>
</html>
