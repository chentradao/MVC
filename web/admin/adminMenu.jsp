<%-- 
    Document   : adminMenu
    Created on : Nov 3, 2024, 9:28:48 PM
    Author     : nguye
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="entity.Employees" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>     
    <body>
        <%
            Employees emp = (Employees)request.getAttribute("emp");
        %>
        <table>
            <tr>
                <th><a href="adminIndexURL" style="text-decoration: none"><h1>Menu</h1></a></th>
            </tr>
            <%if(emp != null){%>
            <tr>
                <td><a href="ProductURL?service=listAllProducts">product controller</a></td>
            </tr>
            <tr>
                <td><a href="EmployeeURL?service=listAllEmployees">employee controller</a></td>
            </tr>
            <tr>
                <td><a href="ShipperURL?service=listAllShippers">shipper controller </a></td>
            </tr>
            <tr>
                <td><a href="TerritorieURL?service=listAllTerritories">territory controller</a></td>
            </tr>
            <tr>
                <td><a href="OrderURL?service=listAllOrders">order controller</a></td>
            </tr>
            <tr>
                <td><a href="EmpTerritoryURL?service=listAllEmpTerritories">EmpTerritory controller</a></td>
            </tr>
            <tr>
                <td><a href="CustomerURL?service=listAllCustomers">customer controller</a></td>
            </tr>
            <tr>
                <td><a href="OrderDetailURL?service=listAllOrderDetails">OrderDetail controller</a></td>
            </tr>
            <tr>
                <td><a href="SupplierURL?service=listAllSuppliers">Supplier controller</a></td>
            </tr>
            <tr>
                <td><a href="RegionURL?service=listAllRegion">Region controller</a></td>
            </tr>
            <tr>
                <td><a href="CategoryURL?service=listAllCategories">Categories controller</a></td>
            </tr>
            <tr>
                <td><a href="CustomerDemographicURL?service=listAllCustomerDemographics">CustomerDemographics controller</a></td>
            </tr>
            <tr>
                <td><a href="CustomerCustomerDemoURL?service=listAllCustomerCustomerDemo">CustomerCustomerDemo Controller</a></td>
            </tr>
            <%}%>
        </table>
    </body>
</html>
