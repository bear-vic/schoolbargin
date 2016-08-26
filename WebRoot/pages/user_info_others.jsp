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
    <title>other-info</title>
    <script type="text/javascript">
        function func1() {

            var vs = document.getElementsByTagName("input");
            for (var i = 0; i < vs.length; i++) {
                vs[i].disabled = null;
            }

        }
        ;
    </script>
</head>

<body>
<h1 align="center">卖家信息</h1>
<div style="text-align: center">
    <form action="${pageContext.request.contextPath}/user/update">
        <table width="50%" height="50%" border="1" align="center"
               cellpadding="0" cellspacing="0" background="">
            <tr>
                <td>名称：</td>
                <td><input id="in_tel" type="text" name="uUsername"
                           value="${user.uName
						}" disabled="disabled">
                </td>
            </tr>
            <tr>
                <td>手机：</td>
                <td><input id="in_tel" type="text" name="uTelephone"
                           value="${user.uTelephone
						}" disabled="disabled">
                </td>
            </tr>
            <tr>
                <td>地址：</td>
                <td>${user.uAddress}</td>
            </tr>
        </table>
        <br/> <br/> <a href="<c:url value='/pages/main.jsp'/>">返回</a>
    </form>
</div>
</body>
</html>
