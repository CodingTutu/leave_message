<%--
  Created by IntelliJ IDEA.
  User: my-deepin
  Date: 18-4-27
  Time: 下午7:19
  To change this template use File | Settings | File Templates.
--%>
<%@ page isELIgnored="false" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path;
%>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" href="<%=basePath%>/lib/bootstrap.min.css"/>
</head>
<body>
<div class="container">
    <h2>${message}</h2>
</div>
</body>
</html>
