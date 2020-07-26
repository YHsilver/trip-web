var btnUploadText = 'Upload';

var type;

$(document).ready(function () {

    var imageId = getQueryVariable("imageId");

    if (imageId) {
        type = "old";
        $(".imageShow").show();
        btnUploadText = 'ReUpload';
        $("#submit-btn").val("Modify")
    }else {
        type = "new";
        $(".imageShow").hide();
        $("#submit-btn").val("Submit")
    }
    

    $("#uploadButton").text(btnUploadText);
    $('#uploadButton').click(function () {
        $('#imagePic').click();
    });

    $("#imagePic").on("change", function (e) {
        var file = e.target.files[0]; //获取图片资源
        var fileTypes = ["bmp", "jpg", "png", "jpeg"];
        var bTypeMatch = false;
        for (var i = 0; i < fileTypes.length; i++) {
            var start = file.name.lastIndexOf(".");
            var fileType = file.name.substring(start + 1);
            if (fileType.toLowerCase() == fileTypes[i]) {
                bTypeMatch = true;
                break;
            }
        }
        if (bTypeMatch) {
            var reader = new FileReader();
            reader.readAsDataURL(file); // 读取文件
            // 渲染文件
            reader.onload = function (arg) {
                $(".imageShow").show()
                $("#uploadImageShow").attr("src", arg.target.result)
                btnUploadText = 'ReUpload';
                $("#uploadButton").text(btnUploadText)
            }
        } else {
            alert('only .bmp, .jpg, .png, .jpeg image format support');
            emptyImageUpload("#imagePic");
            $("#uploadImageShow").attr("src", "");
            $(".imageShow").hide();
            btnUploadText = 'Upload';
            $("#uploadButton").text(btnUploadText);
            return false;
        }
    });
});

//清空上传图片信息
function emptyImageUpload(selector) {
    var fi;
    var sourceParent;
    if (selector) {
        fi = $(selector);
        sourceParent = fi.parent();
    } else {
        return;
    }
    $("<form id='tempImgForm'></form>").appendTo(document.body);
    var tempImgForm = $("#tempImgForm");
    tempImgForm.append(fi);
    tempImgForm.get(0).reset();
    sourceParent.append(fi);
    tempImgForm.remove();
}

//handle submit



    function upload(imageId) {
        var title = $("#title_input").val();
        var theme = $("#theme_input").val();
        var country = $("#country_input").val();
        var city = $("#city_input").val();
        var description = $("#description_input").val();
        var file = $('#imagePic').get(0).files[0];


        if (title == "") {
            $("#title_hide").html("Please input theme");
            return false;
        } else {
            $("#title_hide").html("&nbsp;");
        }

        if (theme == "") {
            $("#theme_hide").html("Please input theme");
            return false;
        } else {
            $("#theme_hide").html("&nbsp;");
        }

        if (country == null) {
            $("#location_hide").html("Please input country");
            return false;
        } else {
            console.log($("#country_input").val());
            $("#location_hide").html("&nbsp;");
        }
        if (city == null) {
            $("#location_hide").html("Please input city");
            return false;
        } else {
            $("#location_hide").html("&nbsp;");
        }
        if (description == "") {
            $("#description_hide").html("Please input description");
            return false;
        } else {
            $("#description_hide").html("&nbsp;");
        }


        var url;
        var formData = new FormData();
        if (type=="new"){
            if (!file) {
                $("#img_hide").html("Please input img");
                return false;
            } else {
                $("#img_hide").html("&nbsp;");
            }

            url="/trip/uploadServlet";
        } else if (type=="old") {

            formData.append("imageId", imageId);

            url="/trip/modifyPictureServlet"
        }

        formData.append("title", title);
        formData.append("theme", theme);
        formData.append("country", country);
        formData.append("city", city);
        formData.append("description", description);
        formData.append("file", file);


        $.ajax({
            type: "POST",
            url: url ,

            data: formData,
            async: true,
            dataType: "json",
            processData: false,
            contentType: false,

            success: function (result) {
                if (result.message == "user_not_exist") {
                    alert("Please login first")
                } else if (result.message == "success") {
                    alert("Upload Success");
                } else {
                    alert(result.message);
                }
            }
        })
    }

function getCities() {
    var option = $("#country_input option:selected").val();

    $.ajax({
        type: "POST",
        url: "/trip/getCitiesServlet",

        data: {
            country: option
        },
        async: true,
        dataType: "json",
        success: function (resp) {
            var cities = resp.cities;

            var obj = $("#city_input");
            obj.empty();

            obj.append("<option disabled selected value>Chose City</option>");
            for (var k in cities) {
                obj.append("<option value='" + cities[k] + "'>" + cities[k] + "</option>"); //为Select追加一个Option(下拉项)
            }
        }
    })
}


function getQueryVariable(variable) {
    var query = window.location.search.substring(1);
    var vars = query.split("&");
    for (var i = 0; i < vars.length; i++) {
        var pair = vars[i].split("=");
        if (pair[0] == variable) {
            return pair[1];
        }
    }
    return (false);
}












