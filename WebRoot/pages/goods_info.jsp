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
<title>商品详情</title>
</head>
<body>
	<div class="container-fluid text-center">
		<h1>商品详情</h1>
	</div>
	<div class="panel-body col-lg-3">
		<img src="/${session_comments.goods.gPic}"
			class="img-circle center-block" width="200" height="200">
	</div>
	<div class="panel-body col-lg-6">
		<table class="table table-bordered  table-hover bg-warning ">
			<tbody>
				<td>物品名称:</td>
				<td><a class="" type="" name="gName" placeholder="请输入物品名称"
					goods disabled="disabled" value="">${session_comments.goods.gName}










				
				</td>
			</tbody>
			<tbody>
				<td>物品价格:</td>
				<td><a class="" type="text" name="gPrice"
					placeholder="请输入物品价格(数字)" disabled="disabled" value="">${session_comments.goods.gPrice}元</a>
				</td>
			</tbody>
			<tbody>
				<td>卖家:</td>
				<td><a class="" type="text" name="gName" placeholder="请输入物品名称"
					goods disabled="disabled" value="">${session_comments.user.uName}</a>
				</td>
			</tbody>
			<tbody>
				<td>卖家联系方式:</td>
				<td>${session_comments.user.uTelephone}</td>
			</tbody>
			<tbody>
				<td>卖家地址:</td>
				<td>${session_comments.user.uAddress}</td>
			</tbody>
			<tbody>
				<td colspan="2"><textarea class="form-control"
						placeholder="请输入标题" readonly>${session_comments.goods.gTitle}</textarea>
				</td>
			</tbody>
			<tbody>
				<td colspan="2"><textarea class="form-control" rows="4"
						name="gDescrption" placeholder="详细描述" readonly>${session_comments.goods.gDescrption}</textarea>
				</td>
			</tbody>
		</table>
		<a class="btn btn-block bg-danger" href="">购买</a>
	</div>
	<div class="panel-body col-lg-8 col-lg-offset-2">
		<ul class="nav nav-pills ">
			<li><a href="#">所有留言</a></li>
			<li><a href="#">联系卖家</a></li>
			<li><a>更多</a></li>
		</ul>
		<form action="<c:url value='/comments/leaveMsg'></c:url>"
			method="post">
			<textarea class="form-control " rows="16%" style="color:gray"
				name="gDescrption" placeholder="" readonly>
					<c:if test="${!empty session_comments.commentsList}">
    					<c:forEach items="${session_comments.commentsList}" var="tmp">
${tmp.exDate}  ${tmp.exUname}:
	${tmp.cComments}   						          
    	</c:forEach>
    	</c:if>
				</textarea>
			<c:choose>
				<c:when test="${session_comments.user.uName eq user.uName}">
					<textarea class="form-control " rows="5%" name="cComments"
					disabled></textarea>
				</c:when>
				<c:otherwise>
					<textarea class="form-control " rows="5%" name="cComments"
						placeholder="<c:if test='${empty user}'>登录再来留言</c:if>"></textarea>
				</c:otherwise>
			</c:choose>
			<input class="btn btn-block bg-info" type="submit" value="发送留言">
			<textarea rows="1" hidden="true" name="cGoods">${session_comments.goods.gId} </textarea>
		</form>
	</div>
</body>
</html>
