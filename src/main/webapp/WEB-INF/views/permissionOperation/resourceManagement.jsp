<%--
  Created by IntelliJ IDEA.
  User: mlw
  Date: 18-3-18
  Time: 下午3:23
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html; charset=UTF-8" %>
<%@ include file="./../../public/tag.jsp" %>
<html>
<head>
    <title>资源管理界面</title>
    <link rel="stylesheet" href="${baseurl}/static/layui/css/layui.css" media="all"/>
    <link rel="stylesheet" href="${baseurl}/static/css/public.css" media="all"/>
</head>
<body class="childrenBody">
<form class="layui-form">
    <blockquote class="layui-elem-quote quoteBox">
        <form class="layui-form">
            <div class="layui-inline">
                <div class="layui-input-inline">
                    <input type="text" class="layui-input searchVal" placeholder="请输入搜索的内容"/>
                </div>
                <a class="layui-btn search_btn" data-type="reload">搜索</a>
            </div>
            <div class="layui-inline">
                <a class="layui-btn layui-btn-normal addNews_btn">添加资源</a>
            </div>
            <div class="layui-inline">
                <a class="layui-btn layui-btn-danger layui-btn-normal delAll_btn">批量删除</a>
            </div>
        </form>
    </blockquote>

    <!--操作-->
    <script type="text/html" id="resourceListBar">
        <a class="layui-btn layui-btn-xs" lay-event="edit">编辑</a>
        <a class="layui-btn layui-btn-xs layui-btn-danger" lay-event="del">删除</a>
        <a class="layui-btn layui-btn-xs layui-btn-primary" lay-event="look">预览</a>
    </script>
</form>
<script type="text/javascript" src="${baseurl}/static/layui/layui.js"></script>
<script type="text/javascript" src="${baseurl}/static/default/tree/jquery.ztree.core.js"></script>
<script type="text/javascript" src="${baseurl}/static/viewJs/permission/resourceManagement.js"></script>
</body>
</html>
