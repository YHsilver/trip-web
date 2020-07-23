
//存放各个input的obj
var ele = {
    name: document.getElementById("username_input"),
    password: document.getElementById("password_input"),
    confirmPass: document.getElementById("confirmPass_input"),
    email: document.getElementById("email_input"),
    code: document.getElementById("code_input")
};

ele.name.onblur = function () {
    checkName(ele.name.value);
};
ele.password.onblur = function () {
    checkPassword(ele.password.value, ele.confirmPass.value);
};
ele.confirmPass.onblur = function () {
    checkRepassword(ele.password.value, ele.confirmPass.value);

};
ele.email.onblur = function () {
    checkEmail(ele.email.value);
};


function checkName(name) {
    if (name === "") {
        document.getElementById("username_hide").innerHTML = "please input username！"
    } else if (name.length < 4 || name.length > 15) {
        document.getElementById("username_hide").innerHTML = "username length is between[4-15]"
    } else {
        document.getElementById("username_hide").innerHTML = "&nbsp;";
        return true;
    }
}


function checkPassword(password, repassword) {
    if (password == "") {
        document.getElementById("password_hide").innerHTML = "please input password";
    } else if (password.length < 6 || password.length > 12) {
        document.getElementById("password_hide").innerHTML = "password length is between[6-12]";
    } else if (repassword != "" && repassword != password) {
        document.getElementById("conPass_hide").innerHTML = "two password not accordance";
    } else {
        document.getElementById("password_hide").innerHTML = "&nbsp;";
        return true;
    }
}

function checkRepassword(password, repassword) {

    if (repassword == "") {
        document.getElementById("conPass_hide").innerHTML = "please confirm password";
    } else if (repassword != password) {
        document.getElementById("conPass_hide").innerHTML = "two password not accordance";
    } else {
        document.getElementById("conPass_hide").innerHTML = "&nbsp;";
        return true;

    }
}

function checkEmail(email) {
    var myReg = /^[a-zA-Z0-9_-]+@([a-zA-Z0-9]+\.)+(com|cn|net|org)$/;
    if (myReg.test(email)) {
        document.getElementById("email_hide").innerHTML = "&nbsp;";
        return true;
    } else {
        document.getElementById("email_hide").innerHTML = "email format not correct";
        return false;
    }
}

function checkCode(code) {
    if (code == "") {
        $("#code_hide").html("lease input confirm code");
        return false;
    } else if (code != options.txt) {
        $("#code_hide").html("confirm code wrong");
        return false;
    } else {
        $("#code_hide").html("&nbsp;");
        return true;
    }

}

function check() {
    var nameok = false;
    var passwordok = false;
    var repasswordok = false;
    var emailok = false;
    var codeok = false;

    if (checkName(ele.name.value)) {
        nameok = true;
    } else {
        checkName(ele.name.value);
    }

    if (checkPassword(ele.password.value, ele.confirmPass.value)) {
        passwordok = true;
    }
    if (checkRepassword(ele.password.value, ele.confirmPass.value)) {
        repasswordok = true;
    }
    if (checkEmail(ele.email.value)) {
        emailok = true;
    }

    if (checkCode(ele.code.value)) {
        codeok = true;
    }

    if (nameok && passwordok && repasswordok && emailok && codeok) {
        var request = new XMLHttpRequest();

        console.log(request);
        request.open("POST", "/web/registerServlet", true);

        request.setRequestHeader("Content-type", "application/x-www-form-urlencoded");
        request.onreadystatechange = function () {
            if ((this.status >= 200 && this.status <= 300 || this.status == 304) && this.readyState == 4) {
                var resp = JSON.parse(this.response);
                console.log(resp);
                if (resp.message == "user_existed") {
                    document.getElementById("username_hide").innerHTML = "username already exist";
                } else if (resp.message == "success") {
                    alert("register success");
                    window.location.href="/web/indexPageServlet"
                } else {
                    alert(resp.message);
                }
            }
        };


        var encodepass=$.base64.encode(ele.password.value);

        request.send("username="+ele.name.value+"&password="+encodepass+"&email="+ele.email.value);
    } else {

        checkName(ele.name.value);
        checkPassword(ele.password.value, ele.confirmPass.value, ele.name.value);
        checkRepassword(ele.password.value, ele.confirmPass.value);
        checkEmail(ele.email.value);
        checkCode(ele.code.value);
        return false;
    }

}


$(function () {
    $('#password_input').keyup(function () {
        var strongRegex = new RegExp("(?=.*[0-9])(?=.*[a-zA-Z])(?=.*[^a-zA-Z0-9]).{8,16}");
        var mediumRegex = new RegExp("^(?=.{7,})(((?=.*[A-Z])(?=.*[a-z]))|((?=.*[A-Z])(?=.*[0-9]))|((?=.*[a-z])(?=.*[0-9]))).*$", "g");
        var enoughRegex = new RegExp("(?=.{6,}).*", "g");

        if (false == enoughRegex.test($(this).val())) {
            $('#level').removeClass('pw-weak');
            $('#level').removeClass('pw-medium');
            $('#level').removeClass('pw-strong');
            $('#level').addClass(' pw-defule');
            //密码小于六位的时候，密码强度图片都为灰色
        } else if (strongRegex.test($(this).val())) {
            $('#level').removeClass('pw-weak');
            $('#level').removeClass('pw-medium');
            $('#level').removeClass('pw-strong');
            $('#level').addClass(' pw-strong');
            //密码为八位及以上并且字母数字特殊字符三项都包括,强度最强
        } else if (mediumRegex.test($(this).val())) {
            $('#level').removeClass('pw-weak');
            $('#level').removeClass('pw-medium');
            $('#level').removeClass('pw-strong');
            $('#level').addClass(' pw-medium');
            //密码为七位及以上并且字母、数字、特殊字符三项中有两项，强度是中等
        } else {
            $('#level').removeClass('pw-weak');
            $('#level').removeClass('pw-medium');
            $('#level').removeClass('pw-strong');
            $('#level').addClass('pw-weak');
            //如果密码为6为及以下，就算字母、数字、特殊字符三项都包括，强度也是弱的
        }
        return true;
    });
});


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
    options.txt = generateCode();
    writeAuthCode(options);
}


writeAuthCode(options);


