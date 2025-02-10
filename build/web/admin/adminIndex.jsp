<%-- 
    Document   : adminIndex
    Created on : Nov 3, 2024, 9:27:05 PM
    Author     : nguye
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="entity.Employees" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link href="css/styleDisplay.css" rel="stylesheet">
    </head>
    
    <body>
        <%
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
                <jsp:include page="/jsp/EmployeeID.jsp" />
            </div>
        </div>
    </body>
</html>
