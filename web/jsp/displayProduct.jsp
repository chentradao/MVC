<%-- 
    Document   : displayProduct
    Created on : Oct 3, 2024, 11:07:45 AM
    Author     : nguye
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.util.Vector,entity.Product,entity.Employees" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>display Product</title>
        <link href="css/styleDisplay.css" rel="stylesheet">
        </style>
    </head>
    <body>
        <%
            Vector<Product> vector=(Vector<Product>)request.getAttribute("vector");
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
        <form action="ProductURL"method="get">
                      <p>Search Name: <input type="text" name="pname" id="">
                          <input type="submit" value="Search" name="submit" >
                          <input type="reset" value="Clear">
                          <input type="hidden" name="service" value="listAllProducts">
                      </p>
                      </form>
         <p><a href="ProductURL?service=insertProduct">insert product</a></p>
         <p align="right"><a href="CartURL?service=showCart">Cart</a></p>
        <table border 1px>
            <caption><h1><%=title%></h1></caption>
        <tr>
            <th>ProductID</th>
            <th>ProductName</th>
            <th>SupplierID</th>
            <th>CategoryID</th>
            <th>QuantityPerUnit</th>
            <th>UnitPrice</th>
            <th>UnitsInStock</th>
            <th>UnitsOnOrder</th>
            <th>ReorderLevel</th>
            <th>Discontinued</th>
            <th>update</th>
            <th>delete</th>
            <th>add to Cart</th>
        </tr>
        <%for(Product product :vector) {%>
        <tr>
            <td><%=product.getProductID()%></td>
            <td><%=product.getProductName()%></td>
            <td><%=product.getSupplierID()%></td>
            <td><%=product.getCategoryID()%></td>
            <td><%=product.getQuantityPerUnit()%></td>
            <td><%=product.getUnitPrice()%></td>
            <td><%=product.getUnitsInStock()%></td>
            <td><%=product.getUnitsOnOrder()%></td>
            <td><%=product.getReorderLevel()%></td>
            <td><%=product.isDiscontinued()%></td>
            <td><a href="ProductURL?service=updateProduct&pid=<%=product.getProductID()%>">update</a></td>
            <td><a href="ProductURL?service=deleteProduct&pid=<%=product.getProductID()%>">delete</a></td>
            <td><a href="CartURL?service=add2cart&pid=<%=product.getProductID()%>">add2cart</a></td>
        </tr>
        <%}%>
    </table>
    </div>
        </div>
    </body>
</html>
