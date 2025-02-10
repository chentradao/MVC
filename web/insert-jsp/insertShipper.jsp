<%-- 
    Document   : insertShipper
    Created on : Oct 12, 2024, 8:55:54 PM
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
        <form action="ShipperURL" method="post">
        <input type="hidden" name="service" value="insertShipper">
        <table>
            <caption>Insert Shipper</caption>
            <tr>
                <td><label for="ShipperID">ShipperID</label></td>
                <td><input type="hidden" name="ShipperID" id="ShipperID"></td>
            </tr>
            <tr>
                <td><label for="CompanyName">CompanyName</label></td>
                <td><input type="text" name="CompanyName" id="CompanyName"></td>
            </tr> 
            <tr>
                <td><label for="Phone">Phone</label></td>
                <td><input type="text" name="Phone" id="Phone"></td>
            </tr>
            <tr>
                <td><label for="ShipperStatus">ShipperStatus</label></td>
                <td><select name="ShipperStatus" id="ShipperStatus">
                        <option value="0">Discontinue</option>
                        <option value="1" selected>Continue</option>
                    </select></td>
            </tr>
            <tr>
                <td><input type="submit" value="insertShipper" name="submit"></td>
                <td><input type="reset" value="Clear"></td>
            </tr>
        </table>
    </form>
    </body>
</html>
