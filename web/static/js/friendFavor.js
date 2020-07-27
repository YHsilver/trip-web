var pageNums = ""; //total pages
var nowPage = 1;  //now page index
var pageSize = 3;

$.ajax({
        url: '/trip/getFriendsFavorServlet',
        data: {
            startIndex: (1 - 1) * pageSize,         //(PageIndex-1)*PageSize
        },
        type: 'post',
        dataType: 'json',
        success: function (rsp) {
            pageNums = Math.ceil((rsp.totalNum) / pageSize);//将返回的总页数值给全局变量
            msgReload();
            $("#friendsFavorList").load(location.href + " #friendsFavorList");
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
        url: '/trip/getFriendsFavorServlet',
        data: {
            startIndex: (num - 1) * pageSize,         //(PageIndex-1)*PageSize
        },
        type: 'post',
        dataType: 'json',
        success: function (rsp) {
            pageNums = Math.ceil((rsp.totalNum) / pageSize);//将返回的总页数值给全局变量
            msgReload();
            $("#friendsFavorList").load(location.href + " #friendsFavorList")
        }
    });
}