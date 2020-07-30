<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link href="static/css/reset.css" rel="stylesheet">
    <link href="static/bootstrap-3.3.7-dist/css/bootstrap.min.css" rel="stylesheet">
    <link type="text/css" rel="stylesheet" href="static/css/chattingRoom.css">
    <script src="static/js/jquery-3.3.1.min.js"></script>
    <script src="static/bootstrap-3.3.7-dist/js/bootstrap.min.js"></script>
    <title>Chatting...</title>
</head>
<body>
<c:import url="nav.jsp"/>
<%
    if (request.getSession().getAttribute("username") == null) {
        response.sendRedirect("index.jsp");
    }
%>
<div id="main-box">
    <div class="row">
        <div class="col-md-12">
            <span style="font-size: 36px;">${requestScope.room.user1} and ${requestScope.room.user2}'s chatting room ... </span>
        </div>
    </div>
    <div class="row" id="message">
        <div class="col-md-12">
            <textarea id="history_messages" class="form-control"></textarea>
        </div>
    </div>
    <div class="row" style="width: 90% ; margin-left: 2%">
        <div class="col-md-11">
            <input type="text" id="message_send_input" class="form-control">
        </div>
        <div class="col-md-1">
            <button type="button" id="message_send_button" class="btn btn-default">send</button>
        </div>
    </div>
</div>
<script>
    var history_messages = $("#history_messages");

    function down() {
        history_messages.scrollTop = history_messages.scrollHeight;
    }


    $("#message_send_button").click(function () {
        sendMessage();
    });

    var request_interval = setInterval(getRoomMessage, 1000);

    $(document).keypress(function (event) {
        var keycode = (event.keyCode ? event.keyCode : event.which);
        console.log(keycode);
        if (keycode == '13') {
            sendMessage();
        }
    });

    function sendMessage() {
        $.ajax({
            url: '/trip/sendChattingMessageServlet',
            type: 'POST',
            dataType: 'json',
            data: {
                user1: '${requestScope.room.user1}',
                user2: '${requestScope.room.user2}',
                message: $("#message_send_input").val()
            },
            success: function (data) {
                console.log(data);
                $("#message_send_input").val("");
            },
            error: function (error) {
                console.log(error);
                alert(JSON.parse(error.responseText).message);
            }
        })
    }

    function getRoomMessage() {
        $.ajax({
            url: '/trip/getRoomMessageServlet',
            type: 'POST',
            dataType: 'text',
            data: {
                user1: '${requestScope.room.user1}',
                user2: '${requestScope.room.user2}',
            },
            success: function (data) {
                console.log(data);
                $("#history_messages").val(data);
                down();
            },
            error: function (error) {
                console.log(error);
                alert(JSON.parse(error.responseText).message);
                clearInterval(request_interval);
            }
        })
    }


</script>
</body>
</html>
