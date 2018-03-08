<%--
  Created by IntelliJ IDEA.
  User: mlw
  Date: 18-3-8
  Time: 上午10:20
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://shiro.apache.org/tags" prefix="shiro" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>
<c:set var="baseurl" value="<%=basePath%>"></c:set>
<script type="text/javascript" src="${baseurl}/static/layui/layui.js"></script>
<script>
    var baseUrl = "${baseurl}";
</script>
