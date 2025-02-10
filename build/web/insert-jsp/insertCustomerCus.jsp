<%-- 
    Document   : insertCustomerCus
    Created on : Oct 13, 2024, 5:51:56 PM
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
            ResultSet rsCus = (ResultSet)request.getAttribute("rsCus");
            ResultSet rsGra = (ResultSet)request.getAttribute("rsGra");
        %>
        <form action="CustomerCustomerDemoURL" method="post">
        <input type="hidden" name="service" value="insertCustomerCus">
        <caption>Insert CustomerCustomerDemo</caption>
        <table>
            <tr>
                <td><label for="CustomerID">Customer</label></td>
                <td><select name="CustomerID" id="CustomerID">
                        <%while(rsCus.next()){%>
                    <option value="<%=rsCus.getString(1)%>"><%=rsCus.getString(2)%></option>
                        <%}%>
                </select></td>
            </tr>
            <tr>
                <td><label for="CustomerTypeID">CustomerType</label></td>
                <td><select name="CustomerTypeID" id="CustomerTypeID">
                    <%while(rsGra.next()){%>
                    <option value="<%=rsGra.getString(1)%>"><%=rsGra.getString(2)%></option>
                        <%}%>
                </select></td>
            <tr>
                <td><input type="submit" name="submit" value="Insert">
                    <input type="reset" value="Clear">
                </td>
            </tr>
        </table>
        </form>
    </body>
</html>
