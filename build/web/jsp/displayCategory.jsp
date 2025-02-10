<%-- 
    Document   : displayCategory
    Created on : Oct 13, 2024, 5:15:22 PM
    Author     : nguye
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="entity.Categories,java.util.Vector,entity.Employees" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link href="css/styleDisplay.css" rel="stylesheet">
    </head>
    <body>
        <%
            Vector<Categories> vector = (Vector<Categories>)request.getAttribute("data");
            String title =(String)request.getAttribute("title");           
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
                <form action="CategoryURL" method="get">
                    <p>Search Name: <input type="text" name="cname">
                        <input type="submit" name="submit" value="Search">
                        <input type="reset" value="Clear">
                        <input type="hidden" name="service" value="listAllCategories">
                    </p>
                </form>
                <p><a href="CategoryURL?service=insertCategories">Insert Categories</a>
                <table border 1px>
                    <caption><h1><%=title%></h1></caption>
                    <tr>
                        <th>CategoryID</th>
                        <th>CategoryName</th>
                        <th>Description</th>
                        <!--                <th>Picture</th>-->
                        <th>CategoryStatus</th>
                        <th>delete</th>
                    </tr>
                    <%for (Categories cat : vector) {%>  
                    <tr>\n"
                        <td><%=cat.getCategoryID()%></td>
                        <td><a href="ProductURL?service=findCategories&cid=<%=cat.getCategoryID()%>" style="text-decoration: none"><%=cat.getCategoryName()%></a></td>
                        <td><%=cat.getDescription()%></td>
                        <td><%=cat.getCategoryStatus()%></td>
                        <td><a href="CategoryURL?service=deleteCategories&cid=<%=cat.getCategoryID()%>">delete</a></td>
                    </tr>
                    <%}%>
                </table>
            </div>
        </div>
    </body>
</html>
