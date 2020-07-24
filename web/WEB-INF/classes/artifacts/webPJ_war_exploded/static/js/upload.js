var btnUploadText = 'Upload';
$(document).ready(function () {
    $("#uploadButton").text(btnUploadText);
    $(".imageShow").hide();
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
                btnUploadText = 'ReUpload'
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
$("#submit-btn").click(
    function () {
        var title=$("#title_input").val();
        var theme=$("#theme_input").val();
        var country=$("#country_input").val();
        var city=$("#city_input").val();
        var description=$("#description_input").val();
        var file=$('#imagePic').get(0).files[0];



        if (title == "") {
            $("#title_hide").html("Please input theme");
            return false;
        } else {
            $("#title_hide").html("&nbsp;");
        }

        if ( theme == "") {
            $("#theme_hide").html("Please input theme");
            return false;
        } else {
            $("#theme_hide").html("&nbsp;");
        }

        if ( country== null) {
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
        if ( description== "") {
            $("#description_hide").html("Please input description");
            return false;
        } else {
            $("#description_hide").html("&nbsp;");
        }


        if (!file) {
            $("#img_hide").html("Please input img");
            return false;
        } else {
            $("#img_hide").html("&nbsp;");
        }



        var formData=new FormData();
        formData.append("title",title);
        formData.append("theme",theme);
        formData.append("country",country);
        formData.append("city",city);
        formData.append("description",description);
        formData.append("file",file);



        $.ajax({
            type: "POST",
            url: "/trip/uploadServlet",

            data:formData,
            async : true,
            dataType: "json",
            processData: false,
            contentType:false,

            success: function(result){
                if (result.message=="user_not_exist"){
                    alert("Please login first")
                } else if (result.message=="success") {
                    alert("Upload Success");
                }else {
                    alert(result.message);
                }
            }
    })






    }
);


















