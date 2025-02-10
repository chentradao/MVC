<%-- 
    Document   : displayEmployee
    Created on : Oct 7, 2024, 9:09:13 AM
    Author     : nguye
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.util.Vector,entity.Employees" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>display Employee</title>
        <link href="css/styleDisplay.css" rel="stylesheet">
    </head>
    <body>
        <%
        Vector<Employees> vector=(Vector<Employees>)request.getAttribute("data");
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
        <p align="right"><a href="EmployeeURL?service=loginEmployees">login</a></p>
         <form action="EmployeeURL" method="get">
                              <p>Search name: <input type="text" name="ename" id="">
                                  <input type="submit" value="Search" name="submit">
                                  <input type="reset" value="Clear">
                                  <input type="hidden" name="service" value="listAllEmployees">
                              </p>
                          </form>
        <p><a href="EmployeeURL?service=insertEmployees">Insert Employees</a></p>
         <table border 1px>
             <caption><h1><%=title%></h1></caption>
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
                                  <th>Notes</th>
                                  <th>ReportsTo</th>
                                  <th>PhotoPath</th>
                                  <th>EmployeeStatus</th>
<!--                                  <th>update</th>-->
                                  <th>delete</th>
                              </tr>
            <%for (Employees empl : vector) {%>
             <tr>
                                        <td><%= empl.getEmployeeID() %></td>
                                        <td><%= empl.getLastName() %></td>
                                        <td><%= empl.getFirstName() %></td>
                                        <td><%= empl.getTitle() %></td>
                                        <td><%= empl.getTitleOfCourtesy() %></td>
                                        <td><%= empl.getBirthDate() %></td>
                                        <td><%= empl.getHireDate() %></td>
                                        <td><%= empl.getAddress() %></td>
                                        <td><%= empl.getCity() %></td>
                                        <td><%= empl.getRegion() %></td>
                                        <td><%= empl.getPostalCode() %></td>
                                        <td><%= empl.getCountry() %></td>
                                        <td><%= empl.getHomePhone() %></td>
                                        <td><%= empl.getExtension() %></td>
                                        <td><%= empl.getNotes() %></td>
                                        <td><%= empl.getReportsTo() %></td>
                                        <td><%= empl.getPhotoPath() %></td>
                                        <td><%= empl.getEmployeeStatus() %></td>
<!--                                        <td></td>-->
                                        <td><a href="EmployeeURL?service=deleteEmployees&eid=<%= empl.getEmployeeID() %>">delete</a></td>
            <%}%>
            </div>
        </div>
    </body>
</html>
