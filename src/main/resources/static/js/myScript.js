

function Tag(name) {
    this.name = name;
}
function Type(name){
    this.name = name;
}

$("#info").click(function (event) {
    event.preventDefault();
    $.getJSON("/api/userInfo", function (data) {
        $("#userName").append(data.userName);
        $("#userNickname").append(data.nickName);
    })

    $('#commentsContent').css('display', 'none');
    $("#infoContent").css('display', 'inline');
    $("#blogsContent").css('display', "none");
    $("#messagesContent").css("display", "none");
});

$("#blogs").click(function (event) {
    event.preventDefault();
    $('#commentsContent').css('display', 'none');
    $("#infoContent").css('display', 'none');
    $("#blogsContent").css('display', "inline");
    $("#messagesContent").css("display", "none");
});

$("#messages").click(function (event) {
    event.preventDefault();
    $('#commentsContent').css('display', 'none');
    $("#infoContent").css('display', 'none');
    $("#blogsContent").css('display', "none");
    $("#messagesContent").css("display", "inline");
});

$("#comments").click(function (event) {
    event.preventDefault();
    $('#commentsContent').css('display', 'inline');
    $("#infoContent").css('display', 'none');
    $("#blogsContent").css('display', "none");
    $("#messagesContent").css("display", "none");
});

/*弹出新建框*/
$("#addTags").click(function (event) {
    event.preventDefault();
    $("#addTagsForm").css("display", "block");
});
/*提交新建*/
$("#tagSubmit").click(function (event) {
    event.preventDefault();
    $("#addTagsForm").css("display", "none");
    const name = $("#newTag").val();
    const tag = new Tag(name)
    $.ajax({
        type: "POST",
        contentType: "application/json",
        url: "http://localhost:8080/api/tag/add",
        data: JSON.stringify(tag),
        success: function (result) {
            const Data = $.parseJSON(result);
            const message = Data.message;
            if(message == "OK"){
                $("#tagsList").append("<div class=\"item\"><a href=\"\"><i class=\"idea icon\"></i>" + tag.name + "</a></div>")
            }
        },
        error: function (e) {
            console.log(e.status);
            console.log(e.responseText);
        }
    })
});

/*关闭新建框*/
$("#tagOff").click(function () {
    $("#addTagsForm").css("display", "none");
});

/*弹出新建框*/
$("#addTypes").click(function (event) {
    event.preventDefault();
    $("#addTypesForm").css("display", "block");
});

$("#typeSubmit").click(function (event) {
    event.preventDefault();
    $("#addTypesForm").css("display", "none");
    const name = $("#newType").val();
    const _type = new Type(name);

    $.ajax({
        type: "POST",
        contentType: "application/json",
        url: "http://localhost:8080/api/type/add",
        data: JSON.stringify(_type),
        success:function (result) {
            const Data = $.parseJSON(result);
            const message = Data.message;
            if(message === "OK"){
                $("#typesList").append("<div class=\"item\"><a href=\"\"><i class=\"idea icon\"></i>" + _type.name + "</a></div>")
            }
        },
        error: function (e) {
            console.log(e.status);
            console.log(e.responseText);
        }
    })

})

/*关闭新建框*/
$("#typeOff").click(function () {
    $("#addTypesForm").css("display", "none");
});





/*页面加载时，通过api获取数据填充*/
$(function () {
    $.getJSON("http://localhost:8080/api/tag/getAll", function (result) {
        // console.log(result);
        $.each(result, function (i, field) {
            $("#tagsList").append("<div class=\"item\"><a href=\"\"><i class=\"idea icon\"></i>" + field.name + "</a></div>")
        })
    });
    $.getJSON("http://localhost:8080/api/type/getAll",function (result) {
        $.each(result, function (i, _type) {
            $("#typesList").append("<div class=\"item\"><a href=\"\"><i class=\"idea icon\"></i>" + _type.name + "</a></div>")
        })

    })
})