<%-- 
    Document   : Content
    Created on : Oct 31, 2024, 12:43:02 PM
    Author     : nguye
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.util.Vector,entity.Product" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <style>
            table{
                width: 100%;
            }
        </style>
    </head>
    <body>
        <%
            Vector<Product> vector=(Vector<Product>)request.getAttribute("vector");
            Vector<Product> catList=(Vector<Product>)request.getAttribute("catList");
        %>
        <table border 1px>
            <caption><h1>List of Products</h1></caption>
        <tr>
            <th>ProductID</th>
            <th>ProductName</th>
            <th>QuantityPerUnit</th>
            <th>UnitPrice</th>
            <th>UnitsInStock</th>
            <th>UnitsOnOrder</th>
            <th>ReorderLevel</th>
            <th>add to Cart</th>
        </tr>
        <%if(catList == null){
            for(Product menu :vector) {%>
        <tr>
            <td><%=menu.getProductID()%></td>
            <td><%=menu.getProductName()%></td>
            <td><%=menu.getQuantityPerUnit()%></td>
            <td><%=menu.getUnitPrice()%></td>
            <td><%=menu.getUnitsInStock()%></td>
            <td><%=menu.getUnitsOnOrder()%></td>
            <td><%=menu.getReorderLevel()%></td>
            <td><a href="CartURL?service=add2cart&pid=<%=menu.getProductID()%>">add2cart</a></td>
        </tr>
        <%}
            }  else{  
            for(Product menu :catList) {
        %>
        <tr>
            <td><%=menu.getProductID()%></td>
            <td><%=menu.getProductName()%></td>
            <td><%=menu.getQuantityPerUnit()%></td>
            <td><%=menu.getUnitPrice()%></td>
            <td><%=menu.getUnitsInStock()%></td>
            <td><%=menu.getUnitsOnOrder()%></td>
            <td><%=menu.getReorderLevel()%></td>
            <td><a href="CartURL?service=add2cart&pid=<%=menu.getProductID()%>">add2cart</a></td>
        </tr>
        <%}
                }
        %>
        
    </table>
    </body>
</html>
