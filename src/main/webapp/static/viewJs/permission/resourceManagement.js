var prefix = "/permissionOperation";

window.onload = function () {
    loading();
}

function loading() {
    var columns = [
        {
            title: "菜单编号",
            field: "id",
            visible: false,
            align: 'center',
            valign: 'middle',
            width: '10%'
        },
        {
            title: "菜单名称",
            field: "menuName"
        },
        {
            title: "请求地址",
            field: "url"
        },
        {
            title: "图表",
            field: "icon"
        },
        {
            title: "排序",
            field: "sort"
        },
        {
            title: '类型',
            field: 'menuType',
            align: 'center',
            valign: 'middle',
            formatter: function (item, index) {
                if (item.menuType == 'M') {
                    return '<span class="label label-primary">目录</span>';
                }
                if (item.menuType == 'C') {
                    return '<span class="label label-success">菜单</span>';
                }
                if (item.menuType == 'F') {
                    return '<span class="label label-warning">按钮</span>';
                }
            }
        },
        {
            title: '操作',
            align: 'center',
            formatter: function (row, index) {
                var actions = [];
                actions.push('<a class="btn btn-primary btn-sm" href="#" title="编辑" mce_href="#" onclick="edit(\'' + row.id + '\')"><i class="fa fa-edit"></i></a>');
                actions.push('<a class="btn btn-primary btn-sm" href="#" title="新增" mce_href="#" onclick="add(\'' + row.id + '\')"><i class="fa fa-plus"></i></a>');
                actions.push('<a class="btn btn-warning btn-sm" href="#" title="删除" mce_href="#" onclick="remove(\'' + row.id + '\')"><i class="fa fa-remove"></i></a>');
                return actions.join('');
            }
        }];

    var url = prefix + "/getAllResource";
    $.initTreeTable("id", "pid", columns, url, false);
}