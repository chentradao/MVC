<%-- 
    Document   : displayCustomerCustomerDemo
    Created on : Oct 13, 2024, 5:42:07 PM
    Author     : nguye
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="entity.CustomerCustomerDemo,java.util.Vector,entity.Employees" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link href="css/styleDisplay.css" rel="stylesheet">
    </head>
    <body>
        <%
            Vector<CustomerCustomerDemo> vector = (Vector<CustomerCustomerDemo>)request.getAttribute("data");
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
        <form action="CustomerCustomerDemoURL" method="get">
                              <p>Search name: <input type="text" name="cname">
                                  <input type="submit" value="Search" name="submit">
                                  <input type="reset" value="Clear">
                                  <input type="hidden" name="service" value="listAllCustomerCustomerDemo">
                              </p>
                          </form>
        <p><a href="CustomerCustomerDemoURL?service=insertCustomerCus">insert CustomerCustomerDemo</a></p>
        <table border 1px>
            <caption><h1><%=title%></h1></caption>
                        <tr>
                            <th>CustomerID</th>
                            <th>CustomerTypeID</th>
                            <th>delete</th>
                        </tr>
             <%for (CustomerCustomerDemo cus : vector) {%>
             <tr>
                            <td><%= cus.getCustomerID() %></td>
                            <td><%= cus.getCustomerTypeID() %></td>
                           <td><a href="CustomerCustomerDemoURL?service=deleteCustomerCus&cid='<%= cus.getCustomerID() %>'&ctid='<%= cus.getCustomerTypeID() %>'">delete</a></td>
                            </tr>
             <%}%>
        </table>
            </div>
        </div>
    </body>
</html>
