<%-- 
    Document   : insertRegion
    Created on : Oct 13, 2024, 1:53:07 PM
    Author     : nguye
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <form action="RegionURL" method="post">
            <input type="hidden" name="service" value="insertRegion">
            <Caption>Insert Region</Caption>
            <table>
                <tr>
                    <td><label for="RegionID">RegionID</label></td>
                    <td><input type="number" name="RegionID" ></td>
                </tr>
                <tr>
                    <td><label for="RegionDescription">RegionDescription</label></td>
                    <td><input type="text" name="RegionDescription"></td>
                </tr>
                <tr>
                    <td><label for="RegionStatus">RegionStatus</label></td>
                    <td><select name="RegionStatus" id="RegionStatus">
                        <option value="0">Discontinued</option>
                        <option value="1" selected>Continue</option>
                    </select></td>
                </tr>
                <tr>
                    <td><input type="submit" name="submit" value="Insert">
                        <input type="reset" value="Clear"></td>
                </tr>
            </table>
        </form>
    </body>
</html>
