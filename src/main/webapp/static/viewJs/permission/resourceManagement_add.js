$("#form-menu-add").validate({
    rules: {
        menuName: {
            required: true
        },
        url:{
            required:true
        },
        perms:{
            required:true
        },
        sort:{
            required:true,
        },
    },
    submitHandler:function(form){
        add();
    }
});



function add() {
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
            "pid": parentId,
            "menuType": menuType,
            "menuName": menuName,
            "url": url,
            "perms": perms,
            "sort": sort,
            "icon": icon,
            "visible": visible
        },
        success: function (data) {
            
        }
    })

}