<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html lang="zh-CN">
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<title>the base of all</title>
<!--test path-->
<script src="js/jquery-1.9.1.min.js"></script>
<script src="js/bootstrap.min.js"></script>
<link href="css/bootstrap.min.css" rel="stylesheet">
<!--real path-->
<script src="<c:url value='/pages/js/jquery-1.9.1.min.js'/>"></script>
<script src="<c:url value='/pages/js/bootstrap.min.js'/>"></script>
<link href="<c:url value='/pages/css/bootstrap.min.css'/>"
	rel="stylesheet">
<!-- net path-->
<link rel="stylesheet"
	href="//cdn.bootcss.com/bootstrap/3.3.5/css/bootstrap.min.css">
<link rel="stylesheet"
	href="//cdn.bootcss.com/bootstrap/3.3.5/css/bootstrap-theme.min.css">
<script src="//cdn.bootcss.com/jquery/1.11.3/jquery.min.js"></script>
<script src="//cdn.bootcss.com/bootstrap/3.3.5/js/bootstrap.min.js"></script>
</head>
<body>
<div class="container-fluid" >
	<nav class="navbar navbar-fixed-bottom ">
		<ul>
			<li><a  href="<c:url value='/pages/main.jsp'/>"
				style="font-size:12px; color: #FF0000">返回</a></li>
		</ul>
	</nav>
</div>
</body>