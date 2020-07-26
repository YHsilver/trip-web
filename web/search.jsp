<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<html>
<head>
    <link href="static/css/reset.css" rel="stylesheet">
    <link href="static/bootstrap-3.3.7-dist/css/bootstrap.min.css" rel="stylesheet">
    <link rel="stylesheet" href="static/css/search.css">
    <link href="static/css/paging.css" rel="stylesheet">
    <script src="static/js/jquery-3.3.1.min.js"></script>
    <script src="static/bootstrap-3.3.7-dist/js/bootstrap.min.js"></script>
    <title>Search</title>
</head>
<body>
<c:import url="nav.jsp"/>
<main>
    <div id="searchBox" class="panel panel-default">
        <form class="form-inline panel-body" role="form" id="searchForm" action="/trip/searchServlet" method="post">
            <input type="text" id="searchTxt" class="form-control" placeholder="search for...">
            <div class="form-group">
                <span>Search by: &nbsp; </span>
                <label class="radio-inline">
                    <input type="radio" name="field" id="field1" value="title" checked> Title
                </label>
                <label class="radio-inline">
                    <input type="radio" name="field" id="field2" value="theme"> Theme
                </label>

            </div>
            <div class="form-group">
                <span>Order by: &nbsp;</span>
                <label class="radio-inline">

                    <input type="radio" name="order" id="order1" value="TimeUpload" checked> newest upload
                </label>
                <label class="radio-inline">
                    <input type="radio" name="order" id="order2" value="hot"> top heat
                </label>
            </div>
            <input type="button" class="btn btn-default" value="Search" onclick="search()">
        </form>


    </div>

    <div id="resultBox">
        <div class="panel panel-default">
            <div class="panel-heading">
               Search Result
            </div>
            <div class="panel-body" id="searchResultPane">
                <div id="searchResult">
                  <div class="result" id="result">
                     <c:forEach items="${sessionScope['results']}" var="item">
                         <div class="items">
                             <img src="static/image/travel-images/medium/<c:out value="${item.getPath()}"/>" class="image img-responsive"/>
                             <p class="title">Title: <c:out value="${item.getTitle()}"/></p>
                             <p class="author">Author: <c:out value="${item.getUserName()}"/></p>
                             <p class="theme">Theme: <c:out value="${item.getTheme()}"/></p>
                             <p class="time">Time: <c:out value="${item.getTimeUpload()}"/></p>
                             <p class="heat">Heat: <c:out value="${item.getHot()}"/></p>
                             <a href="/trip/detailPageServlet?imageId=<c:out value="${item.getImageId()}"/>">More</a>
                         </div>
                     </c:forEach>

                </div>
                <div id="page">

                </div>
            </div>
        </div>

    </div>

    </div>
</main>

</body>

<script src="static/js/paging.js"></script>
<script src="static/js/search.js"></script>
<script>

</script>

</html>
