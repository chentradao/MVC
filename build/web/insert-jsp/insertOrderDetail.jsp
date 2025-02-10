<%-- 
    Document   : insertOrderDetail
    Created on : Oct 13, 2024, 1:24:14 PM
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
            ResultSet rsOrd = (ResultSet)request.getAttribute("rsOrd");
            ResultSet rsPro = (ResultSet)request.getAttribute("rsPro");
        %>
        <form action="OrderDetailURL" method="post">
        <input type="hidden" name="service" value="insertOrderDetail">
        <caption>Insert OrderDetail</caption>
        <table>
            <tr>
                <td><label for="OrderID">Order</label></td>
                <td><select name="OrderID" id="OrderID">
                    <%while (rsOrd.next()) {%>
                            <option value="<%=rsOrd.getInt(1)%>"><%=rsOrd.getString(2)%></option>
                            <%}%>
                </select></td>
            </tr>
            <tr>
                <td><label for="ProductID">Product</label></td>
                <td><select name="ProductID" id="ProductID">
                    <%while (rsPro.next()) {%>
                            <option value="<%=rsPro.getInt(1)%>"><%=rsPro.getString(2)%></option>
                            <%}%>
                </select></td>
            </tr>
            <tr>
                <td><label for="UnitPrice">UnitPrice</label></td>
                <td><input type="text" name="UnitPrice"></td>
            </tr>
            <tr>
                <td><label for="Quantity">Quantity</label></td>
                <td><input type="text" name="Quantity"></td>
            </tr>
            <tr>
                <td><label for="Discount">Discount</label></td>
                <td><input type="text" name="Discount"></td>
            </tr>
            <tr>
                <td><input type="submit" name="submit" value="insert">
                    <input type="reset" value="Clear">
                </td>
            </tr>
        </table>
    </form>
    </body>
</html>
