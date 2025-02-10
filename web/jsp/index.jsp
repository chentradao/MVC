<%-- 
    Document   : index
    Created on : Oct 31, 2024, 11:33:15 AM
    Author     : nguye
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.util.Vector,entity.Categories,entity.Product,entity.Customer" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <style>
            .panner 
            {
                width: 100%; 
                text-align: center; 
                border-bottom: 1px solid #000; 
            } 
            .main
            {
                display: flex;
                height: calc(100vh - 50px); /* Giả sử chiều cao của panner là 50px */ 
            }
            .menu
            {
                flex: 1;
                width: 100%;
                border-right: 1px solid #000;
            } 
            .content 
            { 
                flex: 3;
            }
        </style>
    </head>
    <body>
        <%
            Vector<Product> catList = (Vector<Product>) request.getAttribute("catList");
            Vector<Product> vector = (Vector<Product>) request.getAttribute("vector");
            Vector<Categories> data = (Vector<Categories>) request.getAttribute("data");
            Customer cus = (Customer)request.getAttribute("cus");
        %>
        <div class="panner">
            <jsp:include page="/jsp/Panner.jsp" />
        </div>
        <div class="main">
            <div class="menu">
                <jsp:include page="/jsp/Menu.jsp" />
            </div>
            <div class="content">
                <jsp:include page="/jsp/Content.jsp" />
            </div>
        </div>
    </body>
</html>
