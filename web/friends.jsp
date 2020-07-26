<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link href="static/css/reset.css" rel="stylesheet">
    <link href="static/bootstrap-3.3.7-dist/css/bootstrap.min.css" rel="stylesheet">
    <link href="static/css/friends.css" rel="stylesheet">
    <script src="static/js/jquery-3.3.1.min.js"></script>
    <script src="static/bootstrap-3.3.7-dist/js/bootstrap.min.js"></script>
    <title>Friends</title>
</head>
<body>
<c:import url="nav.jsp"/>
<%
    if (session.getAttribute("friends") == null) {
        response.sendRedirect("/trip/getFriendsServlet");
    }
%>







<script src="static/js/friends.js"></script>
</body>
</html>
