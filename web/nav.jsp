<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>

<nav class="navbar navbar-default" role="navigation">
    <div class="container-fluid">
        <div class="navbar-header">
            <a class="navbar-brand" href="/trip/indexPageServlet" id="logo">Trip</a>
        </div>
        <div>
            <ul class="nav navbar-nav">
                <li class="mynav"><a href="/trip/indexPageServlet">Home</a></li>
                <li class="mynav"><a href="search.jsp">Search</a></li>
            </ul>

            <c:choose>
                <c:when test="${sessionScope.username!=null&&sessionScope.username!=''}">
                    <ul class="nav  navbar-nav navbar-right">
                        <li class="dropdown">
                            <a class="dropdown-toggle" data-toggle="dropdown" href="#"><c:out
                                    value="${sessionScope.username}"/>
                                <span class="caret"></span></a>
                            <ul class="dropdown-menu">
                                <li><a href="myFavor.jsp">My Favorite</a></li>
                                <li><a href="upload.jsp">Upload New</a></li>
                                <li><a href="myPicture.jsp">My Upload</a></li>
                                <li><a href="/trip/getFriendsServlet">Friends</a></li>
                                <li class="divider"></li>
                                <li><a href="/trip/logoutServlet">Log Out</a></li>
                            </ul>
                        </li>

                    </ul>
                </c:when>

                <c:otherwise>
                    <ul class="nav navbar-nav navbar-right">
                        <li><a href="login.jsp"><span class="glyphicon glyphicon-user"></span> Login</a></li>
                        <li><a href="register.jsp">Register</a></li>
                    </ul>
                </c:otherwise>
            </c:choose>
        </div>
    </div>
</nav>

<style>
    #logo{
        font-family: "HGHT1_CNKI", "Segoe Script", "HGB4X_CNKI" ,"Consolas";
        font-size: 35pt;
        font-weight: bold;
    }

    .navbar .nav > li:hover .dropdown-menu {
        z-index: 10;
        display: block;
    }
</style>

<script>
    var title = document.title;
    switch (title) {
        case "Home":
            $(".mynav").eq(0).addClass("active");
            break;
        case "Search":
            $(".mynav").eq(1).addClass("active");
            break;
    }


</script>

</html>
