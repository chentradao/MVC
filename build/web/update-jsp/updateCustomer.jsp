<%-- 
    Document   : updateCustomer
    Created on : Oct 15, 2024, 9:20:05 PM
    Author     : nguye
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="entity.Customer,java.util.Vector" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <%
            Vector<Customer> vector =(Vector<Customer>)request.getAttribute("vector");
            Customer cus = vector.get(0);
        %>
        <form action="CustomerURL" method="post">
        <input type="hidden" name="service" value="updateCustomer">
        <caption>update Customers</caption>
        <table>
            <tr>
                <td><label for="CustomerID">CustomerID</label></td>
                <td><input type="text" name="CustomerID" readonly value="<%= cus.getCustomerID() %>"></td>
            </tr>
            <tr>
                <td><label for="CompanyName">CompanyName</label></td>
                <td><input type="text" name="CompanyName" value="<%= cus.getCompanyName() %>"></td>
            </tr>
            <tr>
                <td><label for="ContactName">ContactName</label></td>
                <td><input type="text" name="ContactName" value="<%= cus.getContactName() %>"></td>
            </tr>
            <tr>
                <td><label for="ContactTitle">ContactTitle</label></td>
                <td><input type="text" name="ContactTitle" value="<%= cus.getContactTitle() %>"></td>
            </tr>
            <tr>
                <td><label for="Address">Address</label></td>
                <td><input type="text" name="Address" value="<%= cus.getAddress() %>"></td>
            </tr>
            <tr>
                <td><label for="City">City</label></td>
                <td><input type="text" name="City" value="<%= cus.getCity() %>"></td>
            </tr>
            <tr>
                <td><label for="Region">Region</label></td>
                <td><input type="text" name="Region" value="<%= cus.getRegion() %>"></td>
            </tr>
            <tr>
                <td><label for="PostalCode">PostalCode</label></td>
                <td><input type="text" name="PostalCode" value="<%= cus.getPostalCode() %>"></td>
            </tr>
            <tr>
                <td><label for="Country">Country</label></td>
                <td><input type="text" name="Country" value="<%= cus.getCountry() %>"></td>
            </tr>
            <tr>
                <td><label for="Phone">Phone</label></td>
                <td><input type="text" name="Phone" value="<%= cus.getPhone() %>"></td>
            </tr>
            <tr>
                <td><label for="Fax">Fax</label></td>
                <td><input type="text" name="Fax" value="<%= cus.getFax() %>"></td>
            </tr>
            <tr>
                <td><label for="CustomerStatus">CustomerStatus</label></td>
                <td><select name="CustomerStatus" id="CustomerStatus">
                    <option value="0" <%= cus.getCustomerStatus()==0?"selected":"" %>>Discontinued</option>
                    <option value="1" <%= cus.getCustomerStatus()==1?"selected":"" %>>Continue</option>
                </select></td>
            </tr>
            <tr>
                <td>
                  <input type="submit" name="submit" value="updateCustomer">  
                  <input type="reset" value="Clear">
                </td>
            </tr>
        </table>
    </form>
    </body>
</html>
