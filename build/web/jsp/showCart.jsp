<%-- 
    Document   : showCart
    Created on : Oct 21, 2024, 8:41:51 AM
    Author     : nguye
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.util.Vector,entity.Cart" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <%
            Vector<Cart> vector=(Vector<Cart>)request.getAttribute("vectorCart");
        %>
        <form action="CartURL" method="POST">
            <input type="hidden" name="service" value="updateCart" />
        <table border 1px>
            <caption><h1>List product in cart</h1></caption>
            <a href="indexURL?service=listAllMenu">Continue shopping</a>
        <tr>
            <th>ProductID</th>
            <th>ProductName</th>
            <th>UnitPrice</th>
            <th>Quantity</th>
            <th>Discount</th>
            <th>Subtotal</th>
            <th>Remove</th>
        </tr>
        
        <%
        double grandTotal = 0.0;
        for(Cart cart :vector) {        
        double total = cart.getUnitPrice() * cart.getQuantity() - cart.getUnitPrice() * cart.getDiscount();
        grandTotal += total;
        %>  
        <tr>
            <td><%=cart.getProductID()%></td>
            <td><%=cart.getProductName()%></td>
            <td><%=cart.getUnitPrice()%></td>
            <td><input type="number" name="Quantity_<%=cart.getProductID()%>" value="<%=cart.getQuantity()%>" min="0"/></td>
            <td><%=cart.getDiscount()%></td>
            <td><%=total%></td>
            <td><a href="CartURL?service=removeCart&pid=<%=cart.getProductID()%>">remove</a></td>
        </tr>
        <%}%>
        <tr>
            <td colspan="5" align="right">Grand Total</td>
            <td><%=grandTotal%></td>
        </tr>
        <tr style="border: none">
            <td colspan="6"><input type="submit" name="submit" value="Update" /></td>
            <td><a href="OrderURL?service=purchase">purchase</a></td>
        </tr>
        </table>
        </form>
    </body>
</html>
