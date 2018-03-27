<%@ taglib prefix="shiro" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: mlw
  Date: 18-3-18
  Time: 下午3:23
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>角色管理界面</title>
</head>
<body class="gray-bg">
<div class="wrapper wrapper-content">
    <div class="btn-group hidden-xs" id="tableToolbar" role="group">
        <button type="button" class="btn btn-outline btn-default" onclick="add()" shiro:shiro:hasPermission="system:role:add">
            <i class="glyphicon glyphicon-plus"></i>
        </button>
        <button type="button" class="btn btn-outline btn-default" onclick="batchRemove()" shiro:hasPermission="system:role:batchRemove">
            <i class="glyphicon glyphicon-trash"></i>
        </button>
    </div>
    <table class="bootstrap-table" data-mobile-responsive="true"
           data-sort-name="role_sort" data-sort-order="asc">
    </table>
</div>
<%@include file="../include.jsp" %>
<script type="text/javascript" src="${baseurl}/static/viewJs/permission/roleManagement.js"></script>
</body>
</html>
