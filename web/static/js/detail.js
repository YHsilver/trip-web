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


function sendComment(imageId) {
    var comment = $("#comment-input").val();
    if (comment != null && comment != "") {
        $.ajax({
            url: "/trip/addCommentServlet",
            type: "post",
            data: {
                imageId: imageId,
                comment: comment
            },
            dataType: "json",
            async: true,
            success: function (resp) {
                if (resp.message == "success") {
                    alert("send comment success");
                    $("#comments-box").load(location.href + " #comments-box");
                } else if (resp.message == "user_not_exist") {
                    alert("please  login in first");
                } else {
                    alert(resp.message)
                }
            }
        })
    } else {
        alert("please input something ")
    }

}

function agreeComment(cid) {
    $.ajax({
        url: "/trip/agreeCommentServlet",
        type: "post",
        data: {
            cid: cid
        },
        dataType: "json",
        async: true,
        success: function (resp) {
            if (resp.message == "success") {
                alert("agree comment success");
                $("#comments-box").load(location.href + " #comments-box");
            } else if (resp.message == "user_not_exist") {
                alert("please  login in first");
            } else {
                alert(resp.message)
            }
        }
    })
}

$(document).ready(function () {
    $('input[type=radio][name=order]').change(function () {
        $.ajax({
            url: "/trip/getCommentsServlet",
            type: "post",
            data: {
                iid: $("#orders").attr("iid"),
                order: this.value
            },
            dataType: "json",
            async: true,
            success: function (resp) {
                if (resp.message == "success") {
                    $("#comments-box").load(location.href + " #comments-box");
                } else {
                    alert(resp.message)
                }
            }
        })


    });
});