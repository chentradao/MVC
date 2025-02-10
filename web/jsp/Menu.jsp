<%-- 
    Document   : Menu
    Created on : Oct 31, 2024, 12:42:10 PM
    Author     : nguye
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.util.Vector,entity.Categories" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <%
            Vector<Categories> data=(Vector<Categories>)request.getAttribute("data");
        %>
        <table border="1px"> 
                     <caption><a href="indexURL?service=listAllMenu" style="text-decoration: none"><h1>Category</h1></a></caption>
                     <%for(Categories cat :data) {%>
                     <tr>
                         <td> <!-- Nội dung của phần Category -->
                             <a href="indexURL?service=findCategories&cid=<%=cat.getCategoryID()%>" style="text-decoration: none"><%=cat.getCategoryName()%></a>
                         </td> 
                     </tr>
                     <%}%>
                 </table> 
    </body>
</html>
