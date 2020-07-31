<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link href="static/bootstrap-3.3.7-dist/css/bootstrap.min.css" rel="stylesheet">
    <link rel="stylesheet" href="static/css/detail.css">
    <script src="static/js/jquery-3.3.1.min.js"></script>
    <script src="static/bootstrap-3.3.7-dist/js/bootstrap.min.js"></script>
    <title>Details</title>
</head>
<body>
<c:import url="nav.jsp"/>
<%
    if (session.getAttribute("image") == null) {
        if (request.getParameter("imageId") != null && !request.getParameter("imageId").equals("")) {
            request.getRequestDispatcher("/detailPageServlet").forward(request, response);
        } else {
            response.sendRedirect("index.jsp");
        }
    }
%>
<main>
    <div>
        <p id="detail-name"><c:out value="${sessionScope.image.getTitle()}"/></p>
        <p id="detail-author"><c:out value="${sessionScope.image.getUserName()}"/></p>

        <div id="detail-box">

            <div class="wrap">

                <div class="smallImg imgBox">

                    <img src="static/image/travel-images/medium/<c:out value="${sessionScope.image.getPath()}"/>"
                         class="detail-image"/>

                    <div id="shadow">
                        <table border="1px" width="100px" height="100px">
                            <tr>
                                <td class="td_top td_left"></td>
                                <td class="td_top"></td>
                                <td class="td_top"></td>
                                <td class="td_top"></td>
                                <td class="td_top"></td>
                                <td class="td_top"></td>
                                <td class="td_top"></td>
                                <td class="td_top"></td>
                                <td class="td_top"></td>
                                <td class="td_top"></td>
                                <td class="td_top"></td>
                                <td class="td_top"></td>
                                <td class="td_top"></td>
                                <td class="td_top"></td>
                                <td class="td_top"></td>
                                <td class="td_top"></td>
                                <td class="td_top"></td>
                                <td class="td_top"></td>
                                <td class="td_top"></td>
                                <td class="td_top td_right"></td>
                            </tr>
                            <tr>
                                <td class="td_left"></td>
                                <td></td>
                                <td></td>
                                <td></td>
                                <td></td>
                                <td></td>
                                <td></td>
                                <td></td>
                                <td></td>
                                <td></td>
                                <td></td>
                                <td></td>
                                <td></td>
                                <td></td>
                                <td></td>
                                <td></td>
                                <td></td>
                                <td></td>
                                <td></td>
                                <td class="td_right"></td>
                            </tr>
                            <tr>
                                <td class="td_left"></td>
                                <td></td>
                                <td></td>
                                <td></td>
                                <td></td>
                                <td></td>
                                <td></td>
                                <td></td>
                                <td></td>
                                <td></td>
                                <td></td>
                                <td></td>
                                <td></td>
                                <td></td>
                                <td></td>
                                <td></td>
                                <td></td>
                                <td></td>
                                <td></td>
                                <td class="td_right"></td>
                            </tr>
                            <tr>
                                <td class="td_left"></td>
                                <td></td>
                                <td></td>
                                <td></td>
                                <td></td>
                                <td></td>
                                <td></td>
                                <td></td>
                                <td></td>
                                <td></td>
                                <td></td>
                                <td></td>
                                <td></td>
                                <td></td>
                                <td></td>
                                <td></td>
                                <td></td>
                                <td></td>
                                <td></td>
                                <td class="td_right"></td>
                            </tr>
                            <tr>
                                <td class="td_left"></td>
                                <td></td>
                                <td></td>
                                <td></td>
                                <td></td>
                                <td></td>
                                <td></td>
                                <td></td>
                                <td></td>
                                <td></td>
                                <td></td>
                                <td></td>
                                <td></td>
                                <td></td>
                                <td></td>
                                <td></td>
                                <td></td>
                                <td></td>
                                <td></td>
                                <td class="td_right"></td>
                            </tr>
                            <tr>
                                <td class="td_left"></td>
                                <td></td>
                                <td></td>
                                <td></td>
                                <td></td>
                                <td></td>
                                <td></td>
                                <td></td>
                                <td></td>
                                <td></td>
                                <td></td>
                                <td></td>
                                <td></td>
                                <td></td>
                                <td></td>
                                <td></td>
                                <td></td>
                                <td></td>
                                <td></td>
                                <td class="td_right"></td>
                            </tr>
                            <tr>
                                <td class="td_left"></td>
                                <td></td>
                                <td></td>
                                <td></td>
                                <td></td>
                                <td></td>
                                <td></td>
                                <td></td>
                                <td></td>
                                <td></td>
                                <td></td>
                                <td></td>
                                <td></td>
                                <td></td>
                                <td></td>
                                <td></td>
                                <td></td>
                                <td></td>
                                <td></td>
                                <td class="td_right"></td>
                            </tr>
                            <tr>
                                <td class="td_left"></td>
                                <td></td>
                                <td></td>
                                <td></td>
                                <td></td>
                                <td></td>
                                <td></td>
                                <td></td>
                                <td></td>
                                <td></td>
                                <td></td>
                                <td></td>
                                <td></td>
                                <td></td>
                                <td></td>
                                <td></td>
                                <td></td>
                                <td></td>
                                <td></td>
                                <td class="td_right"></td>
                            </tr>
                            <tr>
                                <td class="td_left"></td>
                                <td></td>
                                <td></td>
                                <td></td>
                                <td></td>
                                <td></td>
                                <td></td>
                                <td></td>
                                <td></td>
                                <td></td>
                                <td></td>
                                <td></td>
                                <td></td>
                                <td></td>
                                <td></td>
                                <td></td>
                                <td></td>
                                <td></td>
                                <td></td>
                                <td class="td_right"></td>
                            </tr>
                            <tr>
                                <td class="td_left"></td>
                                <td></td>
                                <td></td>
                                <td></td>
                                <td></td>
                                <td></td>
                                <td></td>
                                <td></td>
                                <td></td>
                                <td></td>
                                <td></td>
                                <td></td>
                                <td></td>
                                <td></td>
                                <td></td>
                                <td></td>
                                <td></td>
                                <td></td>
                                <td></td>
                                <td class="td_right"></td>
                            </tr>
                            <tr>
                                <td class="td_left"></td>
                                <td></td>
                                <td></td>
                                <td></td>
                                <td></td>
                                <td></td>
                                <td></td>
                                <td></td>
                                <td></td>
                                <td></td>
                                <td></td>
                                <td></td>
                                <td></td>
                                <td></td>
                                <td></td>
                                <td></td>
                                <td></td>
                                <td></td>
                                <td></td>
                                <td class="td_right"></td>
                            </tr>
                            <tr>
                                <td class="td_left"></td>
                                <td></td>
                                <td></td>
                                <td></td>
                                <td></td>
                                <td></td>
                                <td></td>
                                <td></td>
                                <td></td>
                                <td></td>
                                <td></td>
                                <td></td>
                                <td></td>
                                <td></td>
                                <td></td>
                                <td></td>
                                <td></td>
                                <td></td>
                                <td></td>
                                <td class="td_right"></td>
                            </tr>
                            <tr>
                                <td class="td_left"></td>
                                <td></td>
                                <td></td>
                                <td></td>
                                <td></td>
                                <td></td>
                                <td></td>
                                <td></td>
                                <td></td>
                                <td></td>
                                <td></td>
                                <td></td>
                                <td></td>
                                <td></td>
                                <td></td>
                                <td></td>
                                <td></td>
                                <td></td>
                                <td></td>
                                <td class="td_right"></td>
                            </tr>
                            <tr>
                                <td class="td_left"></td>
                                <td></td>
                                <td></td>
                                <td></td>
                                <td></td>
                                <td></td>
                                <td></td>
                                <td></td>
                                <td></td>
                                <td></td>
                                <td></td>
                                <td></td>
                                <td></td>
                                <td></td>
                                <td></td>
                                <td></td>
                                <td></td>
                                <td></td>
                                <td></td>
                                <td class="td_right"></td>
                            </tr>
                            <tr>
                                <td class="td_left"></td>
                                <td></td>
                                <td></td>
                                <td></td>
                                <td></td>
                                <td></td>
                                <td></td>
                                <td></td>
                                <td></td>
                                <td></td>
                                <td></td>
                                <td></td>
                                <td></td>
                                <td></td>
                                <td></td>
                                <td></td>
                                <td></td>
                                <td></td>
                                <td></td>
                                <td class="td_right"></td>
                            </tr>
                            <tr>
                                <td class="td_left"></td>
                                <td></td>
                                <td></td>
                                <td></td>
                                <td></td>
                                <td></td>
                                <td></td>
                                <td></td>
                                <td></td>
                                <td></td>
                                <td></td>
                                <td></td>
                                <td></td>
                                <td></td>
                                <td></td>
                                <td></td>
                                <td></td>
                                <td></td>
                                <td></td>
                                <td class="td_right"></td>
                            </tr>
                            <tr>
                                <td class="td_left"></td>
                                <td></td>
                                <td></td>
                                <td></td>
                                <td></td>
                                <td></td>
                                <td></td>
                                <td></td>
                                <td></td>
                                <td></td>
                                <td></td>
                                <td></td>
                                <td></td>
                                <td></td>
                                <td></td>
                                <td></td>
                                <td></td>
                                <td></td>
                                <td></td>
                                <td class="td_right"></td>
                            </tr>
                            <tr>
                                <td class="td_left"></td>
                                <td></td>
                                <td></td>
                                <td></td>
                                <td></td>
                                <td></td>
                                <td></td>
                                <td></td>
                                <td></td>
                                <td></td>
                                <td></td>
                                <td></td>
                                <td></td>
                                <td></td>
                                <td></td>
                                <td></td>
                                <td></td>
                                <td></td>
                                <td></td>
                                <td class="td_right"></td>
                            </tr>
                            <tr>
                                <td class="td_left"></td>
                                <td></td>
                                <td></td>
                                <td></td>
                                <td></td>
                                <td></td>
                                <td></td>
                                <td></td>
                                <td></td>
                                <td></td>
                                <td></td>
                                <td></td>
                                <td></td>
                                <td></td>
                                <td></td>
                                <td></td>
                                <td></td>
                                <td></td>
                                <td></td>
                                <td class="td_right"></td>
                            </tr>
                            <tr>
                                <td class="td_left"></td>
                                <td></td>
                                <td></td>
                                <td></td>
                                <td></td>
                                <td></td>
                                <td></td>
                                <td></td>
                                <td></td>
                                <td></td>
                                <td></td>
                                <td></td>
                                <td></td>
                                <td></td>
                                <td></td>
                                <td></td>
                                <td></td>
                                <td></td>
                                <td></td>
                                <td class="td_right"></td>
                            </tr>
                            <tr>
                                <td class="td_left td_bottom"></td>
                                <td class="td_bottom"></td>
                                <td class="td_bottom"></td>
                                <td class="td_bottom"></td>
                                <td class="td_bottom"></td>
                                <td class="td_bottom"></td>
                                <td class="td_bottom"></td>
                                <td class="td_bottom"></td>
                                <td class="td_bottom"></td>
                                <td class="td_bottom"></td>
                                <td class="td_bottom"></td>
                                <td class="td_bottom"></td>
                                <td class="td_bottom"></td>
                                <td class="td_bottom"></td>
                                <td class="td_bottom"></td>
                                <td class="td_bottom"></td>
                                <td class="td_bottom"></td>
                                <td class="td_bottom"></td>
                                <td class="td_bottom"></td>
                                <td class="td_right td_bottom"></td>
                            </tr>
                        </table>
                    </div>
                </div>

                <div class="bigImg imgBox">
                    <img src="static/image/travel-images/medium/<c:out value="${sessionScope.image.getPath()}"/>"
                         width="800" height="800"/>
                </div>

            </div>

            <div id="right-text"><p id="detail-description"><c:out value="${sessionScope.image.getDescription()}"/></p>

                <div id="buttons">

                    <input type="button" class="btn btn-primary"
                    <c:if test="${sessionScope.username==null||sessionScope.username==''}">
                        <c:out value="disabled='disabled'"/>
                    </c:if> onclick="addFavor('<c:out value="${sessionScope.username}"/>',${sessionScope.image.getImageId()})"
                           value="Add to My Favor" id='addCart'>
                </div>

                <table id="detail-table">
                    <thead>
                    <tr>
                        <td colspan="2">Image Details</td>
                    </tr>
                    </thead>
                    <tr>
                        <td>Theme</td>
                        <td><c:out value="${sessionScope.image.getTheme()}"/></td>
                    </tr>
                    <tr>
                        <td>Country</td>
                        <td><c:out value="${sessionScope.image.getCountry()}"/></td>
                    </tr>
                    <tr>
                        <td>City</td>
                        <td><c:out value="${sessionScope.image.getCity()}"/></td>
                    </tr>
                    <tr>
                        <td>Time</td>
                        <td><c:out value="${sessionScope.image.getTimeUpload()}"/></td>
                    </tr>

                    <tr>
                        <td>Heat</td>
                        <td><c:out value="${sessionScope.image.getHot()}"/></td>
                    </tr>

                </table>

            </div>
        </div>
    </div>
    <div id="bottom">

        <h4>Comments:</h4>
        <div class="form-inline">
            <input type="text" id="comment-input" class="form-control">
            <input type="button" value="send" id="comment-send" class=" btn btn-default"
                   onclick="sendComment(${sessionScope.image.getImageId()})">
        </div>


        <div id="orders" iid="${sessionScope.image.getImageId()}">
            <span>order</span>
            <input type="radio" name="order" id="order1" value="hot" checked> <span>hot</span>
            <input type="radio" name="order" id="order2" value="time"><span>newest</span>
        </div>
        <div id="comments-box">
            <c:forEach items="${sessionScope['comments']}" var="item">
                <div class="comment">
                    <p class="comment-username"><c:out value="${item.username}"/>:</p>
                    <p class="userComments"><c:out value="${item.comment}"/></p>

                    <p class="comment-time"><c:out value="${item.time}"/></p>

                    <p class="heat">
                        <c:out value="${item.hot}"/>
                        <a>
                            <span class="glyphicon glyphicon-thumbs-up"
                                  onclick="agreeComment(${item.cid})"></span>
                        </a>
                    </p>
                </div>
            </c:forEach>
        </div>
    </div>
</main>


<script src="static/js/detail.js"></script>
</body>

<style>


</style>

</html>
