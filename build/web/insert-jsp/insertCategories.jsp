<%-- 
    Document   : insertCategories
    Created on : Oct 13, 2024, 5:24:21 PM
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
        <form action="CategoryURL" method="post">
        <input type="hidden" name="service" value="insertCategories">
        <caption>Insert Categories</caption>
        <table>
            <tr>
                <td><label for="CategoryName">CategoryName</label></td>
                <td><input type="text" name="CategoryName"></td>
            </tr>
            <tr>
                <td><label for="Description">Description</label></td>
                <td><input type="text" name="Description"></td>
            </tr>
            <tr>
                <td><label for="Picture">Picture</label></td>
                <td><input type="text" name="Picture"></td>
            </tr>
            <tr>
                <td><label for="CategoryStatus">CategoryStatus</label></td>
                <td><select name="CategoryStatus" id="CategoryStatus">
                    <option value="0">Discontinued</option>
                    <option value="1">Continue</option>
                </select></td>
            </tr>
            <tr>
                <td><input type="submit" name="submit" value="Insert">
                    <input type="reset" value="Clear">
                </td>
            </tr>
        </table>
    </form>
    </body>
</html>
