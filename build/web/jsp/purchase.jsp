<%-- 
    Document   : purchase
    Created on : Oct 24, 2024, 9:22:01 AM
    Author     : nguye
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="entity.Customer,java.sql.ResultSet,java.util.Vector,entity.Order" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <%
            Vector<Order> vector =(Vector<Order>)request.getAttribute("vector");
            Customer cus = (Customer)request.getAttribute("cus");
            ResultSet rsShip = (ResultSet)request.getAttribute("rsShip");
            ResultSet rsEmp = (ResultSet)request.getAttribute("rsEmp");
        %>
        <form action="OrderURL" method="post">
        <input type="hidden" name="service" value="purchase">
        <caption>Insert Order</caption>
        <table>
            <tr>
                <td><label for="OrderID">OrderID</label></td>
                <td><input type="hidden" name="OrderID" ></td>
            </tr>
            <tr>
                <td><label for="CustomerID">Customer</label></td>
                <td><input type="text" name="OrderID" readonly value="<%=cus.getContactName()%>"></td>
            </tr>
            <tr>
                <td><label for="EmployeeID">Employee</label></td>
                <td><select name="EmployeeID" id="EmployeeID">
                    <%while(rsEmp.next()){%>
                        <option value="<%=rsEmp.getInt(1)%>"><%=rsEmp.getString(2)%></option>
                        <%}%>
                </select></td>
            </tr>
            <tr>
                <td><label for="RequiredDate">RequiredDate</label></td>
                <td><input type="text" name="RequiredDate"></td>
            </tr>
            <tr>
                <td><label for="ShippedDate">ShippedDate</label></td>
                <td><input type="text" name="ShippedDate"></td>
            </tr>
            <tr>
                <td><label for="ShipVia">ShipVia</label></td>
                <td><select name="ShipVia" id="ShipVia">
                    <%while(rsShip.next()){%>
                        <option value="<%=rsShip.getInt(1)%>"><%=rsShip.getString(2)%></option>
                        <%}%>
                </select>
                </td>
            </tr>
            <tr>
                <td><label for="Freight">Freight</label></td>
                <td><input type="number" name="Freight" step="0.01" required></td>
            </tr>
            <tr>
                <td><label for="ShipName">ShipName</label></td>
                <td><input type="text" name="ShipName" value="<%= cus.getCompanyName() %>"></td>
            </tr>
            <tr>
                <td><label for="ShipAddress">ShipAddress</label></td>
                <td><input type="text" name="ShipAddress" value="<%= cus.getAddress() %>"></td>
            </tr>
            <tr>
                <td><label for="ShipCity">ShipCity</label></td>
                <td><input type="text" name="ShipCity" value="<%= cus.getCity() %>"></td>
            </tr>
            <tr>
                <td><label for="ShipRegion">ShipRegion</label></td>
                <td><input type="text" name="ShipRegion" value="<%= cus.getRegion() %>"></td>
            </tr>
            <tr>
                <td><label for="ShipPostalCode">ShipPostalCode</label></td>
                <td><input type="text" name="ShipPostalCode" value="<%= cus.getPostalCode() %>"></td>
            </tr>
            <tr>
                <td><label for="ShipCountry">ShipCountry</label></td>
                <td><input type="text" name="ShipCountry" value="<%= cus.getCountry() %>"></td>
            </tr>  
            <tr>
                <td>
            <input type="submit" name="submit" value="purchase">
            <input type="reset" value="Clear">
                </td>
            </tr>
        </table>
    </form>
    </body>
</html>
