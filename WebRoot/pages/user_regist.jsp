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
    <title>user-regist</title>
    <script src="js/js.js"></script>
    <script type="text/javascript">
    </script>
</head>
<body>
<br>
<span id="test"></span>

<table width="753" height="46" border="0" align="center" cellpadding="0" cellspacing="0" background="images/10.jpg">
    <tr>
        <td>&nbsp;</td>
    </tr>
</table>
<table width="753" height="56" border="0" align="center" cellpadding="0" cellspacing="0" background="images/11.jpg">
    <tr>
        <td valign="top">
            <table width="287" height="33" border="0" align="center" cellpadding="0" cellspacing="0">
                <tr>
                    <th width="287" height="33" align="center" valign="bottom">新用户注册</th>
                </tr>
            </table>
        </td>
    </tr>
</table>
<table width="753" height="494" border="0" align="center" cellpadding="0" cellspacing="0" background="images/12.jpg">
    <tr>
        <td height="393" align="center" valign="top">

            <br><br>
            <form action="${pageContext.request.contextPath}/user/regist" method="post" name="form"
                  onSubmit="return checkUser(form)">
                <table width="439" border="0" align="center">
                    <tr>
                        <td width="92" height="30">用户名：</td>
                        <td width="337"><input name="uName" type="text" maxlength="20" title="请输入用户名！" class="input2">
                        </td>
                    </tr>
                    <tr>
                        <td height="30">密码：</td>
                        <td><input name="uPassword" type="password" maxlength="20" title="请输入密码！" class="input2"></td>
                    </tr>
                    <tr>
                        <td height="30">确认密码：</td>
                        <td><input name="repassword" type="password" maxlength="20" title="请输入确认密码！" class="input2">
                        </td>
                    </tr>
                    <tr>
                        <td height="30">Email地址：</td>
                        <td><input name="uEmail" type="text" maxlength="20" title="请输入Email地址！" class="input2"></td>
                    </tr>
                    <tr>
                        <td height="30">手机号码：</td>
                        <td><input name="uTelephone" type="text" maxlength="20" title="请输入手机号！" class="input2"></td>
                    </tr>
                    <tr>
                        <td height="30">校验码：</td>
                        <td><input name="code" type="text" maxlength="20" title="请输入校验码" class="input2"></td>
                    </tr>
                    <tr>
                        <td height="30">&nbsp;</td>
                        <td><a href="#" onClick="reload()"><img border=0 src="image.jsp" name="checkCode"></a></td>
                    </tr>
                    <tr>
                        <td height="50">&nbsp;</td>
                        <td>
                            <input name="Submit" type="image" class="cannelBorder" src="images/21.gif">
                            &nbsp;&nbsp;&nbsp;&nbsp;
                            <a href="javascript:form.reset();"><img src="images/22.gif"></a>
                        </td>
                    </tr>
                </table>
            </form>
            <br><br><br>
            <c:if test="${requestScope.information!=null}">
                ${requestScope.information}<br><br>
                <a href="userInfoServlet?info=userLand&username=${requestScope.username}">如果要直接登录，请单击此连接</a>
            </c:if>


        </td>
    </tr>
</table>


</body>
</html>
