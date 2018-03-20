layui.use(['form', 'layer','element', 'laydate', 'table', 'laytpl'], function () {
    var form = layui.form,
        element = layui.element,
        layer = parent.layer === undefined ? layui.layer : top.layer,
        $ = layui.jquery,
        laydate = layui.laydate,
        laytpl = layui.laytpl,
        table = layui.table;

    //资源列表
    var tableIns = table.render({
        elem: "#resourceList",
        url: baseUrl + "/permissionOperation/getAllResource",
        cellMinWidth : 95,
        page : false,
        height : "full-125",
        id : "resourceList",
        cols : [[
            {type: "checkbox", fixed:"left", width:50},
            {field: 'id', title: 'ID', width:60, align:"center"},
            {field: 'menuName', title: '菜单名称', width:350},
            {field: 'pid', title: '上级id', align:'center'},
            {field: 'url', title: '资源路径', align:'center'},
            {field: 'icon', title: '图标', align:'center'},
            {field: 'sort', title: '排序', align:'center'},
            {field: 'deep', title: '深度', align:'center'},
            {field: 'resource', title: '资源标识', align:'center'},
            {title: '操作', width:170, templet:'#newsListBar',fixed:"right",align:"center"}
        ]]
    })

    //监听折叠
    element.on('collapse(test)', function(data){
        layer.msg('展开状态：'+ data.show);
    });
});
