
//initialize page bar
var pageNums = ""; //total pages
var nowPage = 1;  //now page index
var pageSize = 6;

//重置分页插件
function msgReload() {
    console.log(pageNums);

    new Paging("page",{
        nowPage: nowPage, // 当前页码
        pageNum: pageNums, // 总页码
        buttonNum: 7, //要展示的页码数量
        canJump: 0,
        showOne:1,
        callback: function (num) { //回调函数
            //num是你点击分页插件的数字。
            console.log(num);
            getlist(num);
        }
    });
}


$.ajax({
        url: '/trip/searchServlet',
        data: {
            searchTxt: "",
            startIndex: (1 - 1) * pageSize,         //(PageIndex-1)*PageSize
            field: "title",
            order: "hot"
        },
        type: 'post',
        dataType: 'json',
        success: function (rsp) {

            pageNums = Math.ceil((rsp.totalNum) / pageSize);//将返回的总页数值给全局变量
            msgReload();
            $(".result").load(location.href + " .result")
        }
    }
);


//获取数据
function getlist(num) {
    nowPage = num;
    $.ajax({
        url: '/trip/searchServlet',
        data: {
            searchTxt: $("#searchTxt").val(),
            startIndex: (num - 1) * pageSize,         //(PageIndex-1)*PageSize
            field: $("input[name='field']:checked").val(),
            order: $("input[name='order']:checked").val()
        },
        type: 'post',
        dataType: 'json',
        success: function (rsp) {
            pageNums = Math.ceil((rsp.totalNum) / pageSize);//将返回的总页数值给全局变量
            msgReload();
            console.log("one load")
            $(".result").load(location.href + " .result")
        }
    });
}


function search() {
   getlist(1)
}

