<%-- 
    Document   : displayOrderDetail
    Created on : Oct 13, 2024, 1:15:39 PM
    Author     : nguye
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="entity.OrderDetail,java.util.Vector,entity.Employees" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link href="css/styleDisplay.css" rel="stylesheet">
    </head>
    <body>
        <%
            Vector<OrderDetail> vector =(Vector<OrderDetail>)request.getAttribute("data");
            String title = (String)request.getAttribute("title");            
            Employees emp = (Employees)request.getAttribute("emp");
        %>
        <div class="panner">
            <jsp:include page="/admin/adminPanner.jsp" />
        </div>
        <div class="main">
            <div class="menu">
                <jsp:include page="/admin/adminMenu.jsp" />
            </div>
            <div class="content">
        <form action="OrderDetailURL" method="get">
                              <p>Search OrderID: <input type="text" name="oid">
                              <input type="submit" name="submit" value="Search">
                              <input type="reset" value="Clear">
                              <input type="hidden" name="service" value="listAllOrderDetails">
                              </p>
                          </form>
                <p><a href="OrderDetailURL?service=insertOrderDetail">insert OrderDetail</a></p>
             <table border 1px>
                 <caption><h1><%=title%></h1></caption>
                              <tr>
                                  <th>OrderID</th>
                                  <th>ProductID</th>
                                  <th>UnitPrice</th>
                                  <th>Quantity</th>
                                  <th>Discount</th>
                                  <th>update</th>
                                  <th>delete</th>
                              </tr>
                              <%for (OrderDetail or : vector) {%>
                              <tr>
                                        <td><%= or.getOrderID() %></td>
                                        <td><%= or.getProductID() %></td>
                                        <td><%= or.getUnitPrice() %></td>
                                        <td><%= or.getQuantity() %></td>
                                        <td><%= or.getDiscount() %></td>
                                        <td><a href="OrderDetailURL?service=updateOrderDetail&oid=<%= or.getOrderID() %>&pid=<%= or.getProductID() %>">update</a></td>
                                        <td><a href="OrderDetailURL?service=deleteOrderDetail&oid=<%= or.getOrderID() %>&pid=<%= or.getProductID() %>">delete</a></td>
                                    </tr>
                              <%}%>
             </table>    
            </div>
        </div>
    </body>
</html>
