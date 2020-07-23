
//验证码对象
var options = {
    canvasId: "code_picture", //canvas的id
    txt: generateCode(), //传入验证码内容
    height: 30, //验证码高度
    width: 100//验证码宽度
};


//canvas绘制验证码
function writeAuthCode(options) {
    var canvas = document.getElementById(options.canvasId);
    canvas.width = options.width;
    canvas.height = options.height;
    var ctx = canvas.getContext('2d'); //创建一个canvas对象
    ctx.textBaseline = "middle";
    ctx.fillStyle = randomColor(180, 255);//生成随机颜色
    ctx.fillRect(0, 0, options.width, options.height);


    //使每个字的颜色、位置不一样
    for (var i = 0; i < options.txt.length; i++) {
        var txt = options.txt.charAt(i);
        ctx.font = '30px SimHei';
        ctx.fillStyle = randomColor(50, 160);
        ctx.shadowOffsetY = randomNum(-3, 3);
        ctx.shadowBlur = randomNum(-3, 3);
        ctx.shadowColor = "rgba(0, 0, 0, 0.3)";
        var x = options.width / (options.txt.length + 1) * (i + 1);
        var y = options.height / 2;
        var deg = randomNum(-30, 30);
        ctx.translate(x, y);
        ctx.rotate(deg * Math.PI / 180);
        ctx.fillText(txt, 0, 0);
        ctx.rotate(-deg * Math.PI / 180);
        ctx.translate(-x, -y);
    }
    //绘制干扰线条
    for (var i = 0; i < randomNum(1, 4); i++) {
        ctx.strokeStyle = randomColor(40, 180);
        ctx.beginPath();
        ctx.moveTo(randomNum(0, options.width), randomNum(0, options.height));
        ctx.lineTo(randomNum(0, options.width), randomNum(0, options.height));
        ctx.stroke();
    }
    //绘制干扰点
    for (var i = 0; i < options.width / 6; i++) {
        ctx.fillStyle = randomColor(0, 255);
        ctx.beginPath();
        ctx.arc(randomNum(0, options.width), randomNum(0, options.height), 1, 0, 2 * Math.PI);
        ctx.fill();
    }
}

//生成随机数字
function randomNum(min, max) {
    return Math.floor(Math.random() * (max - min) + min);
}

//生成随机颜色
function randomColor(min, max) {
    var r = randomNum(min, max);
    var g = randomNum(min, max);
    var b = randomNum(min, max);
    return "rgb(" + r + "," + g + "," + b + ")";
}

//产生四位数字验证码
function generateCode() {
    var length = 4;
    var code = "";

    for (var i = 0; i < length; i++) {
        code += Math.floor(Math.random() * 10)
    }
    return code;
}

function refresh() {
    options.txt=generateCode();
    writeAuthCode(options);
}


writeAuthCode(options);



function login() {
    if ($("#username_input").val()==""){
        $("#username_hide").html("lease input username");
        return false;
    } else {
        $("#username_hide").html("&nbsp;");
    }

    if ($("#password_input").val()==""){
        $("#password_hide").html("lease input password");
        return false;
    } else {
        $("#password_hide").html("&nbsp;");
    }

    if ($("#code_input").val()==""){
        $("#code_hide").html("lease input confirm code");
        return false;
    }else if ($("#code_input").val()!=options.txt){
        $("#code_hide").html("confirm code wrong");
        return false;
    } else {
        $("#code_hide").html("&nbsp;");
    }

    $.ajax({
        type: "POST",
        url: "/web/loginServlet",
        data: $('#loginForm').serialize(),
        async : true,
        dataType: "json",
        success: function(result){
            if (result.message=="user_not_exist"){
                alert("username or password not correct")
            } else if (result.message=="success") {
                alert("success");
                window.location.href="index.jsp";
            }else {
                alert(result.message);
            }
        }
    });

}