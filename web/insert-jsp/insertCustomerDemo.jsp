<%-- 
    Document   : insertCustomerDemo
    Created on : Oct 13, 2024, 5:37:07 PM
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
        <form action="CustomerDemographicURL" method="post">
        <input type="hidden" name="service" value="insertCustomerDemo">
        <caption>Insert CustomerDemo</caption>
        <table>
            <tr>
                <td><label for="CustomerTypeID">CustomerTypeID</label></td>
                <td><input type="text" name="CustomerTypeID"></td>
            </tr>
            <tr>
                <td><label for="CustomerDesc">CustomerDesc</label></td>
                <td><input type="text" name="CustomerDesc"></td>
            </tr>
            <tr>
                <td><label for="DemographicStatus">DemographicStatus</label></td>
                <td><select name="DemographicStatus" id="DemographicStatus">
                    <option value="0">Discontinued</option>
                    <option value="1">Continue</option>
                </select></td>
            </tr>
             <tr>
                <td><input type="submit" value="Insert" name="submit">
                    <input type="reset" value="Clear">
                </td>
            </tr>
        </table>
    </form>
    </body>
</html>
