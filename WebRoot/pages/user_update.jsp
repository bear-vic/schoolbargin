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
    <title>user-update</title>
    <script type="text/javascript">
        function func1() {

            var vs = document.getElementsByTagName("input");
            alert(vs);
            for (var i = 0; i < vs.length; i++) {
                vs[i].disabled = null;
            }

        }
        ;
    </script>
</head>

<body>
<div style="text-align: center">
    <form action="${pageContext.request.contextPath}/user/login">
        <table width="50%" height="50%" border="1" align="center"
               cellpadding="0" cellspacing="0" background="">
            <caption>user</caption>
            <tr>
                <td>名称：</td>
                <td><input id="in_tel" type="text" name="uUsername"
                           value="${user.Name
						}" disabled="disabled">
                </td>
            </tr>
            <tr>
                <td>邮箱：</td>
                <td><input id="in_tel" type="text" name="uEmail"
                           value="${user.uEmail
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
            <tr>
                <td><input type="button" value="修改" onclick="func1()">
                </td>
                <td><input type="submit" value="提交""></td>
            </tr>
        </table>
        <br/> <br/> <a href="">返回</a>
    </form>
</div>
</body>
</html>
