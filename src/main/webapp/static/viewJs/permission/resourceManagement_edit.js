$("#form-menu-add").validate({
    rules: {
        menuName: {
            required: true
        },
        url: {
            required: true
        },
        perms: {
            required: true
        },
        sort: {
            required: true,
        },
    },
    submitHandler: function (form) {
        edit();
    }
});

function openIocn() {
    var url = "/permissionOperation/icon";
    layer_show("选择图标", url, '400', '350');
}


function edit() {
    var id = $("input[name='id']").val();
    var parentId = $("input[name='parentId']").val();
    var menuType = $('input[name="menuType"]:checked').val();
    var menuName = $("input[name='menuName']").val();
    var url = $("input[name='url']").val();
    var perms = $("input[name='perms']").val();
    var sort = $("input[name='sort']").val();
    var icon = $("input[name='icon']").val();
    var visible = $("input[name='visible']").is(':checked') == true ? 0 : 1;

    $.ajax({
        url: baseUrl + "/permissionOperation/save",
        type: "POST",
        data: {
            "id": id,
            "pid": parentId,
            "menuType": menuType,
            "menuName": menuName,
            "url": url,
            "perms": perms,
            "sort": sort,
            "icon": icon,
            "visible": visible
        },
        async: false,
        error: function (request) {
            $.modalAlert("系统错误", "error");
        },
        success: function (data) {
            if (data.code == 0) {
                parent.layer.msg('更新成功', {icon: 1, time: 1000});
                $.modalClose();
                parent.loading();
            } else {
                $.modalAlert(data.msg, "error");
            }
        }
    });

}