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
<title>top</title>
</head>
<body>
	<div class="jumbotron container-fluid">
		<h1 class="text-center ">校园交易市场</h1>
	</div>
	<div>
		<li role="presentation navbar-center">在线人数：${um.userNum}</li>
	</div>
	<div class="container-fluid  ">
		<nav class="navbar navbar-inverse" style="height: 50px">
			<c:choose>
				<c:when test="${empty sessionScope.user}">

					<div class="container-fluid">
						<ul class="nav nav-pills navbar-right">
							<li role="presentation"><a class=" "
								href="<c:url value='/pages/login.jsp'/>" target="_parent">登录</a>
							</li>
							<li role="presentation"><a class=""
								href="<c:url value='/pages/user_regist.jsp'/>" target="_parent">注册</a>
							</li>
						</ul>
					</div>
				</c:when>
				<c:otherwise>
					<div class="col-lg-12">
						<ul class="nav nav-pills ">
							<li role="presentation"><span class="bg-danger small"
								role="presentation">您好：</span>
							</li>
							<li><a class="bg-info"
								href="<c:url value='/pages/user_info.jsp'/>">${sessionScope.user.uName
									}</a>&nbsp;&nbsp;</li>
							<li role="presentation" class="navbar-right "><a
								href="<c:url value='/user/logout'/>"
								style="font-size: large;color: #A40001" target="">退出</a>
								&nbsp;&nbsp;</li>
							<li role="presentation"><a class=""
								href="<c:url value='/goods/lookmine'/>" target="">我的商品</a>
							</li> &nbsp;&nbsp;&nbsp;
							<li role="presentation"><a class=""
								href="<c:url value='/pages/user_publish.jsp'/>" target="">发布商品</a>
							</li> &nbsp;&nbsp;&nbsp;
							<li role="presentation"><a class="" href="<c:url value=''/>"
								target="">我的消息</a></li>
						</ul>
					</div>
				</c:otherwise>
			</c:choose>
		</nav>
	</div>
</body>
</html>
