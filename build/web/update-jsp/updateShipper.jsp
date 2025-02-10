<%-- 
    Document   : updateShipper
    Created on : Oct 14, 2024, 8:57:38 AM
    Author     : nguye
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.util.Vector,entity.Shipper" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <%
            Vector<Shipper> vector = (Vector<Shipper>)request.getAttribute("vector");
            Shipper ship = vector.get(0);
        %>
        <form action="ShipperURL" method="post">
        <input type="hidden" name="service" value="updateShipper">
        <table>
            <caption>Update Shipper</caption>
            <tr>
                <td><label for="ShipperID">ShipperID</label></td>
                <td><input type="text" name="ShipperID" id="ShipperID" readonly value="<%=ship.getShipperID()%>"></td>
            </tr>
            <tr>
                <td><label for="CompanyName">CompanyName</label></td>
                <td><input type="text" name="CompanyName" id="CompanyName" value="<%=ship.getCompanyName()%>"></td>
            </tr> 
            <tr>
                <td><label for="Phone">Phone</label></td>
                <td><input type="text" name="Phone" id="Phone" value="<%=ship.getPhone()%>"></td>
            </tr>
            <tr>
                <td><label for="ShipperStatus">ShipperStatus</label></td>
                <td><select name="ShipperStatus" id="ShipperStatus">
                        <option value="0" 
                                <%=ship.getShipperStatus()==0?"selected":""%>>Discontinue</option>
                        <option value="1"
                                <%=ship.getShipperStatus()==1?"selected":""%>>Continue</option>
                    </select></td>
            </tr>
            <tr>
                <td><input type="submit" value="updateShipper" name="submit"></td>
                <td><input type="reset" value="Clear"></td>
            </tr>
        </table>
    </form>
    </body>
</html>
