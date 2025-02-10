<%-- 
    Document   : insertEmployee
    Created on : Oct 12, 2024, 5:55:48 PM
    Author     : nguye
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.sql.ResultSet" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Insert Employees</title>
    </head>
    <body>
        <% ResultSet rsRep = (ResultSet)request.getAttribute("rsRep");%>
         <form action="EmployeeURL" method="post">
        <input type="hidden" name="service" value="insertEmployees">
        <caption>Insert Employees</caption>
        <table>
            <tr>
                <td><label for="LastName">LastName</label></td>
                <td><input type="text" name="LastName"></td>
            </tr>
            <tr>
                <td><label for="FirstName">FirstName</label></td>
                <td><input type="text" name="FirstName"></td>
            </tr>
            <tr>
                <td><label for="Title">Title</label></td>
                <td><input type="text" name="Title"></td>
            </tr>
            <tr>
                <td><label for="TitleOfCourtesy">TitleOfCourtesy</label></td>
                <td><input type="text" name="TitleOfCourtesy"></td>
            </tr>
            <tr>
                <td><label for="BirthDate">BirthDate</label></td>
                <td><input type="text" name="BirthDate"></td>
            </tr>
            <tr>
                <td><label for="HireDate">HireDate</label></td>
                <td><input type="text" name="HireDate"></td>
            </tr>
            <tr>
                <td><label for="Address">Address</label></td>
                <td><input type="text" name="Address"></td>
            </tr>
            <tr>
                <td><label for="City">City</label></td>
                <td><input type="text" name="City"></td>
            </tr>
            <tr>
                <td><label for="Region">Region</label></td>
                <td><input type="text" name="Region"></td>
            </tr>
            <tr>
                <td><label for="PostalCode">PostalCode</label></td>
                <td><input type="text" name="PostalCode"></td>
            </tr>
            <tr>
                <td><label for="Country">Country</label></td>
                <td><input type="text" name="Country"></td>
            </tr>
            <tr>
                <td><label for="HomePhone">HomePhone</label></td>
                <td><input type="text" name="HomePhone"></td>
            </tr>
            <tr>
                <td><label for="Extension">Extension</label></td>
                <td><input type="text" name="Extension"></td>
            </tr>
            <tr>
                <td><label for="Photo">Photo</label></td>
                <td><input type="text" name="Photo"></td>
            </tr>
            <tr>
                <td><label for="Notes">Notes</label></td>
                <td><input type="text" name="Notes"></td>
            </tr>
            <tr>
                <td><label for="ReportsTo">ReportsTo</label></td>
                <td><select name="ReportsTo" id="ReportsTo">
                        <%while(rsRep.next()){%>
                    <option value="<%=rsRep.getInt(1)%>"><%=rsRep.getString(2)%></option>
                    <%}%>
                </select></td>
            </tr>
            <tr>
                <td><label for="PhotoPath">PhotoPath</label></td>
                <td><input type="text" name="PhotoPath"></td>
            </tr>
            <tr>
                <td><label for="EmployeeStatus">EmployeeStatus</lable></td>
                <td><select name="EmployeeStatus" id="EmployeeStatus">
                        <option value="0">Discontinue</option>
                        <option value="1">Continue</option>
                    </select></td>
            </tr>
            <tr>
                <td><input type="submit" name="submit" value="insertEmployees">
                    <input type="reset" value="Clear">
                </td>
            </tr>
        </table>
    </body>
</html>
