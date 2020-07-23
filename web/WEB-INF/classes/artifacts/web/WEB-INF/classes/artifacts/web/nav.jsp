<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link href="static/bootstrap-3.3.7-dist/css/bootstrap.min.css" rel="stylesheet">
    <script src="static/js/jquery-3.3.1.min.js"></script>
    <script src="static/bootstrap-3.3.7-dist/js/bootstrap.min.js"></script>
</head>

<nav class="navbar navbar-default" role="navigation">
    <div class="container-fluid">
        <div class="navbar-header">
            <a class="navbar-brand" href="#">Trip</a>
        </div>
        <div>
            <ul class="nav navbar-nav">
                <li class="active"><a href="#">首页</a></li>
                <li><a href="#">搜索</a></li>
            </ul>

            <!--for test-->
            <c:set var="username" scope="session" value=""/>

            <c:choose>
                <c:when test="${sessionScope.username!=null&&sessionScope.username!=''}">
                    <ul class="nav  navbar-nav navbar-right">
                        <li class="dropdown">
                            <a class="dropdown-toggle" data-toggle="dropdown" href="#"><c:out value="${sessionScope.username}"/>
                                <span class="caret"></span></a>
                            <ul class="dropdown-menu">
                                <li><a href="#">我的收藏</a></li>
                                <li><a href="#">上传图片</a></li>
                                <li><a href="#">我的图片</a></li>
                                <li><a href="#">我的好友</a></li>
                                <li class="divider"></li>
                                <li><a href="#">退出登录</a></li>
                            </ul>
                        </li>

                    </ul>
                </c:when>

                <c:otherwise>
                    <ul class="nav navbar-nav navbar-right">
                        <li><a href="login.jsp"><span class="glyphicon glyphicon-user"></span> 登录</a></li>
                        <li><a href="register.jsp">注册</a></li>
                    </ul>
                </c:otherwise>
            </c:choose>
        </div>
    </div>
</nav>

<style>
    .navbar .nav > li:hover .dropdown-menu {
        display: block;
    }
</style>

</html>
