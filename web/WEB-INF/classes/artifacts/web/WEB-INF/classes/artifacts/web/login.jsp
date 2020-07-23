<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <link href="static/css/reset.css" rel="stylesheet">
    <link href="static/css/login.css" rel="stylesheet">
    <link href="static/bootstrap-3.3.7-dist/css/bootstrap.min.css" rel="stylesheet">
    <script src="static/js/jquery-3.3.1.min.js"></script>
    <script src="static/bootstrap-3.3.7-dist/js/bootstrap.min.js"></script>
    <title>Login</title>
</head>
<body>
<c:import url="nav.jsp"/>
<div>
    <div class="container" style=" margin-left: 0; margin-right: 0;padding: 0; width: 95%;">
        <div class="row">
            <div class="col-lg-5">
                <img src="static/image/web-images/login-left.jpg" alt="img" class="img-responsive">
            </div>

            <div class="col-lg-7">
                <form action="<%=application.getContextPath()%>/loginServlet" method="post"
                      class="form-horizontal" role="form" id="loginForm">
                    <div class="form-group ">

                        <label class="col-md-3 control-label">Username </label>
                        <div class="col-md-7 ">
                            <input type="text" class="form-control" name="username" id="username_input" required>
                            <label class="remainder" id="username_hide">&nbsp;</label>
                        </div>
                    </div>

                    <br>

                    <div class="form-group">
                        <label class="col-md-3 control-label">Password </label>
                        <div class="col-md-7">
                            <input type="password" class="form-control" name="password" id="password_input" required>
                            <label class="remainder" id="password_hide">&nbsp;</label>
                        </div>
                    </div>

                    <br>

                    <div class="form-group">

                        <label class="col-md-3 control-label">Confirm Code </label>
                        <div class="col-md-7 row">
                            <div class="col-md-6">

                                <input type="text" name="code" class="form-control" id="code_input" required>
                            </div>
                            <div class="col-md-6">
                                <canvas id='code_picture'></canvas>
                                <a  onclick="refresh()">change</a>
                            </div>

                            <label class="remainder" id="code_hide">&nbsp;</label>
                        </div>
                    </div>

                    <br>
                    <div class="form-group">
                        <input type="button" class="btn btn-default col-md-offset-9 " value="Submit" onclick="login()">
                    </div>
                </form>
            </div>
        </div>
    </div>
</div>

<script src="static/js/login.js"></script>
</body>
</html>
