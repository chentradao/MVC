<%-- 
    Document   : displayCustomerDemographic
    Created on : Oct 13, 2024, 5:27:46 PM
    Author     : nguye
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="entity.CustomerDemographic,java.util.Vector,entity.Employees" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link href="css/styleDisplay.css" rel="stylesheet">
    </head>
    <body>
        <%
            Vector<CustomerDemographic> vector = (Vector<CustomerDemographic>)request.getAttribute("data");
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
       <form action="CustomerDemographicURL" method="get">
                              <p>Search name: <input type="text" name="cname">
                                  <input type="submit" value="Search" name="submit">
                                  <input type="reset" value="Clear">
                                  <input type="hidden" name="service" value="listAllCustomerDemographics">
                              </p>
                          </form>
        <p><a href="CustomerDemographicURL?service=insertCustomerDemo">insert CustomerDemographics</a></p>
        <table border 1px>
            <caption><h1><%=title%></h1></caption>
                        <tr>
                            <th>CustomerTypeID</th>
                            <th>CustomerDesc</th>
                            <th>DemographicStatus</th>
                            <th>delete</th>
                        </tr>
         <%for(CustomerDemographic cus : vector){%> 
         <tr>"
                            <td><%= cus.getCustomerTypeID() %></td>
                            <td><%= cus.getCustomerDesc() %></td>
                            <td><%= cus.getDemographicStatus() %></td>
                           <td><a href="CustomerDemographicURL?service=deleteCustomerDemo&cid='<%= cus.getCustomerTypeID() %>'" >delete</a></td>
                            </tr>
         <%}%>
        </table>
            </div>
        </div>
    </body>
</html>
