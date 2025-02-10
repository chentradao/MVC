<%-- 
    Document   : insertEmployeeTe
    Created on : Oct 13, 2024, 12:11:40 PM
    Author     : nguye
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page  import="java.sql.ResultSet"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <%
            ResultSet rsEmp = (ResultSet)request.getAttribute("rsEmp");
            ResultSet rsTe = (ResultSet)request.getAttribute("rsTe");
        %>
        <form action="EmpTerritoryURL" method="post">
        <input type="hidden" name="service" value="insertEmployeeTe">
        <caption>Insert EmployeeTerritories</caption>
        <table>
            <tr>
                <td><label for="EmployeeID">Employee</label></td>
                <td><select name="EmployeeID" id="EmployeeID">
                    <%while (rsEmp.next()) {%>
                            <option value="<%=rsEmp.getInt(1)%>"><%=rsEmp.getString(2)%></option>
                            <%}%>
                </select></td>
            </tr>
            <tr>
                <td><label for="TerritoryID">Territory</label></td>
                <td><select name="TerritoryID" id="TerritoryID">
                   <%while (rsTe.next()) {%>
                            <option value="<%=rsTe.getString(1)%>"><%=rsTe.getString(2)%></option>
                            <%}%>
                </select></td>
            </tr>
            <tr>
                <td><input type="submit" name="submit" value="insertEmployeeTe"></td>
                <td><input type="reset" value="Clear"></td>
            </tr>
        </table>
    </form>
    </body>
</html>
