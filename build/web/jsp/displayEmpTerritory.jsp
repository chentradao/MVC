<%-- 
    Document   : displayEmpTerritory
    Created on : Oct 13, 2024, 12:01:59 PM
    Author     : nguye
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.util.Vector,entity.EmployeeTerritories,entity.Employees" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link href="css/styleDisplay.css" rel="stylesheet">
    </head>
    <body>
        <%
            Vector<EmployeeTerritories> vector = (Vector<EmployeeTerritories>)request.getAttribute("data");
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
        <form action="EmpTerritoryURL" method="get">
                              <p>Search EmployeeID: <input type="number" name="eid">
                                  <input type="submit" name="submit" value="Search">
                                  <input type="reset" value="Clear">
                                  <input type="hidden" name="service" value="listAllEmpTerritories">
                              </p>
                          </form>
        <a href="EmpTerritoryURL?service=insertEmployeeTe">Insert EmployeeTerritories</a>
        <table border 1px>
            <caption><h1><%=title%></h1></caption>
                        <tr>
                            <th>EmployeeID</th>
                            <th>TerritoryID</th>
                            <th>delete</th>
                        </tr>
         <% for (EmployeeTerritories empt : vector) {%>        
         <tr>
                        <td><%= empt.getEmployeeID() %></td>
                        <td><%= empt.getTerritoryID() %></td>
                        <td><a href="EmpTerritoryURL?service=deleteEmployeeTerritorieses&eid=<%= empt.getEmployeeID() %>&tid='<%= empt.getTerritoryID() %>'">delete</a></td>
                        </tr>
         <%}%>
        </table>
            </div>
        </div>
    </body>
</html>
