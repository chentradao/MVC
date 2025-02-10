<%-- 
    Document   : EmployeeID
    Created on : Oct 20, 2024, 11:17:17 AM
    Author     : nguye
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="entity.Employees, jakarta.servlet.http.HttpSession" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <%
        Employees emp = (Employees)request.getAttribute("emp");
        %>
        <%if(emp != null){%>
        <%if(emp == null){%>
        <p align="right"><a href="EmployeeURL?service=loginEmployees">login</a></p>
        <%}else{%>
        <p align="right"><a href="EmployeeURL?service=logoutEmployees">logout</a></p>
        <h1 align= "center">Welcome <%= emp.getLastName() %></h1>
        <%}%>
        <table border 1px>
                              <tr>
                                  <th>EmployeeID</th>
                                  <th>LastName</th>
                                  <th>FirstName</th>
                                  <th>Title</th>
                                  <th>TitleOfCourtesy</th>
                                  <th>BirthDate</th>
                                  <th>HireDate</th>
                                  <th>Address</th>
                                  <th>City</th>
                                  <th>Region</th>
                                  <th>PostalCode</th>
                                  <th>Country</th>
                                  <th>HomePhone</th>
                                  <th>Extension</th>
<!--                                  <th>Photo</th>-->
                                  <th>Notes</th>
                                  <th>ReportsTo</th>
                                  <th>PhotoPath</th>
                                  <th>EmployeeStatus</th>
                              </tr>
             <tr>
                                        <td><%= emp.getEmployeeID() %></td>
                                        <td><%= emp.getLastName() %></td>
                                        <td><%= emp.getFirstName() %></td>
                                        <td><%= emp.getTitle() %></td>
                                        <td><%= emp.getTitleOfCourtesy() %></td>
                                        <td><%= emp.getBirthDate() %></td>
                                        <td><%= emp.getHireDate() %></td>
                                        <td><%= emp.getAddress() %></td>
                                        <td><%= emp.getCity() %></td>
                                        <td><%= emp.getRegion() %></td>
                                        <td><%= emp.getPostalCode() %></td>
                                        <td><%= emp.getCountry() %></td>
                                        <td><%= emp.getHomePhone() %></td>
                                        <td><%= emp.getExtension() %></td>
                                        <td><%= emp.getNotes() %></td>
                                        <td><%= emp.getReportsTo() %></td>
                                        <td><%= emp.getPhotoPath() %></td>
                                        <td><%= emp.getEmployeeStatus() %></td>
             </tr>
        </table>
           <%}%> 
    </body>
</html>
