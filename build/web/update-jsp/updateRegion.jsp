<%-- 
    Document   : updateRegion
    Created on : Oct 16, 2024, 9:18:04 AM
    Author     : nguye
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="entity.Region,java.util.Vector" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <%Vector<Region> vector =(Vector<Region>)request.getAttribute("vector");
        Region re = vector.get(0);
        %>
        <form action="RegionURL" method="post">
            <input type="hidden" name="service" value="updateRegion">
            <Caption>Update Region</Caption>
            <table>
                <tr>
                    <td><label for="RegionID">RegionID</label></td>
                    <td><input type="text" name="RegionID" readonly value="<%= re.getRegionID() %>"></td>
                </tr>
                <tr>
                    <td><label for="RegionDescription">RegionDescription</label></td>
                    <td><input type="text" name="RegionDescription" value="<%= re.getRegionDescription() %>"></td>
                </tr>
                <tr>
                    <td><label for="RegionStatus">RegionStatus</label></td>
                    <td><select name="RegionStatus" id="RegionStatus">
                        <option value="0"
                                <%= re.getRegionStatus()==0?"selected":"" %>>Discontinued</option>
                        <option value="1"
                                <%= re.getRegionStatus()==1?"selected":"" %>>Continue</option>
                    </select></td>
                </tr>
                <tr>
                    <td><input type="submit" name="submit" value="Update">
                        <input type="reset" value="Clear"></td>
                </tr>
            </table>
        </form>
    </body>
</html>
