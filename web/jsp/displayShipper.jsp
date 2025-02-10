<%-- 
    Document   : displayShipper
    Created on : Oct 12, 2024, 6:30:01 PM
    Author     : nguye
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.util.Vector,entity.Shipper,entity.Employees" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link href="css/styleDisplay.css" rel="stylesheet">
    </head>
    <body>
        <%
        Vector<Shipper> vector =(Vector<Shipper>)request.getAttribute("data");
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
        <form action="ShipperURL" method="get">
                              <p>Search name:
                                  <input type="text" name="sname">
                                  <input type="submit" name="submit" value="Search">
                                  <input type="reset" value="Clear">
                                  <input type="hidden" name="service" value="listAllShippers">
                              </p>
                          </form>
        <p><a href="ShipperURL?service=insertShipper">insert Shipper</a></p>
        
                      <table border 1px>
                          <caption><h1><%=title%></h1></caption>
                            <tr>
                                <th>ShipperID</th>
                                <th>CompanyName</th>
                                <th>Phone</th>
                                <th>ShipperStatus</th>
                                <th>update</th>
                                <th>delete</th>
                            </tr>
                            <%for (Shipper ship : vector) {%>
                            <tr>
                             <td><%=ship.getShipperID()%></td>
                             <td><%=ship.getCompanyName()%></td>
                             <td><%=ship.getPhone()%></td>
                             <td><%=ship.getShipperStatus()%></td>
                             <td><a href="ShipperURL?service=updateShipper&sid=<%=ship.getShipperID()%>">update</a></td>
                             <td><a href="ShipperURL?service=deleteShipper&sid=<%=ship.getShipperID()%>">delete</a></td>                                             
                            </tr>
                            <%}%>
                      </table>
            </div>
        </div>
    </body>
</html>
