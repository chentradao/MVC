<%-- 
    Document   : displayRegion
    Created on : Oct 13, 2024, 1:46:30 PM
    Author     : nguye
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="entity.Region,java.util.Vector,entity.Employees" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link href="css/styleDisplay.css" rel="stylesheet">
    </head>
    <body>
        <%
            Vector<Region> vector = (Vector<Region>)request.getAttribute("data");
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
        <form action="RegionURL"method="get">
                      <p>Search Name: <input type="text" name="rname">
                          <input type="submit" value="Search" name="submit">
                          <input type="reset" value="Clear">
                          <input type="hidden" name="service" value="listAllRegion">
                      </p>
                      </form>
                <p><a href="RegionURL?service=insertRegion">Insert Region</a></p>
            <table border=1px>
                <caption><h1><%=title%></h1></caption>
                                  <tr>
                                      <th>RegionID</th>
                                      <th>RegionDescription</th>
                                      <th>RegionStatus</th>
                                      <th>update</th>
                                      <th>delete</th>
                                  </tr>
                <%for (Region re : vector) {%> 
                <tr>
                                            <td><%= re.getRegionID() %></td>
                                            <td><%= re.getRegionDescription() %></td>
                                            <td><%= re.getRegionStatus() %></td>
                                            <td><a href="RegionURL?service=updateRegion&rid=<%= re.getRegionID() %>">update</a></td>
                                           <td><a href="RegionURL?service=deleteRegion&rid=<%= re.getRegionID() %>">delete</a></td>
                                       </tr>
                <%}%>
            </table>
            </div>
        </div>
    </body>
</html>
