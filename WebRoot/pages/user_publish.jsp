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
    <title>发布商品</title>
</head>
<body>
<div class="container-fluid text-center">
    <h1>发布新商品</h1>
</div>
<div class="container col-lg-6 col-lg-offset-3">
    <form class=" " action="${pageContext.request.contextPath }/goods/publish"
          method="post" enctype="multipart/form-data">

        <div class="input-group ">
            <span class="input-group-addon">图片</span>
            <input class=" form-control" type="file" name="gPicFile">
        </div>
        <input class="form-control" type="text" name="gName" placeholder="请输入物品名称">
        <div class="input-group">
            <input class="form-control" type="text" name="gPrice" placeholder="请输入物品价格(数字)">
            <span class="input-group-addon">元</span>
        </div>
        <textarea class="form-control" rows="3" name="gTitle" placeholder="请输入标题"></textarea>
        <textarea class="form-control" rows="6" name="gDescrption"
                  placeholder="详细描述"></textarea>
        <br>
        <input class="form-control" type="submit" value="发布">
    </form>
</div>
</body>
</html>
