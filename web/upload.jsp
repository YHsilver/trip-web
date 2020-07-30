<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" pageEncoding="utf-8" language="java" %>
<html>
<head>
    <link href="static/css/reset.css" rel="stylesheet">
    <link href="static/bootstrap-3.3.7-dist/css/bootstrap.min.css" rel="stylesheet">
    <link rel="stylesheet" href="static/css/upload.css">
    <script src="static/js/jquery-3.3.1.min.js"></script>
    <script src="static/bootstrap-3.3.7-dist/js/bootstrap.min.js"></script>
    <title>Upload</title>
</head>
<body>
<c:import url="nav.jsp"/>

<%
    if (request.getAttribute("countries") == null) {
        response.sendRedirect("/trip/uploadServlet");
    }
%>


<main>
    <form id="upload-form" class="form-horizontal" action="/trip/uploadServlet" method="post">
        <div class="form-group ">
            <label class="col-md-3 control-label">Title </label>
            <div class="col-md-7 ">
                <input type="text" class="form-control" name="title" id="title_input"
                       value="<c:out value="${requestScope.myLoad.getTitle()}"/>">
                <label class="remainder" id="title_hide">&nbsp;</label>
            </div>
        </div>

        <div class="form-group ">
            <label class="col-md-3 control-label">Theme </label>
            <div class="col-md-7 ">
                <input type="text" class="form-control" name="theme" id="theme_input"
                       value="<c:out value="${requestScope.myLoad.getTheme()}"/>">
                <label class="remainder" id="theme_hide">&nbsp;</label>
            </div>
        </div>

        <div class="form-group ">
            <label class="col-md-3 control-label">Location </label>
            <div class="col-md-7 row">
                <div class="col-md-6 row form-group">

                    <label class="control-label col-md-2">Country</label>

                    <div class="col-md-8">
                        <select class="form-control " name="country" id="country_input" onchange="getCities()">
                            <option disabled selected value>Chose Country</option>
                            <c:forEach items="${requestScope['countries']}" var="item">
                                <option value="<c:out value="${item.countryRegionName}"/>"
                                        <c:if test="${requestScope.myLoad.countryRegionCodeIso==item.iso}">
                                            <c:out value="selected"/>
                                        </c:if>>
                                    <c:out value="${item.countryRegionName}"/></option>
                            </c:forEach>
                        </select>
                    </div>


                </div>
                <div class="col-md-6 row form-group">


                    <label class="control-label col-md-2">City</label>

                    <div class="col-md-8">
                        <select class="form-control col-md-2" name="city" id="city_input">
                            <option disabled value>Chose City</option>
                            <c:forEach items="${requestScope['cities']}" var="item">
                                <option value="<c:out value="${item.asciiName}"/>"
                                        <c:if test="${requestScope.myLoad.cityCode==item.geoNameId}">
                                            <c:out value="selected"/>
                                        </c:if>>
                                    <c:out value="${item.asciiName}"/>
                                </option>
                            </c:forEach>
                        </select>
                    </div>

                </div>
                <label class="remainder" id="location_hide">&nbsp;</label>
            </div>
        </div>
        <div class="form-group ">
            <label class="col-md-3 control-label">Description </label>
            <div class="col-md-7 ">
                <input type="text" class="form-control" name="description" id="description_input"
                       value="<c:out value="${requestScope.myLoad.getDescription()}"/>">
                <label class="remainder" id="description_hide">&nbsp;</label>
            </div>
        </div>

        <div class="form-group ">
            <label class="col-md-3 control-label">Image </label>
            <div class="imageWrapper col-md-7 ">
                <div>
                    <button id="uploadButton" type="button" class="btnUpload"></button>
                    <input id="imagePic" name="imagePic" type="file"
                           accept=".bmp,.jpg,.png,.jpeg,image/bmp,image/jpg,image/png,image/jpeg" style="display:none"
                    >
                    <label class="remainder" id="img_hide">&nbsp;</label>
                </div>
                <div class="fontTip">
                    image format: bmp,jpg,png,jpeg
                </div>

                <div class="imageShow">
                    <img id="uploadImageShow"
                         src="<c:if test="${requestScope.myLoad!=null}"><c:out value="static/image/travel-images/medium/${requestScope.myLoad.getPath()}"/></c:if>"
                    />
                </div>
            </div>
        </div>

        <input type="button" class="btn btn-default col-md-offset-9" value="Submit" id="submit-btn"
               onclick="upload(<c:out value="${requestScope.myLoad.imageId}"/>)">
    </form>


</main>

<script src="static/js/upload.js"></script>
</body>

</html>
