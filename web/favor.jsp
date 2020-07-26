<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link href="static/css/reset.css" rel="stylesheet">
    <link href="static/bootstrap-3.3.7-dist/css/bootstrap.min.css" rel="stylesheet">
    <link href="static/css/favor.css" rel="stylesheet">
    <link href="static/css/paging.css" rel="stylesheet">
    <script src="static/js/jquery-3.3.1.min.js"></script>
    <script src="static/bootstrap-3.3.7-dist/js/bootstrap.min.js"></script>
    <title>Favor</title>
</head>
<body>
<c:import url="nav.jsp"/>

<%--
查看别人的list

1.点击链接带参数 /trip/getFavorServlet?currUsername=xxx
2.servlet中设置session currUsername=xxx
3.jsp比较两个用户名是否相同，设置布局

--%>

<%
    if (session.getAttribute("favor") == null) {
        response.sendRedirect("/trip/getFavorServlet");
    }
%>
<div>
    <div id="favor-box" class="col-md-8">

        <div id="favorList" class="">
            <c:forEach items="${sessionScope['favor']}" var="item">
                <div class="favor row panel panel-default">
                    <div class="col-md-4">
                        <img src="static/image/travel-images/medium/<c:out value="${item.getPath()}"/>"
                             class="favor-image"/>
                    </div>

                    <div class="favor-info col-md-7">
                        <p class="favor-title">Title: <c:out value="${item.getTitle()}"/></p>
                        <p class="favor-author">Author: <c:out value="${item.getUserName()}"/></p>
                        <p class="favor-theme">Theme: <c:out value="${item.getTheme()}"/></p>
                        <div class="operation col-md-4">
                            <a href="/trip/detailPageServlet?imageId=<c:out value="${item.getImageId()}"/>">More</a>
                            <input type="button" class="btn btn-default" value="Delete"
                                   onclick="deleteFavor(<c:out value="${item.getImageId()}"/>)" id="deleteBtn"></div>
                    </div>
                </div>
            </c:forEach>
        </div>


        <div id="page">

        </div>
    </div>
    <div id="right-pane" class="col-md-4">


        <div id="history-pane">
            <p class="list-group-item ">History</p>
            <c:forEach items="${sessionScope['history']}" var="item">

                <a href="/trip/detailPageServlet?imageId=<c:out value="${item.getImageId()}"/>" class="list-group-item">
                    <c:out value="${item.getTitle()}"/>
                </a>
            </c:forEach>

        </div>
    </div>
</div>
<script src="static/js/paging.js"></script>
<script src="static/js/favor.js" type="text/javascript"></script>
</body>

</html>
