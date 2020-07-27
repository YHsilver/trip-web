
var pageNums = ""; //total pages
var nowPage = 1;  //now page index
var pageSize = 3;


$.ajax({

        url: '/trip/getMyFavorServlet',
        data: {
            startIndex: (1 - 1) * pageSize,         //(PageIndex-1)*PageSize
        },
        type: 'post',
        dataType: 'json',
        success: function (rsp) {
            pageNums = Math.ceil((rsp.totalNum) / pageSize);//将返回的总页数值给全局变量
            $("#favorList").load(location.href + " #favorList");
            $("#history-pane").load(location.href + " #history-pane");
            msgReload();

        }
    }
);


//重置分页插件
function msgReload() {

    new Paging("page", {
        nowPage: nowPage, // 当前页码
        pageNum: pageNums, // 总页码
        buttonNum: 7, //要展示的页码数量
        canJump: 0,
        showOne: 1,
        callback: function (num) { //回调函数
            //num是你点击分页插件的数字。
            console.log(num);
            getlist(num);
        }
    });
}

//获取数据
function getlist(num) {
    nowPage = num;
    $.ajax({
        url: '/trip/getMyFavorServlet',
        data: {
            startIndex: (num - 1) * pageSize,         //(PageIndex-1)*PageSize
        },
        type: 'post',
        dataType: 'json',
        success: function (rsp) {
            pageNums = Math.ceil((rsp.totalNum) / pageSize);//将返回的总页数值给全局变量
            msgReload();
            $("#favorList").load(location.href + " #favorList")
        }
    });
}


//处理删除
function deleteFavor(id) {
    $.ajax({
        url: "/trip/deleteFavorServlet",
        data: {
            imageId: id
        },
        type: "post",
        dataType: "json",
        success: function (rsp) {
            if (rsp.message == "success") {
                alert("delete success");
                window.location.reload();
            } else if (rsp.message == "not_exist") {

                alert("delete failed! please try again later ")
            } else {
                alert(rsp.message);
            }
        }

    })


}


