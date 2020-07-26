<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link href="static/css/reset.css" rel="stylesheet">
    <link href="static/bootstrap-3.3.7-dist/css/bootstrap.min.css" rel="stylesheet">
    <link href="static/css/myPicture.css" rel="stylesheet">
    <link href="static/css/paging.css" rel="stylesheet">
    <script src="static/js/jquery-3.3.1.min.js"></script>
    <script src="static/bootstrap-3.3.7-dist/js/bootstrap.min.js"></script>
    <title>My Picture</title>
</head>
<body>
<c:import url="nav.jsp"/>

<%
    if (session.getAttribute("myPic") == null) {
        response.sendRedirect("/trip/getMyPictureServlet");
    }
%>
<div>
    <div id="myPic-box">
        <div id="myPicList" class="">
            <c:forEach items="${sessionScope['myPic']}" var="item">
                <div class="myPic row panel panel-default">
                    <div class="col-md-4">
                        <img src="static/image/travel-images/medium/<c:out value="${item.getPath()}"/>"
                             class="myPic-image"/>
                    </div>

                    <div class="myPic-info col-md-7">
                        <p class="myPic-title">Title: <c:out value="${item.getTitle()}"/></p>
                        <p class="myPic-theme">Theme: <c:out value="${item.getTheme()}"/></p>
                        <div class="operation col-md-1">

                            <a href="/trip/detailPageServlet?imageId=<c:out value="${item.getImageId()}"/>">More</a>
                        </div>

                        <div class="operation col-md-3">


                            <a href="uploadServlet?imageId=<c:out value="${item.getImageId()}"/>">
                                <input type="button" class="btn btn-default" value="Modify" id="modifyBtn">
                            </a>
                            <input type="button" class="btn btn-default" value="Delete"
                                   onclick="deleteMyPic(<c:out value="${item.getImageId()}"/>)" id="deleteBtn"></div>
                    </div>
                </div>
            </c:forEach>
        </div>


        <div id="page">

        </div>
    </div>
</div>


<script src="static/js/paging.js"></script>
<script src="static/js/myPicture.js"></script>
</body>
</html>
