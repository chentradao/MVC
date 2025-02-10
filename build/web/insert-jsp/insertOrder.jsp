<%-- 
    Document   : insertOrder
    Created on : Oct 13, 2024, 11:11:32 AM
    Author     : nguye
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.sql.ResultSet" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <%
            ResultSet rsCus = (ResultSet)request.getAttribute("rsCus");
            ResultSet rsShip = (ResultSet)request.getAttribute("rsShip");
            ResultSet rsEmp = (ResultSet)request.getAttribute("rsEmp");
        %>
        <form action="OrderURL" method="post">
        <input type="hidden" name="service" value="insertOrder">
        <caption>Insert Order</caption>
        <table>
            <tr>
                <td><label for="CustomerID">Customer</label></td>
                <td><select name="CustomerID" id="CustomerID">
                        <%while(rsCus.next()){%>
                        <option value="<%=rsCus.getString(1)%>"><%=rsCus.getString(2)%></option>
                        <%}%>
                </select></td>
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
                <td><label for="OrderDate">OrderDate</label></td>
                <td><input type="text" name="OrderDate"></td>
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
                <td><input type="text" name="ShipName"></td>
            </tr>
            <tr>
                <td><label for="ShipAddress">ShipAddress</label></td>
                <td><input type="text" name="ShipAddress"></td>
            </tr>
            <tr>
                <td><label for="ShipCity">ShipCity</label></td>
                <td><input type="text" name="ShipCity"></td>
            </tr>
            <tr>
                <td><label for="ShipRegion">ShipRegion</label></td>
                <td><input type="text" name="ShipRegion"></td>
            </tr>
            <tr>
                <td><label for="ShipPostalCode">ShipPostalCode</label></td>
                <td><input type="text" name="ShipPostalCode"></td>
            </tr>
            <tr>
                <td><label for="ShipCountry">ShipCountry</label></td>
                <td><input type="text" name="ShipCountry"></td>
            </tr>
            <tr>
                <td><label for="OrderStatus">OrderStatus</label></td>
                <td><select name="OrderStatus" id="OrderStatus">
                    <option value="0">Done</option>
                    <option value="1" selected>Wait</option>
                    <option value="2">Process</option>
                </select>
                </td>
            </tr>  
            <tr>
                <td>
            <input type="submit" name="submit" value="insertOrder">
            <input type="reset" value="Clear">
                </td>
            </tr>
        </table>
    </form>
    </body>
</html>
