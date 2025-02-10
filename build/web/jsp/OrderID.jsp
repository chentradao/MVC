<%-- 
    Document   : OrderID
    Created on : Oct 23, 2024, 11:09:52 PM
    Author     : nguye
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.util.Vector,entity.Order" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <%
            Vector<Order> vector =(Vector<Order>)request.getAttribute("data");
            String title = (String)request.getAttribute("title");
        %>
        <h1 align="center"><%=title%></h1>
        <p>
        <span><a href="indexURL?service=listAllMenu">Shopping</a></span>
    </p>
        <table border 1px>
                                  <tr>
                                      <th>OrderID</th>
                                      <th>CustomerID</th>
                                      <th>EmployeeID</th>
                                      <th>OrderDate</th>
                                      <th>RequiredDate</th>
                                      <th>ShippedDate</th>
                                      <th>ShipVia</th>
                                      <th>Freight</th>
                                      <th>ShipName</th>
                                      <th>ShipAddress</th>
                                      <th>ShipCity</th>
                                      <th>ShipRegion</th>
                                      <th>ShipPostalCode</th>
                                      <th>ShipCountry</th>
                                      <th>Detail</th>
                                      <th>Status</th>
                                  </tr>
                    <% for (Order o : vector) {%>
                    <tr>
                        <td><%=o.getOrderID()%></td>
                        <td><%=o.getCustomerID()%></td>
                        <td><%=o.getEmployeeID()%></td>
                        <td><%=o.getOrderDate()%></td>
                        <td><%=o.getRequiredDate()%></td>
                        <td><%=o.getShippedDate()%></td>
                        <td><%=o.getShipVia()%></td>
                        <td><%=o.getFreight()%></td>
                        <td><%=o.getShipName()%></td>
                        <td><%=o.getShipAddress()%></td>
                        <td><%=o.getShipCity()%></td>
                        <td><%=o.getShipRegion()%></td>
                        <td><%=o.getShipPostalCode()%></td>
                        <td><%=o.getShipCountry()%></td>
                        <% if(o.getOrderStatus()==1){%>
                        <td>Wait</td>
                        <%} else if(o.getOrderStatus()==2){%>
                        <td>Process</td>
                            <%}else{%>
                        <td>Done</td>
                        <%}%>
                        <td><a href="BillURL?service=findBill&oid=<%=o.getOrderID()%>">detail</a></td>
                                </tr>
                    <%}%>
        </table>
    </body>
</html>
