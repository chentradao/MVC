<%-- 
    Document   : insertCustomer
    Created on : Oct 13, 2024, 12:36:20 PM
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
        <form action="CustomerURL" method="post">
        <input type="hidden" name="service" value="insertCustomer">
        <caption>Insert Customers</caption>
        <table>
            <tr>
                <td><label for="CustomerID">CustomerID</label></td>
                <td><input type="text" name="CustomerID"></td>
            </tr>
            <tr>
                <td><label for="CompanyName">CompanyName</label></td>
                <td><input type="text" name="CompanyName"></td>
            </tr>
            <tr>
                <td><label for="ContactName">ContactName</label></td>
                <td><input type="text" name="ContactName"></td>
            </tr>
            <tr>
                <td><label for="ContactTitle">ContactTitle</label></td>
                <td><input type="text" name="ContactTitle"></td>
            </tr>
            <tr>
                <td><label for="Address">Address</label></td>
                <td><input type="text" name="Address"></td>
            </tr>
            <tr>
                <td><label for="City">City</label></td>
                <td><input type="text" name="City"></td>
            </tr>
            <tr>
                <td><label for="Region">Region</label></td>
                <td><input type="text" name="Region"></td>
            </tr>
            <tr>
                <td><label for="PostalCode">PostalCode</label></td>
                <td><input type="text" name="PostalCode"></td>
            </tr>
            <tr>
                <td><label for="Country">Country</label></td>
                <td><input type="text" name="Country"></td>
            </tr>
            <tr>
                <td><label for="Phone">Phone</label></td>
                <td><input type="text" name="Phone"></td>
            </tr>
            <tr>
                <td><label for="Fax">Fax</label></td>
                <td><input type="text" name="Fax"></td>
            </tr>
            <tr>
                <td><label for="CustomerStatus">CustomerStatus</label></td>
                <td><select name="CustomerStatus" id="CustomerStatus">
                    <option value="0">Discontinued</option>
                    <option value="1">Continue</option>
                </select></td>
            </tr>
            <tr>
                <td>
                  <input type="submit" name="submit" value="insertCustomer">  
                  <input type="reset" value="Clear">
                </td>
            </tr>
        </table>
    </form>
    </body>
</html>
