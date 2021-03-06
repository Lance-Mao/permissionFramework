<%--
  Created by IntelliJ IDEA.
  User: mlw
  Date: 18-3-22
  Time: 上午11:09
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="./../../public/tag.jsp" %>
<html>
<head>
    <title>Title</title>
    <%@include file="../include.jsp" %>
    <script src="${baseurl}/static/default/iCheck/icheck.min.js" type="text/javascript"></script>
    <link href="${baseurl}/static/default/iCheck/custom.css" rel="stylesheet">
</head>
<body class="white-bg">
<div class="wrapper wrapper-content animated fadeInRight ibox-content">
    <form class="form-horizontal m" id="form-menu-add">
        <input name="id" type="hidden" value="${menu.id}" />
        <input name="parentId" type="hidden" value="${menu.pid}" />

        <div class="form-group">
            <label class="col-sm-3 control-label">菜单类型：</label>
            <div class="col-sm-8">
                <label class="checkbox-inline i-checks"> <input type="radio" ${menu.menuType == "M" ? "checked" : ""} name="menuType" value="M" /> 目录 </label>
                <label class="checkbox-inline i-checks"> <input type="radio" ${menu.menuType == "C" ? "checked" : ""} name="menuType" value="C" /> 菜单 </label>
                <label class="checkbox-inline i-checks"> <input type="radio" ${menu.menuType == "F" ? "checked" : ""} name="menuType" value="F" /> 按钮 </label>
            </div>
        </div>
        <div class="form-group">
            <label class="col-sm-3 control-label">菜单名称：</label>
            <div class="col-sm-8">
                <label for="menuName"></label><input class="form-control" type="text" name="menuName" id="menuName" value="${menu.menuName}">
            </div>
        </div>
        <div class="form-group">
            <label class="col-sm-3 control-label">请求地址：</label>
            <div class="col-sm-8">
                <label for="url"></label><input id="url" name="url" class="form-control" type="text" value="${menu.url}">
            </div>
        </div>
        <div class="form-group">
            <label class="col-sm-3 control-label">权限标识：</label>
            <div class="col-sm-8">
                <label for="perms"></label><input id="perms" name="perms" class="form-control" type="text" value="${menu.perms}">
            </div>
        </div>
        <div class="form-group">
            <label class="col-sm-3 control-label">显示排序：</label>
            <div class="col-sm-8">
                <label>
                    <input class="form-control" type="text" name="sort" value="${menu.sort}">
                </label>
            </div>
        </div>
        <div class="form-group">
            <label class="col-sm-3 control-label">图标：</label>
            <div class="col-sm-5">
                <input id="icon" name="icon" class="form-control" type="text" placeholder="例如：fa fa-index" value="${menu.icon}">
            </div>
            <input class="btn btn-warning" type="button" value="选择图标" onclick="openIocn()" />
        </div>
        <div class="form-group">
            <label class="col-sm-3 control-label">菜单状态：</label>
            <div class="col-sm-8">
                <div class="onoffswitch">
                    <input type="checkbox" checked="true" class="onoffswitch-checkbox" id="visible" name="visible" value="${menu.visible}">
                    <label class="onoffswitch-label" for="visible">
                        <span class="onoffswitch-inner"></span>
                        <span class="onoffswitch-switch"></span>
                    </label>
                </div>
            </div>
        </div>
        <div class="form-group">
            <div class="form-control-static col-sm-offset-9">
                <button type="submit" class="btn btn-primary">提交</button>
                <button onclick="layer_close()" class="btn btn-danger" type="button">关闭</button>
            </div>
        </div>
    </form>
</div>
<script type="text/javascript" src="${baseurl}/static/viewJs/permission/resourceManagement_edit.js" ></script>

<script>
    $(document).ready(function(){$(".i-checks").iCheck({checkboxClass:"icheckbox_square-green",radioClass:"iradio_square-green",})});
</script>
</body>
</html>
