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
	var user={
	uName:$("#uname").val(),
	uTelphone:$("#utel").val()
};
		$("#btn2").click(function() {
			console.log(user);
			$.get("/schoolbargin/user/login",
			user, 
			 function(data, status) {
				$.each(data, function(i, n) {
					console.log(n, status);
				});
			}

			);
		});
	});

	// data 可以是 xmlDoc, jsonObj, html, text, 等等.
	//this; // 这个Ajax请求的选项配置信息，请参考jQuery.get()说到的this
	/* for(var i=0,i<data1.length(),i++){
	 } */
	/* $.each(data1,function(i,n){
	 console.log(data1[i]);
	 });
	 });
	 });
	 }); */
</script>
</head>

<body>
	<div id="div1"></div>
	<br>
	<button id="btn1">click</button>
	
	<form id='addForm'  >
     <label for='uname'>用户名</label>：<input type='text'  id='uname'><br>
     <label for='utel'>手机号：</label><input type='text' id='utel'><br>
     <input id="btn2" type='button' value='提交' >
</form>
</body>
</html>
