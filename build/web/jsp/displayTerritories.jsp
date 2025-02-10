<%-- 
    Document   : displayTerritories
    Created on : Oct 12, 2024, 9:21:06 PM
    Author     : nguye
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="entity.Territories,java.util.Vector,entity.Employees" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link href="css/styleDisplay.css" rel="stylesheet">
    </head>
    <body>
        <%
            Vector<Territories> vector = (Vector<Territories>)request.getAttribute("data");
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
         <form action="TerritorieURL" method="get">
                              <p>Search name: <input type="text" name="tname">
                                  <input type="submit" value="Search" name="submit">
                                  <input type="reset" value="Clear">
                                  <input type="hidden" name="service" value="listAllTerritories">
                              </p>
                          </form>
        <p><a href="TerritorieURL?service=insertTerritories">insert Territories</a></p>
        <table border 1px>
            <caption><h1><%=title%></h1></caption>
                        <tr>
                            <th>TerritoryID</th>
                            <th>TerritoryDescription</th>
                            <th>RegionID</th>
                            <th>TerritoryStatus</th>
                            <th>update</th>
                            <th>delete</th>
                        </tr>
                        <%for (Territories ter : vector) {%>
                        <tr>
                            <td><%= ter.getTerritoryID() %></td>
                            <td><%= ter.getTerritoryDescription() %></td>
                            <td><%= ter.getRegionID() %></td>
                            <td><%= ter.getTerritoryStatus() %></td>
                            <td><a href="TerritorieURL?service=updateTerritories&tid=<%= ter.getTerritoryID() %>">update</a></td>"
                            <td><a href="TerritorieURL?service=deleteTerritories&tid='<%= ter.getTerritoryID() %>'">delete</a></td>"
                            </tr>
                            <%}%>
        </table>
            </div>
        </div>
    </body>
</html>
