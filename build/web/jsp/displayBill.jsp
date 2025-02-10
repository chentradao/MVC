<%-- 
    Document   : displayBill
    Created on : Oct 17, 2024, 11:42:08 AM
    Author     : nguye
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.util.Vector,entity.Bill,java.sql.ResultSet,java.text.SimpleDateFormat,java.util.Date" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <%  
            Vector<Bill> vector =(Vector<Bill>)request.getAttribute("data");
            int orderID =vector.get(0).getOrderID();
            String OrderDate =vector.get(0).getOrderDate();
            String RequiredDate=vector.get(0).getRequiredDate();
            String ContactName=vector.get(0).getContactName();
            String FirstName=vector.get(0).getFirstName();
        %>
        <table border 1px>
            <caption style="font-weight: bolder"><h1>Bill</h1></caption>
             <tr>
            <th colspan="1" style="text-align: left;">
            OrderID: <%= orderID %> 
            </th>
            <th colspan="2" style="text-align: left;">
            OrderDate: <%= OrderDate %> 
            </th>
            <th colspan="3" style="text-align: left;">
            RequiredDate: <%= RequiredDate %> 
            </th>
        </tr>
        <tr>
    <th colspan="2" style="text-align: left;">
        Customer: <%= ContactName %>
    </th>
    <th colspan="4" style="text-align: left;">
        Employee: <%= FirstName %>
    </th>
</tr>
            <tr>
                <th>ProductID</th>
                <th>ProductName</th>
                <th>UnitPrice</th>
                <th>Quantity</th>
                <th>Discount</th>
                <th>Total</th>
            </tr>
             
             <%
        double grandTotal = 0.0;
        for (Bill b : vector) {
            double total = b.getUnitPrice() * b.getQuantity() - (b.getUnitPrice() * b.getDiscount());
            grandTotal += total;
    %>
                    <tr>
                        <td><%=b.getProductID()%></td>
                        <td><%=b.getProductName()%></td>
                        <td><%=b.getUnitPrice()%></td>
                        <td><%=b.getQuantity()%></td>
                        <td><%=b.getDiscount()%></td> 
                        <td><%=total%></td>
                                </tr>
                    <%}%>
                    <tr>
        <td colspan="5" style="text-align: right;"><strong>Grand Total</strong></td>
        <td><strong><%= grandTotal %></strong></td>
        </tr>
        </table>
    </body>
</html>
