<%-- 
    Document   : updateOrder
    Created on : Oct 15, 2024, 10:29:49 PM
    Author     : nguye
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.sql.ResultSet,java.util.Vector,entity.Order" %>
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
            Vector<Order> vector =(Vector<Order>)request.getAttribute("vector");
            Order o = vector.get(0);
        %>
        <form action="OrderURL" method="post">
        <input type="hidden" name="service" value="updateOrder">
        <caption>Update Order</caption>
        <table>
            <tr>
                <td><label for="OrderID">OrderID</label></td>
                <td><input type="text" name="OrderID" readonly value="<%=o.getOrderID()%>"></td>
            </tr>
            <tr>
                <td><label for="CustomerID">Customer</label></td>
                <td><input type="text" name="CustomerID" readonly value="<%=o.getCustomerID()%>"></td>
            </tr>
            <tr>
                <td><label for="EmployeeID">Employee</label></td>
                <td><select name="EmployeeID" id="EmployeeID">
                    <%while(rsEmp.next()){%>
                        <option value="<%=rsEmp.getInt(1)%>"
                                <%=o.getEmployeeID()==rsEmp.getInt(1)?"selected":""%>><%=rsEmp.getString(2)%></option>
                        <%}%>
                </select></td>
            </tr>
            <tr>
                <td><label for="OrderDate">OrderDate</label></td>
                <td><input type="text" name="OrderDate" value="<%=o.getOrderDate()%>"></td>
            </tr>
            <tr>
                <td><label for="RequiredDate">RequiredDate</label></td>
                <td><input type="text" name="RequiredDate" value="<%=o.getRequiredDate()%>"></td>
            </tr>
            <tr>
                <td><label for="ShippedDate">ShippedDate</label></td>
                <td><input type="text" name="ShippedDate" value="<%=o.getShippedDate()%>"></td>
            </tr>
            <tr>
                <td><label for="ShipVia">ShipVia</label></td>
                <td><select name="ShipVia" id="ShipVia">
                    <%while(rsShip.next()){%>
                        <option value="<%=rsShip.getInt(1)%>"
                                <%=o.getShipVia()==rsShip.getInt(1)?"selected":""%>><%=rsShip.getString(2)%></option>
                        <%}%>
                </select>
                </td>
            </tr>
            <tr>
                <td><label for="Freight">Freight</label></td>
                <td><input type="number" name="Freight" step="0.01" required value="<%=o.getFreight()%>"></td>
            </tr>
            <tr>
                <td><label for="ShipName">ShipName</label></td>
                <td><input type="text" name="ShipName" value="<%=o.getShipName()%>"></td>
            </tr>
            <tr>
                <td><label for="ShipAddress">ShipAddress</label></td>
                <td><input type="text" name="ShipAddress" value="<%=o.getShipAddress()%>"></td>
            </tr>
            <tr>
                <td><label for="ShipCity">ShipCity</label></td>
                <td><input type="text" name="ShipCity" value="<%=o.getShipCity()%>"></td>
            </tr>
            <tr>
                <td><label for="ShipRegion">ShipRegion</label></td>
                <td><input type="text" name="ShipRegion" value="<%=o.getShipRegion()%>"></td>
            </tr>
            <tr>
                <td><label for="ShipPostalCode">ShipPostalCode</label></td>
                <td><input type="text" name="ShipPostalCode" value="<%=o.getShipPostalCode()%>"></td>
            </tr>
            <tr>
                <td><label for="ShipCountry">ShipCountry</label></td>
                <td><input type="text" name="ShipCountry" value="<%=o.getShipCountry()%>"></td>
            </tr>
            <tr>
                <td><label for="OrderStatus">OrderStatus</label></td>
                <td><select name="OrderStatus" id="OrderStatus">
                    <option value="0"
                            <%=o.getOrderStatus()==0?"selected":""%>>Done</option>
                    <option value="1"
                            <%=o.getOrderStatus()==1?"selected":""%>>Wait</option>
                    <option value="2"
                            <%=o.getOrderStatus()==2?"selected":""%>>Process</option>
                </select>
                </td>
            </tr>  
            <tr>
                <td>
            <input type="submit" name="submit" value="Update">
            <input type="reset" value="Clear">
                </td>
            </tr>
        </table>
    </form>
    </body>
</html>
