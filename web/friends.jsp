<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link rel="stylesheet" href="static/css/reset.css">
    <link href="static/bootstrap-3.3.7-dist/css/bootstrap.min.css" rel="stylesheet">
    <link href="static/css/friends.css" rel="stylesheet">
    <link rel="stylesheet" href="static/css/bootstrap-switch.css">
    <script src="static/js/jquery-3.3.1.min.js"></script>
    <script src="static/bootstrap-3.3.7-dist/js/bootstrap.min.js"></script>
    <script src="static/js/bootstrap-switch.js"></script>

    <title>Friends</title>
</head>
<body>
<c:import url="nav.jsp"/>
<%
    if (request.getSession().getAttribute("friends") == null) {
        response.sendRedirect("/trip/getFriendsServlet");
    }
%>
<div id="container">
    <div id="friends-box" class="col-md-5">
        <p>Your Friends</p>
        <div id="friendsList" class="">
            <c:forEach items="${sessionScope['friends']}" var="item">
                <div class="friends  panel panel-default">
                    <div class="friends-info">
                        <p class="friends-name">Username: <c:out value="${item.userName}"/></p>
                        <p class="friends-email">Email: <c:out value="${item.email}"/></p>
                        <p class="friends-dateJoined">Date Joind: <c:out value="${item.dateJoined}"/></p>
                        <div class="operation col-md-4">
                            <a href="/trip/getFriendsFavorServlet?uid=<c:out value="${item.uid}"/>">His Favor</a>
                        </div>
                    </div>
                </div>
            </c:forEach>
        </div>

    </div>


    <div id="right-pane" class="col-md-7">

        <div id="friends-authority">
            <span>Let friends look up your favor</span>
            <input type="checkbox" name="authority" id="authority" data-size="small"
                   <c:if test="${sessionScope.userState}">
                       <c:out value="checked"/>
                   </c:if>/>
        </div>

        <hr/>
        <div id="search">

            <div id="search-user" class="form-inline">
                <input type="text" placeholder="search users..." class="form-control" id="search-text">
                <input type="button" class="btn btn-default" value="search" onclick="searchUser()">
            </div>


            <div id="search-result">
                <table class="table table-hover" id="users">
                    <caption>result</caption>
                    <thead>
                    <tr>
                        <th>username</th>
                        <th>email</th>
                        <th>operation</th>
                    </tr>
                    </thead>
                    <tbody>


                    <c:forEach items="${sessionScope['users']}" var="item">
                        <tr>
                            <td><c:out value="${item.userName}"/></td>
                            <td><c:out value="${item.email}"/></td>
                            <td>
                                <button class="addFriend btn btn-default"
                                        onclick="addFriend(<c:out value="${item.uid}"/>)">Add
                                </button>
                            </td>
                        </tr>
                    </c:forEach>

                    </tbody>
                </table>


            </div>

        </div>

        <hr/>
        <div id="myInvitation">
            <table class="table table-hover" id="invitations">
                <caption>Your Invitations</caption>
                <thead>
                <tr>
                    <th>username</th>
                    <th>email</th>
                    <th>operation</th>
                </tr>
                </thead>
                <tbody>


                <c:forEach items="${sessionScope['myInvitation']}" var="item">
                    <tr>
                        <td><c:out value="${item.senderName}"/></td>
                        <td><c:out value="${item.senderEmail}"/></td>
                        <td>
                            <button class="agree  btn btn-default"
                                    onclick="handleInvitation(1,<c:out value="${item.invitationId}"/>)">Agree
                            </button>
                            <button class="refuse  btn btn-default"
                                    onclick="handleInvitation(0,<c:out value="${item.invitationId}"/>)">Refuse
                            </button>
                        </td>
                    </tr>
                </c:forEach>

                </tbody>
            </table>
        </div>
    </div>
</div>

<script src="static/js/friends.js"></script>

</body>
</html>
