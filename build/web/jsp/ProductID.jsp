<%-- 
    Document   : ProductID
    Created on : Oct 23, 2024, 11:56:00 PM
    Author     : nguye
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.util.Vector,entity.Categories,entity.Product" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <style> 
            .container 
            { 
                border: 1px solid black;
              width: 100%; /* Đảm bảo container chiếm toàn bộ chiều rộng có sẵn */ 
              box-sizing: border-box; /* Đảm bảo padding và border được bao gồm trong chiều rộng và chiều cao */ 
            } 
            .table-wrapper 
            { 
                display: flex; 
                flex-direction: row;
                width: 100%; /* Đảm bảo table-wrapper chiếm toàn bộ chiều rộng của container */ 
            } 
            .table-wrapper > .category 
            { border: 1px solid black; 
              flex: 1; /* Chiếm 1 phần trong tổng số 5 phần */ 
            } 
            .table-wrapper > .product {
                border: 1px solid black;
                flex: 4; /* Chiếm 4 phần trong tổng số 5 phần */
            }
            .header
            {
                text-align: center; /* Căn giữa tiêu đề */ 
                border: 1px solid black; 
            } 
            table 
            { 
                width: 100%; /* Đảm bảo bảng chiếm toàn bộ chiều rộng của div bao quanh */
                border-collapse: collapse; /* Đảm bảo bảng không có khoảng cách giữa các ô */ 
            } 
            th, td 
            { 
                border: 1px solid black; /* Thêm viền cho các ô trong bảng */ 
                text-align: left; /* Căn trái nội dung trong các ô */ 
            }
        </style>
    </head>
    <body>
        <%
            Vector<Product> vector=(Vector<Product>)request.getAttribute("vector");
            Vector<Categories> data=(Vector<Categories>)request.getAttribute("data");
            String title = (String)request.getAttribute("title");
        %>
        <form action="ProductURL"method="get">
                      <p>Search Name: <input type="text" name="pname" id="">
                          <input type="submit" value="Search" name="submit" >
                          <input type="reset" value="Clear">
                          <input type="hidden" name="service" value="Shopping">
                      </p>
                      </form>
         <p align="right"><a href="CartURL?service=showCart">Cart</a></p>
         <div class="container"> <div class="header"> <h1>Header for both tables</h1> </div>
         <div class="table-wrapper"> 
             <div class="category"> 
                 <table border="1px"> 
                     <caption><a href="MenuURL?service=Shopping" style="text-decoration: none"><h1>Category</h1></a></caption>
                     <%for(Categories cat :data) {%>
                     <tr>
                         <td> <!-- Nội dung của phần Category -->
                             <a href="MenuURL?service=findCategories&cid=<%=cat.getCategoryID()%>" style="text-decoration: none"><%=cat.getCategoryName()%></a>
                         </td> 
                     </tr>
                     <%}%>
                 </table> 
             </div>
             <div class="product">
        <table border 1px>
            <caption><h1><%=title%></h1></caption>
        <tr>
            <th>ProductID</th>
            <th>ProductName</th>
            <th>QuantityPerUnit</th>
            <th>UnitPrice</th>
            <th>UnitsInStock</th>
            <th>UnitsOnOrder</th>
            <th>ReorderLevel</th>
            <th>add to Cart</th>
        </tr>
        <%for(Product menu :vector) {%>
        <tr>
            <td><%=menu.getProductID()%></td>
            <td><%=menu.getProductName()%></td>
            <td><%=menu.getQuantityPerUnit()%></td>
            <td><%=menu.getUnitPrice()%></td>
            <td><%=menu.getUnitsInStock()%></td>
            <td><%=menu.getUnitsOnOrder()%></td>
            <td><%=menu.getReorderLevel()%></td>
            <td><a href="CartURL?service=add2cart&pid=<%=menu.getProductID()%>">add2cart</a></td>
        </tr>
        <%}%>
    </table>
        </div> 
        </div>
         </div>
    </body>
</html>
