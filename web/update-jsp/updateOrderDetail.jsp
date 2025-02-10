<%-- 
    Document   : updateOrderDetail
    Created on : Oct 16, 2024, 8:03:32 AM
    Author     : nguye
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.sql.ResultSet,entity.OrderDetail,java.util.Vector" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
         <%
            ResultSet rsOrd = (ResultSet)request.getAttribute("rsOrd");
            ResultSet rsPro = (ResultSet)request.getAttribute("rsPro");
            Vector<OrderDetail> vector =(Vector<OrderDetail>)request.getAttribute("vector");
            OrderDetail or = vector.get(0);
        %>
        <form action="OrderDetailURL" method="post">
        <input type="hidden" name="service" value="updateOrderDetail">
        <caption>Update OrderDetail</caption>
        <table>
            <tr>
                <td><label for="OrderID">Order</label></td>
                <td><input type="text" name="OrderID" id="OrderID" readonly value="<%= or.getOrderID() %>"></td>
            </tr>
            <tr>
                <td><label for="ProductID">Product</label></td>
                <td><input type="text" name="ProductID" id="ProductID" readonly value="<%= or.getProductID() %>"></td>
            </tr>
            <tr>
                <td><label for="UnitPrice">UnitPrice</label></td>
                <td><input type="text" name="UnitPrice" value="<%= or.getUnitPrice() %>"></td>
            </tr>
            <tr>
                <td><label for="Quantity">Quantity</label></td>
                <td><input type="text" name="Quantity" value="<%= or.getQuantity() %>"></td>
            </tr>
            <tr>
                <td><label for="Discount">Discount</label></td>
                <td><input type="text" name="Discount" value="<%= or.getDiscount() %>"></td>
            </tr>
            <tr>
                <td><input type="submit" name="submit" value="updateOrderDetail">
                    <input type="reset" value="Clear">
                </td>
            </tr>
        </table>
    </form>
    </body>
</html>
