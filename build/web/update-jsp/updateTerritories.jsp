<%-- 
    Document   : updateTerritories
    Created on : Oct 14, 2024, 9:37:41 AM
    Author     : nguye
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page  import="java.sql.ResultSet,entity.Territories,java.util.Vector"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
       <%
            ResultSet rsRe=(ResultSet)request.getAttribute("rsRe");
            Vector<Territories> vector = (Vector<Territories>)request.getAttribute("vector");
            Territories ter = vector.get(0);
       %>
        <form action="TerritorieURL" method="post">
        <input type="hidden" name="service" value="updateTerritories">
        <caption>Update Territories</caption>
        <table>
            <tr>
                <td><label for="TerritoryID">TerritoryID</label></td>
                <td><input type="text" name="TerritoryID" readonly value="<%= ter.getTerritoryID() %>"></td>
            </tr>
            <tr>
                <td><label for="TerritoryDescription">TerritoryDescription</label></td>
                <td><input type="text" name="TerritoryDescription" value="<%= ter.getTerritoryDescription() %>"></td>
            </tr>
            <tr>
                <td><label for="RegionID">Region</label></td>
                <td><select name="RegionID" id="RegionID">
                        <%while(rsRe.next()){%>
                        <option value="<%=rsRe.getInt(1)%>"
                                <%= ter.getRegionID()==rsRe.getInt(1)?"selected":"" %>><%=rsRe.getString(2)%></option>
                    <%}%>
                </select></td>
            </tr>
            <tr>
                <td><label for="TerritoryStatus">TerritoryStatus</label></td>
                <td><select name="TerritoryStatus" id="TerritoryStatus">
                    <option value="0" <%= ter.getTerritoryStatus()==0?"selected":"" %>>Discontinued</option>
                    <option value="1" <%= ter.getTerritoryStatus()==1?"selected":"" %>>Continue</option>
                </select></td>
            </tr>
            <tr>
                <td><input type="submit" value="updateTerritories" name="submit">
                    <input type="reset" value="Clear">
                </td>
            </tr>
        </table>
    </form>
    </body>
</html>
