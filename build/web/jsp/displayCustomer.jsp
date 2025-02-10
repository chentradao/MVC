<%-- 
    Document   : displayCustomer
    Created on : Oct 13, 2024, 12:24:57 PM
    Author     : nguye
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="entity.Customer,java.util.Vector,entity.Employees" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link href="css/styleDisplay.css" rel="stylesheet">
    </head>
    <body>
        <%
            Vector<Customer> vector = (Vector<Customer>)request.getAttribute("data");
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
                <form action="CustomerURL" method="get">
                    <p>
                        Search name: <input type="text" name="cname">
                        <input type="submit" name="submit" value="Search">
                        <input type="reset" value="Clear">
                        <input type="hidden" name="service" value="listAllCustomers">
                    </p>
                </form>
                <p><a href="CustomerURL?service=insertCustomer">insertCustomer</a></p>
                <table border 1px>
                    <caption><h1><%=title%></h1></caption>
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
                        <th>update</th>
                        <th>delete</th>
                    </tr>
                    <%for (Customer cus : vector) {%> 
                    <tr>
                        <td><%= cus.getCustomerID() %></td>
                        <td><%= cus.getCompanyName() %></td>
                        <td><a href="OrderURL?service=findCustomer&cid=<%= cus.getCustomerID() %>" style="text-decoration: none"><%= cus.getContactName() %></a></td>
                        <td><%= cus.getContactTitle() %></td>
                        <td><%= cus.getAddress() %></td>
                        <td><%= cus.getCity() %></td>
                        <td><%= cus.getRegion() %></td>
                        <td><%= cus.getPostalCode() %></td>
                        <td><%= cus.getCountry() %></td>
                        <td><%= cus.getPhone() %></td>
                        <td><%= cus.getFax() %></td>
                        <td><%= cus.getCustomerStatus() %></td>
                        <td><a href="CustomerURL?service=updateCustomer&cid=<%= cus.getCustomerID() %>">update</a></td>\n"
                        <td><a href="CustomerURL?service=deleteCustomer&cid='<%= cus.getCustomerID() %>'">delete</a></td>
                    </tr>
                    <%}%>
                </table>        
            </div>
        </div>
    </body>
</html>
