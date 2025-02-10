<%-- 
    Document   : updateCustomerDemo
    Created on : Oct 16, 2024, 9:42:56 AM
    Author     : nguye
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="entity.CustomerDemographic,java.util.Vector" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <form action="CustomerDemographicURL" method="post">
        <input type="hidden" name="service" value="updateCustomerDemo">
        <caption>Update CustomerDemo</caption>
        <table>
            <%
                Vector<CustomerDemographic> vector =(Vector<CustomerDemographic>)request.getAttribute("vector");
                CustomerDemographic cus = vector.get(0);
            %>
            <tr>
                <td><label for="CustomerTypeID">CustomerTypeID</label></td>
                <td><input type="text" name="CustomerTypeID" readonly value="<%= cus.getCustomerTypeID() %>"></td>
            </tr>
            <tr>
                <td><label for="CustomerDesc">CustomerDesc</label></td>
                <td><input type="text" name="CustomerDesc" readonly value="<%= cus.getCustomerDesc() %>"></td>
            </tr>
            <tr>
                <td><label for="DemographicStatus">DemographicStatus</label></td>
                <td><select name="DemographicStatus" id="DemographicStatus">
                    <option value="0"
                            <%= cus.getDemographicStatus()==0?"selected":"" %>>Discontinued</option>
                    <option value="1"
                            <%= cus.getDemographicStatus()==1?"selected":"" %>>Continue</option>
                </select></td>
            </tr>
             <tr>
                <td><input type="submit" value="Update" name="submit">
                    <input type="reset" value="Clear">
                </td>
            </tr>
        </table>
    </form>
    </body>
</html>
