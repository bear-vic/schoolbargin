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


    <script type="text/javascript">
        $(document).ready(function () {
            $(".change").click(
                    function () {
                        $("input").attr("disabled", false);
                        $("textarea").attr("disabled", false);
                    }
            );
            $("#reset").click(
            );
        });
    </script>
</head>
<body>

<div class="container-fluid">
    <h1 class="text-center">我的商品</h1>
    <c:forEach items="${req_obj}" var="goods">
        <div class="panel-body col-lg-6">
            <form class=""
                  action="${pageContext.request.contextPath }/goods/modify?gId=${goods.gId}"
                  method="post" enctype="multipart/form-data">
                <img src="/${goods.gPic}" class="img-rounded center-block"
                     width="300" height="300">
                <table class="table table-bordered  table-hover bg-success ">
                    <tbody>
                    <td>图片:</td>
                    <td><input type="file" name="gPicFile" disabled="disabled">
                    </td>
                    </tbody>
                    <tbody>
                    <td>物品名称:</td>
                    <td><input class="" type="text" name="gName" placeholder="请输入物品名称"
                               goods disabled="disabled" value="${goods.gName}">
                    </td>
                    </tbody>
                    <tbody>
                    <td>物品价格:</td>
                    <td>
                        <input class="" type="text" name="gPrice"
                               placeholder="请输入物品价格(数字)" disabled="disabled"
                               value="${goods.gPrice}">元
                    </td>
                    </tbody>
                    <tbody>
                    <td colspan="2"><textarea class="form-control"
                                              placeholder="请输入标题" disabled="disabled">${goods.gTitle}</textarea>
                    </td>
                    </tbody>
                    <tbody>
                    <td colspan="2"><textarea class="form-control" rows="4"
                                              name="gDescrption" placeholder="详细描述" disabled="disabled">${goods.gDescrption}</textarea>
                    </td>
                    </tbody>
                    <tbody>
                    <td colspan="2">
                        <ul class="nav nav-pills ">
                            <li>
                                <input type="button" id="" class="change  btn btn-info " value="修改"/>
                                &nbsp;&nbsp; &nbsp;&nbsp; &nbsp;&nbsp;
                            </li>
                            <li>
                                <input type="button" id="reset" class="btn btn-default " value="重置"/>
                            </li>
                            <li>
                                <input class="btn btn-warning" type="submit" value="确定" disabled="disabled">
                            </li>
                            <li class="navbar-right">
                                <a href="${pageContext.request.contextPath}/goods/delgoods?gId=${goods.gId}">删除</a>
                            </li>
                        </ul>
                    </td>
                    </tbody>
                </table>
            </form>

        </div>
    </c:forEach>
</div>
</body>
</html>
