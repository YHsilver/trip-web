<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<html>
<head>
    <link href="static/css/reset.css" rel="stylesheet">
    <link href="static/bootstrap-3.3.7-dist/css/bootstrap.min.css" rel="stylesheet">
    <link href="static/css/swiper.min.css" rel="stylesheet">
    <script src="static/js/jquery-3.3.1.min.js"></script>

    <script src="static/bootstrap-3.3.7-dist/js/bootstrap.min.js"></script>
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
    <div id="swiper-container" class="swiper-container">
        <div class="swiper-wrapper">

            <c:forEach items="${sessionScope['hot_pic']}" var="item">
                <div class="swiper-item">

                    <img src="static/image/travel-images/medium/<c:out value="${item.getPath()}"/>"
                         class="hot-img" alt="banner"/>
                </div>
            </c:forEach>
        </div>
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
</body>
<style>
    #hotPic {
        text-align: center;
    }

    #swiper-container {
        margin: 0 auto;
    }


    .hot-img {
        width: inherit;
        height: inherit;
        object-fit: cover;
    }

    .newPic {
        display: flex;
        justify-content: space-between;
        margin: 20px;
    }

    .new {
        width: 400px;
        display: flex;
        flex-direction: column;
        justify-content: space-between;
        align-items: center;
    }

    .new-image {
        width: 300px;
        height: 200px;
    }

    .new-info {
        margin: 10px;
        font-family: "Arial", "sans-serif";
        font-size: 16px;
    }

    .newPic a {
        font: 1em "Segoe Script";
        text-decoration: none;
        font-size: 16px;
        padding: 3px 2px;
    }


</style>
<script src="static/js/swiper.min.js"></script>
<script>

    $(".swiper-container").carousel({
        width: 1500,
        height: 550,
        speed: 3000,
        needPrevAndNextBtnGroup: true,
        needPagination: true
    });
</script>

</html>
