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
<meta http-equiv="expires" content="0">
<title>Template</title>
<script type="text/javascript">
	$(function() {
		$("#btn").click(function() {
		});
	});
</script>
</head>

<body>
	<c:if test="${empty error}">
		<h1>服务器忙...请稍后再试</h1>
	</c:if>
	${ error}
	<br>
	<a href="<c:url value='/pages/main.jsp'/>">回到主页</a>
</body>
</html>
