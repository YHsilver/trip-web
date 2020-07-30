$('[name="authority"]').bootstrapSwitch({
    onText: "ON",
    offText: "OFF",
    onColor: "success",
    offColor: "danger",
    size: "small",
    onSwitchChange: function (event, state) {
        if (state == true) {
            changeState(1);
        } else {
            changeState(0);
        }
    }
});


function changeState(state) {
    $.ajax({
        url: "/trip/changeUserStateServlet",

        type: 'post',
        data: {
            state: state
        },
        dataType: 'json',
        success: function (resp) {
            if (resp.message == "success") {
            } else {
                alert(resp.message)
            }

        }

    })


}


function searchUser() {
    var username = $("#search-text").val();

    $.ajax({
        url: "/trip/getFriendsServlet",

        type: 'post',
        data: {
            username: username
        },
        dataType: 'json',

        success: function (resp) {
            if (resp.message == "success") {
                $("#search-result").load(location.href + " #search-result");
            } else {
                alert(resp.message)
            }

        }

    })


}

function addFriend(uid) {
    $.ajax({
        url: "/trip/addFriendServlet",

        type: 'post',
        data: {
            uid: uid
        },
        dataType: 'json',

        success: function (resp) {
            if (resp.message == "success") {
                alert("send invitation success");
            } else {
                alert(resp.message)
            }
        }
    })
}

function handleInvitation(type, iid) {
    $.ajax({
        url: "/trip/handleInvitationServlet",

        type: 'post',
        data: {
            type: type,
            iid: iid
        },
        dataType: 'json',

        success: function (resp) {
            if (resp.message == "success") {
                alert("operation success");
                $("#myInvitation").load(location.href + " #myInvitation");
                $("#friendsList").load(location.href + " #friendsList");
            } else {
                alert(resp.message)
            }
        }
    })

}

$(function() {
    $.ajax({
        url: "/trip/getFriendsServlet",
        type: 'get',
        dataType: 'json',
        success: function (resp) {
            if (resp.message == "success") {
                $("#friendsList").load(location.href + " #friendsList");
            } else {
                alert(resp.message)
            }
        }
    })
});