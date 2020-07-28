<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<html>
<head>
    <link href="static/css/reset.css" rel="stylesheet">
    <link href="static/bootstrap-3.3.7-dist/css/bootstrap.min.css" rel="stylesheet">
    <link href="static/css/swiper.min.css" rel="stylesheet">
    <link rel="stylesheet" href="static/css/index.css">
    <script src="static/js/jquery-3.3.1.min.js"></script>
    <script src="static/bootstrap-3.3.7-dist/js/bootstrap.min.js"></script>
    <script src="static/js/swiper.min.js"></script>

    <title>Home</title>
</head>
<body>
<c:import url="nav.jsp"/>
<%
    if (session.getAttribute("hot_pic") == null) {
        response.sendRedirect("/trip/indexPageServlet");
    }
%>
<div id="hotPic">
    <div id="swiper-box" class="swiper-container bannerPc banner-swiper banner-swiper2">
        <ul class="swiper-wrapper">
            <c:forEach items="${sessionScope['hot_pic']}" var="item">
                <li class="swiper-slide">
                    <a href="/trip/detailPageServlet?imageId=<c:out value="${item.getImageId()}"/>">
                        <img src="static/image/travel-images/medium/<c:out value="${item.getPath()}"/>"
                             class="hot-image"/>
                    </a>
                </li>
            </c:forEach>
        </ul>
        <div class="swiper-button-prev"></div>
        <div class="swiper-button-next"></div>
        <div class="swiper-pagination"></div>
    </div>

</div>

<div id="newPic" class="newPic">
    <c:forEach items="${sessionScope['new_pic']}" var="item">
        <div class="new">
            <img src="static/image/travel-images/medium/<c:out value="${item.getPath()}"/>" class="new-image"/>
            <p class="new-info">Title: <c:out value="${item.getTitle()}"/></p>
            <p class="new-info">Theme: <c:out value="${item.getTheme()}"/></p>
            <p class="new-info">Author: <c:out value="${item.getUserName()}"/></p>
            <p class="new-info">Time: <c:out value="${item.getTimeUpload()}"/></p>
            <a href="/trip/detailPageServlet?imageId=<c:out value="${item.getImageId()}"/>">More</a>
        </div>
    </c:forEach>

</div>
<script src="static/js/index.js"></script>
</body>

</html>
