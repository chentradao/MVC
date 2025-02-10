<%-- 
    Document   : displayOrder
    Created on : Oct 13, 2024, 10:59:08 AM
    Author     : nguye
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.util.Vector,entity.Order,entity.Employees" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link href="css/styleDisplay.css" rel="stylesheet">
    </head>
    <body>
        <%
            Vector<Order> vector =(Vector<Order>)request.getAttribute("data");
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
        <form action="OrderURL" method="get">
                                          <p>Search Name: <input type="text" name="pname" id="">
                                              <input type="submit" value="Search" name="submit">
                                              <input type="reset" value="Clear">
                                              <input type="hidden" name="service" value="listAllOrders">
                                          </p>
                                          </form>
        <p><a href="OrderURL?service=insertOrder">insert Order</a></p>   
        <table border 1px>
            <caption><h1><%=title%></h1></caption>
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
                                      <th>update</th>
                                      <th>delete</th>
                                      <th>OrderStatus</th>
                                      <th>update</th>
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
                            <%}else if(o.getOrderStatus()==0){%>
                        <td>Done</td>
                        <%}%>
                        <td><a href="BillURL?service=findBill&oid=<%=o.getOrderID()%>">detail</a></td>
                                    <td><a href="OrderURL?service=updateOrder&oid=<%=o.getOrderID()%>">update</a></td>
                                    <td><a href="OrderURL?service=deleteOrder&oid=<%=o.getOrderID()%>">delete</a></td>
                    <form action="OrderURL" method="POST">
                        <input type="hidden" name="service" value="updateStatus">
                        <input type="hidden" name="id" value="<%=o.getOrderID()%>">
                                    <td><select name="Status" id="OrderStatus">
                    <option value="0"
                            <%=o.getOrderStatus()==0?"selected":""%>>Done</option>
                    <option value="1"
                            <%=o.getOrderStatus()==1?"selected":""%>>Wait</option>
                    <option value="2"
                            <%=o.getOrderStatus()==2?"selected":""%>>Process</option>
                </select></td>
                <td><input type="submit" name="submit" value="updateStatus" /></td>
                                    </form>
                                </tr>
                    <%}%>
        </table>
            </div>
        </div>
    </body>
</html>
