<%-- 
    Document   : updateSupplier
    Created on : Oct 16, 2024, 8:42:43 AM
    Author     : nguye
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="entity.Supplier,java.util.Vector" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <%
            Vector<Supplier> vector =(Vector<Supplier>)request.getAttribute("vector");
            Supplier sup = vector.get(0);
        %>
        <form action="SupplierURL" method="post">
        <input type="hidden" name="service" value="updateSupplier">
        <caption>Update Supplier</caption>
        <table>
            <tr>
                <td><label for="SupplierID">SupplierID</label></td>
                <td><input type="text" name="SupplierID" readonly value="<%= sup.getSupplierID() %>"></td>
            </tr>
            <tr>
                <td><label for="CompanyName">CompanyName</label></td>
                <td><input type="text" name="CompanyName" value="<%= sup.getCompanyName() %>"></td>
            </tr>
            <tr>
                <td><label for="ContactName">ContactName</label></td>
                <td><input type="text" name="ContactName" value="<%= sup.getContactName() %>"></td>
            </tr>
            <tr>
                <td><label for="ContactTitle">ContactTitle</label></td>
                <td><input type="text" name="ContactTitle" value="<%= sup.getContactTitle() %>"></td>
            </tr>
            <tr>
                <td><label for="Address">Address</label></td>
                <td><input type="text" name="Address" value="<%= sup.getAddress() %>"></td>
            </tr>
            <tr>
                <td><label for="City">City</label></td>
                <td><input type="text" name="City" value="<%= sup.getCity() %>"></td>
            </tr>
            <tr>
                <td><label for="Region">Region</label></td>
                <td><input type="text" name="Region" value="<%= sup.getRegion() %>"></td>
            </tr>
            <tr>
                <td><label for="PostalCode">PostalCode</label></td>
                <td><input type="text" name="PostalCode" value="<%= sup.getPostalCode() %>"></td>
            </tr>
            <tr>
                <td><label for="Country">Country</label></td>
                <td><input type="text" name="Country" value="<%= sup.getCountry() %>"></td>
            </tr>
            <tr>
                <td><label for="Phone">Phone</label></td>
                <td><input type="text" name="Phone" value="<%= sup.getPhone() %>"></td>
            </tr>
            <tr>
                <td><label for="Fax">Fax</label></td>
                <td><input type="text" name="Fax" value="<%= sup.getFax() %>"></td>
            </tr>
            <tr>
                <td><label for="HomePage">HomePage</label></td>
                <td><input type="text" name="HomePage" value="<%= sup.getHomePage() %>"></td>
            </tr>
            <tr>
                <td><label for="SupplierStatus">SupplierStatus</label></td>
                <td><select name="SupplierStatus" id="SupplierStatus">
                    <option value="0" <%= sup.getSupplierStatus()==0?"selected":"" %>>Discontinued</option>
                    <option value="1" <%= sup.getSupplierStatus()==1?"selected":"" %>>Continue</option>
                </select></td>
            </tr>
            <tr>
                <td><input type="submit" name="submit" value="Update">
                    <input type="reset" value="Clear">
                </td>
            </tr>
        </table>
    </form>
    </body>
</html>
