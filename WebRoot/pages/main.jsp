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
<title>主页</title>
</head>
<body>
	<div class="container-fluid ">
		<div class="panel-heading ">
			<jsp:include page="top.jsp"></jsp:include>
		</div>
		<div class="panel-collapse ">
			<jsp:include page="pagebean.jsp"></jsp:include>
		</div>
		<c:if test="${empty pb.tList}">
			<div class="container-fluid text-center">
				<span class=""
					style="font-family: 'Bodoni MT Black' ;font-size: xx-large ;color: deeppink">亲！啥也没有</span>
			</div>
		</c:if>
		<c:forEach var="bundleQuery" items="${pb.tList}">
			<div class="container col-lg-6 " style="position:relative">
				<div class="panel-body ">
				 <a href="<c:url value='/comments/watch?goodsId=${bundleQuery.goods.gId}'/>">
				 <img class=" img-rounded center-block"
						src="/${bundleQuery.goods.gPic}" width="480px" height="270px"
						onclick="imgfun"></a>
					<table class="table  table-condensed">
						<tr>
							<td><label>商品名:</label></td>
							<td><span class="bg-info">${bundleQuery.goods.gName}</span>
							</td>
						</tr>
						<tr>
							<td><label> 卖家: </label></td>
							<td><span class="bg-success">${bundleQuery.user.uName}</span>
							</td>
						</tr>
						<tr>
							<td><label>价格：</label></td>
							<td><span class="bg-danger">${bundleQuery.goods.gPrice}&nbsp;&nbsp;
									元</span></td>
						</tr>
						<tr>
							<td><label> 上架时间：</label>
							<td>${bundleQuery.goods.exDate}</td>
						</tr>
						<tr>
							<td><label>描述：</label>
							</td>
							<td><label> ${bundleQuery.goods.gTitle}
							</label></td>
						</tr>


					</table>
				</div>
			</div>
			
		</c:forEach>
	</div>
</body>
</html>
