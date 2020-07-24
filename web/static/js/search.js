var Paging = /** @class */ (function () {
    function Paging(elementName, options) {
        this.elementName = elementName;
        this.options = options;
        options.nowPage = options.nowPage >= 1 ? options.nowPage : 1;
        options.pageNum = options.pageNum > 0 ? options.pageNum : 0;
        options.canJump = options.canJump || 0;
        options.showOne = options.showOne || 0;
        options.buttonNum = (options.buttonNum >= 5 ? options.buttonNum : 5) || 7;
        this.nowPage = options.nowPage > options.pageNum ? options.pageNum : options.nowPage;
        this.pageNum = options.pageNum < 0 ? 0 : options.pageNum;
        this.canJump = options.canJump;
        this.showOne = options.showOne;
        this.buttonNum = options.buttonNum;
        this.callback = options.callback;
        this.element = document.getElementById(elementName);
        this.init();
    }

    Paging.prototype.init = function () {
        this.createHtml();
    };
    Paging.prototype.createHtml = function () {
        var _this = this;
        var content = [];
        //如果pageNum小于等于0则不渲染
        if (this.pageNum <= 0) {
            return '';
        }
        //如果只有一页并且设置为不显示，则不进行渲染
        if (!this.showOne && this.pageNum === 1) {
            this.element.innerHTML = '';
            return '';
        }
        content.push("<ul>");
        content.push("<li class='xl-prevPage'>Pre</li>");
        //页面总数小于等于当前要展示页数总数，展示所有页面
        if (this.pageNum <= this.buttonNum) {
            for (var i = 1; i <= this.pageNum; i++) {
                if (this.nowPage !== i) {
                    content.push("<li>" + i + "</li>");
                } else {
                    content.push("<li class='xl-active'>" + i + "</li>");
                }
            }
        } else if (this.nowPage <= Math.floor(this.buttonNum / 2)) {
            //当前页面小于等于展示页数总数的一半（向下取整），从1开始
            for (var i = 1; i <= this.buttonNum - 2; i++) {
                if (this.nowPage !== i) {
                    content.push("<li>" + i + "</li>");
                } else {
                    content.push("<li class='xl-active'>" + i + "</li>");
                }
            }
            content.push("<li class='xl-disabled'>...</li>");
            content.push("<li>" + this.pageNum + "</li>");
        } else if (this.pageNum - this.nowPage <= Math.floor(this.buttonNum / 2)) {
            //当前页面大于展示页数总数的一半（向下取整）
            content.push("<li>" + 1 + "</li>");
            content.push("<li class='xl-disabled'>...</li>");
            for (var i = this.pageNum - this.buttonNum + 3; i <= this.pageNum; i++) {
                if (this.nowPage !== i) {
                    content.push("<li>" + i + "</li>");
                } else {
                    content.push("<li class='xl-active'>" + i + "</li>");
                }
            }
        } else {
            //前半部分页码
            if (this.nowPage - Math.floor(this.buttonNum / 2) <= 0) {
                for (var i = 1; i <= Math.floor(this.buttonNum / 2); i++) {
                    if (this.nowPage !== i) {
                        content.push("<li>" + i + "</li>");
                    } else {
                        content.push("<li class='xl-active'>" + i + "</li>");
                    }
                }
            } else {
                content.push("<li>" + 1 + "</li>");
                content.push("<li class='xl-disabled'>...</li>");
                for (var i = this.nowPage - Math.floor(this.buttonNum / 2) + (this.buttonNum % 2 == 0 ? 3 : 2); i <= this.nowPage; i++) {
                    if (this.nowPage !== i) {
                        content.push("<li>" + i + "</li>");
                    } else {
                        content.push("<li class='xl-active'>" + i + "</li>");
                    }
                }
            }
            //后半部分页码
            if (this.pageNum - this.nowPage <= 0) {
                for (var i = this.nowPage + 1; i <= this.pageNum; i++) {
                    content.push("<li>" + i + "</li>");
                }
            } else {
                for (var i = this.nowPage + 1; i <= this.nowPage + Math.floor(this.buttonNum / 2) - 2; i++) {
                    content.push("<li>" + i + "</li>");
                }
                content.push("<li class='xl-disabled'>...</li>");
                content.push("<li>" + this.pageNum + "</li>");
            }
        }
        content.push("<li class='xl-nextPage'>Next</li>");
        if (this.canJump) {
            content.push("<li class='xl-jumpText xl-disabled'>Jump to<input type='number' id='xlJumpNum'>Page</li>");
            content.push("<li class='xl-jumpButton'>Go-></li>");
        }
        content.push("</ul>");
        this.element.innerHTML = content.join('');
        // DOM重新生成后每次调用是否禁用button
        setTimeout(function () {
            _this.disabled();
            _this.bindClickEvent();
        }, 20);
    };
    Paging.prototype.bindClickEvent = function () {
        var _this = this;
        var liList = this.element.children[0].children;
        var _loop_1 = function (i) {
            liList[i].removeEventListener('click', function () {
                _this.clickEvent(liList[i]);
            });
        };
        for (var i = 0; i < liList.length; i++) {
            _loop_1(i);
        }
        var _loop_2 = function (i) {
            liList[i].addEventListener('click', function () {
                _this.clickEvent(liList[i]);
            });
        };
        for (var i = 0; i < liList.length; i++) {
            _loop_2(i);
        }
    };
    Paging.prototype.clickEvent = function (li) {
        var cla = li.className;
        var num = parseInt(li.innerHTML);
        var nowPage = this.nowPage;
        if (li.className.indexOf('xl-disabled') !== -1 || cla === 'xl-jumpText') {
            return '';
        }
        if (cla === 'xl-prevPage') {
            if (nowPage >= 1) {
                this.nowPage -= 1;
            }
        } else if (cla === 'xl-nextPage') {
            if (nowPage < this.pageNum) {
                this.nowPage += 1;
            }
        } else if (cla === 'xl-jumpButton') {
            var el = document.getElementById('xlJumpNum');
            if (Number(el.value) > this.pageNum) {
                this.nowPage = this.pageNum;
            } else if (Number(el.value) <= 0) {
                this.nowPage = 1;
            } else {
                this.nowPage = Number(el.value);
            }
        } else {
            this.nowPage = num;
        }
        this.createHtml();
        if (this.callback) {
            this.callback(this.nowPage);
        }
    };
    Paging.prototype.disabled = function () {
        var nowPage = this.nowPage;
        var pageNum = this.pageNum;
        var liList = this.element.children[0].children;
        if (nowPage === 1) {
            for (var i = 0; i < liList.length; i++) {
                if (liList[i].className.indexOf('xl-prevPage') !== -1) {
                    liList[i].setAttribute('class', liList[i].getAttribute('class').concat(' xl-disabled'));
                }
            }
        } else if (nowPage === pageNum) {
            for (var i = 0; i < liList.length; i++) {
                if (liList[i].className.indexOf('xl-nextPage') !== -1) {
                    liList[i].setAttribute('class', liList[i].getAttribute('class').concat(' xl-disabled'));
                }
            }
        }
    };
    return Paging;
}());


var pageNums = ""; //total pages
var nowPage = 1;  //now page index
var pageSize = 6;

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

