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
<title>用户信息</title>
<script type="text/javascript">
	function func1() {

		var vs = document.getElementsByTagName("input");
		for ( var i = 0; i < vs.length; i++) {
			vs[i].disabled = null;
		}

	};
</script>
</head>


<body>
	<div class="container-fluid">
		<h1 align="center">个人信息</h1>
		<div class="center-block">
			<form class=""
				action="${pageContext.request.contextPath}/user/update">
				<table class="table table-bordered table-hover bg-info">
					<tr>
						<th>名称：</th>
						<th><input id="in_tel" type="text" name="uUsername"
							value="${user.uName
						}" disabled="disabled"></th>
					</tr>
					<tr>
						<th>邮箱：</th>
						<th><input id="in_tel" type="text" name="uEmail"
							value="${user.uEmail
						}" disabled="disabled"></th>
					</tr>
					<tr>
						<th>手机：</th>
						<th><input id="in_tel" type="text" name="uTelephone"
							value="${user.uTelephone
						}" disabled="disabled"></th>
					</tr>
					<tr>
						<th>地址：</th>
						<th><input id="in_tel" type="text" name="uEmail"
							value="${user.uAddress}
						}" disabled="disabled">
						</th>
					</tr>
					<tr>
						<th><input class="btn btn-block" type="button" value="修改完善"
							onclick="func1()"></th>
						<th><input class="btn btn-block" type="submit" value="确定"">
						</th>
					</tr>
				</table>
			</form>
		</div>
	</div>
</body>
</html>
