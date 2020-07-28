<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link href="static/bootstrap-3.3.7-dist/css/bootstrap.min.css" rel="stylesheet">
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
                    </c:if> onclick="addFavor(<%=session.getAttribute("username")%>,${sessionScope.image.getImageId()})"
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
</main>


<script>
    function addFavor(username, id) {
        if (username == null || username == "" || id == null) {
            alert("Please login first or refresh page!")
        } else {
            $.ajax({
                type: "POST",
                url: "/trip/addFavorServlet",

                data: {
                    "username": username,
                    "imageId": id
                },
                async: true,
                dataType: "json",
                success: function (result) {
                    if (result.message == "success") {
                        alert("Success");
                    } else {
                        alert(result.message);
                    }
                }
            });

        }
    }


    window.onload = function () {

        var wrap = document.getElementsByClassName("wrap")[0];
        var smallImgBox = wrap.getElementsByClassName("imgBox")[0];
        var smallImg = smallImgBox.getElementsByTagName("img")[0];
        var bigImgBox = wrap.getElementsByClassName("imgBox")[1];
        var bigImg = bigImgBox.getElementsByTagName("img")[0];
        var shadow = document.getElementById("shadow");

        smallImgBox.onmouseover = function () {
            shadow.style.display = "block";
            bigImgBox.style.display = "block";
        };
        smallImgBox.onmouseout = function () {
            shadow.style.display = "none";
            bigImgBox.style.display = "none";
        };


        smallImgBox.onmousemove = function (ev) {

            var ev = ev || window.event;

            //鼠标在指定div里面的坐标:可视区里面鼠标坐标- div到文档边界的距离
            /*  var x =  ev.clientX  -   shadow.offsetParent.offsetLeft -shadow.offsetParent.offsetParent.offsetLeft   ;
              var y = ev.clientY  -    shadow.offsetParent.offsetTop  -shadow.offsetParent.offsetParent.offsetLeft;*/
            var x = ev.clientX - smallImgBox.offsetLeft - wrap.offsetLeft;
            var y = ev.clientY - smallImgBox.offsetTop - wrap.offsetTop;


            var l = x - shadow.offsetWidth / 2;
            var t = y - shadow.offsetHeight / 2;

            if (l <= 0) {
                l = 0;
            } else if (l >= smallImgBox.offsetWidth - shadow.offsetWidth) {
                l = smallImgBox.offsetWidth - shadow.offsetWidth;
            }
            if (t <= 0) {
                t = 0;
            } else if (t >= smallImgBox.offsetHeight - shadow.offsetHeight) {
                t = smallImgBox.offsetHeight - shadow.offsetHeight;
            }
            shadow.style.left = l + "px";
            shadow.style.top = t + "px";

            /*  var  radioX = l /   (smallImgBox.offsetWidth - shadow.offsetWidth);
              var  radioY = t /  (smallImgBox.offsetHeight - shadow.offsetHeight) ;
              document.title =radioX+" "+ radioY ;
              bigImg.style.left=-radioX*(bigImg.width - bigImgBox.offsetWidth) +"px";
              bigImg.style.top=-radioY*(bigImg.height - bigImgBox.offsetHeight) +"px";*/

            var radioX = x / (smallImgBox.offsetWidth - shadow.offsetWidth) >= 1 ? 1 : x / (smallImgBox.offsetWidth - shadow.offsetWidth);
            var radioY = y / (smallImgBox.offsetHeight - shadow.offsetHeight) >= 1 ? 1 : y / (smallImgBox.offsetHeight - shadow.offsetHeight);

            bigImg.style.left = -radioX * (bigImg.width - bigImgBox.offsetWidth) + "px";
            bigImg.style.top = -radioY * (bigImg.height - bigImgBox.offsetHeight) + "px";

        };
    };

</script>


</body>

<style>
    main {

    }

    main > div {
        margin-left: 10%;
    }

    #detail-name {
        font: 18pt "Segoe Script";
        margin-bottom: 2px;
        margin-left: 5px;
    }

    #detail-author {

        font: italic 12pt serif;
        margin-top: 2px;
    }

    #detail-author a {
        text-decoration: none;
    }

    #detail-author a:hover {
        color: rgba(56, 142, 199, 0.7);
    }

    #detail-description {

        font-size: 16pt;
        text-align: justify;
    }

    .detail-image {
        width: 400px;
        height: 400px;

    }

    #detail-box {
        margin: 0 auto;
        display: flex;
    }

    #right-text {
        margin-left: 10px;
        display: flex;
        justify-content: flex-start;
        flex-direction: column;
        width: 680px;


    }

    #buttons input {
        background-color: #87bff2;
        font-weight: bold;
    }

    #detail-table {
        border-collapse: collapse;
        font: 12pt Arial;
        margin-top: 20px;
    }

    #detail-table td {
        padding: 10px;


    }


    #detail-table tr {
        background-color: #F1F1F1;
        border-bottom: 1px solid white;
        color: #6E6E6E;
    }

    #detail-table thead tr {
        background-color: #CACACA;
        padding: 0.75em;
        text-align: center;
        font-weight: bold;
        font-size: 1.25em;
    }


    .wrap {
        position: relative;
        height: 400px;
        width: 400px;
        float: left;
    }

    .wrap .smallImg, .wrap .bigImg {
        position: absolute;
        top: 0;
        width: 400px;
        height: 400px;
        border: 1px solid #FFFFFF;
        overflow: hidden;
        z-index: 10;
    }

    .wrap .smallImg {
        left: 0;
        cursor: move;
    }

    .wrap .bigImg {
        left: 410px;
        display: none;
    }

    .wrap .bigImg img {
        position: absolute;
        left: 0;
        top: 0;
    }

    #shadow {
        position: absolute;
        left: 0;
        top: 0;
        display: none;
        width: 100px;
        height: 100px;
    }

    #shadow table {
        border-collapse: collapse;
        border-color: rgba(115, 150, 218, 0.5);
    }


    .td_top {
        border-top: 1px solid rgba(0, 0, 0, 0);
    }

    .td_left {
        border-left: 1px solid rgba(0, 0, 0, 0);
    }

    .td_right {
        border-right: 1px solid rgba(0, 0, 0, 0);
    }

    .td_bottom {
        border-bottom: 1px solid rgba(0, 0, 0, 0);
    }


</style>
</html>
