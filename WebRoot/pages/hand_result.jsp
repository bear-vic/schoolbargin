<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<jsp:include page="abc.jsp"></jsp:include>
<html lang="zh-CN">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta http-equiv="pragma" content="no-cache">
    <meta http-equiv="cache-control" content="no-cache">
    <meta http-equiv="refresh" content="3,url=<c:url value='/pages/main.jsp'/>">
    <meta http-equiv="expires" content="0">
    <title>结果页</title>
</head>

<body>
<h1>
<a class="center-block" href="${pageContext.request.contextPath }/pages/main.jsp">3秒后自动回到主页</a>
</h1>
${req_msg.msg}
</body>
</html>
