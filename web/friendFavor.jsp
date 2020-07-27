<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link href="static/css/reset.css" rel="stylesheet">
    <link href="static/bootstrap-3.3.7-dist/css/bootstrap.min.css" rel="stylesheet">
    <link href="static/css/friendFavor.css" rel="stylesheet">
    <link href="static/css/paging.css" rel="stylesheet">
    <script src="static/js/jquery-3.3.1.min.js"></script>
    <script src="static/bootstrap-3.3.7-dist/js/bootstrap.min.js"></script>
    <title>Friend's friendsFavor</title>
</head>
<body>

<c:import url="nav.jsp"/>

<%
    if (session.getAttribute("friendsFavor") == null) {
        response.sendRedirect("/trip/getFriendsFavorServlet");
    }
%>

<h2><c:out value="${sessionScope.friend.userName}"/>'s Favor :</h2>
<c:choose>
    <c:when test="${sessionScope.friend.state==1}">



        <div id="friendsFavor-box" >
            <div id="friendsFavorList" >
                <c:forEach items="${sessionScope['friendsFavor']}" var="item">
                    <div class="friendsFavor row panel panel-default">
                        <div class="col-md-4">
                            <img src="static/image/travel-images/medium/<c:out value="${item.getPath()}"/>"
                                 class="friendsFavor-image"/>
                        </div>

                        <div class="friendsFavor-info col-md-7">
                            <p class="friendsFavor-title">Title: <c:out value="${item.getTitle()}"/></p>
                            <p class="friendsFavor-author">Author: <c:out value="${item.getUserName()}"/></p>
                            <p class="friendsFavor-theme">Theme: <c:out value="${item.getTheme()}"/></p>
                            <p class="friendsFavor-hot">Heat: <c:out value="${item.getHot()}"/></p>
                            <div class="operation col-md-4">
                                <a href="/trip/detailPageServlet?imageId=<c:out value="${item.getImageId()}"/>">More</a>
                            </div>
                        </div>
                    </div>
                </c:forEach>
            </div>


            <div id="page">

            </div>
        </div>


    </c:when>
    <c:otherwise>
        <h3 >User set privacy, you can't look up his/her favor</h3>
    </c:otherwise>


</c:choose>

<script src="static/js/paging.js"></script>
<script src="static/js/friendFavor.js"></script>
</body>
</html>
