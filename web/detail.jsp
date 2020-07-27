<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link href="static/css/reset.css" rel="stylesheet">
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
            <img src="static/image/travel-images/medium/<c:out value="${sessionScope.image.getPath()}"/>"
                 class="detail-image"/>

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
    function addFavor(username,id) {
        if (username==null||username==""||id==null){
            alert("Please login first or refresh page!")
        } else {
            $.ajax({
                type: "POST",
                url: "/trip/addFavorServlet",

                data: {
                    "username":username,
                    "imageId":id
                },
                async : true,
                dataType: "json",
                success: function(result){
                   if (result.message=="success") {
                        alert("Success");
                    }else {
                        alert(result.message);
                    }
                }
            });

        }
    }

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
        width: 380px;
        height: 500px;

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

    tr {
        background-color: #F1F1F1;
        border-bottom: 1px solid white;
        color: #6E6E6E;
    }

    thead tr {
        background-color: #CACACA;
        padding: 0.75em;
        text-align: center;
        font-weight: bold;
        font-size: 1.25em;
    }


</style>
</html>
