<%-- 
    Document   : insertTerritories
    Created on : Oct 12, 2024, 9:32:25 PM
    Author     : nguye
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page  import="java.sql.ResultSet"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <%ResultSet rsRe=(ResultSet)request.getAttribute("rsRe");%>
        <form action="TerritorieURL" method="post">
        <input type="hidden" name="service" value="insertTerritories">
        <caption>Insert Territories</caption>
        <table>
            <tr>
                <td><label for="TerritoryID">TerritoryID</label></td>
                <td><input type="text" name="TerritoryID"></td>
            </tr>
            <tr>
                <td><label for="TerritoryDescription">TerritoryDescription</label></td>
                <td><input type="text" name="TerritoryDescription"></td>
            </tr>
            <tr>
                <td><label for="RegionID">Region</label></td>
                <td><select name="RegionID" id="RegionID">
                        <%while(rsRe.next()){%>
                        <option value="<%=rsRe.getInt(1)%>"><%=rsRe.getString(2)%></option>
                    <%}%>
                </select></td>
            </tr>
            <tr>
                <td><label for="TerritoryStatus">TerritoryStatus</label></td>
                <td><select name="TerritoryStatus" id="TerritoryStatus">
                    <option value="0">Discontinued</option>
                    <option value="1" selected>Continue</option>
                </select></td>
            </tr>
            <tr>
                <td><input type="submit" value="insertTerritories" name="submit">
                    <input type="reset" value="Clear">
                </td>
            </tr>
        </table>
    </form>
    </body>
</html>
