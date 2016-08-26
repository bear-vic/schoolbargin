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
</head>

<body>
<div class="container-fluid">
    <nav class="nav nav-pills  ">
        <div class="container-fluid">
            <form class="form-horizontal"
                  action="<c:url value='/goods/searchlike'/>" method="post">
                <div class="form-group col-lg-3 " role="presentation">
                    <label>商品名称</label> <input type="text" name="byGName"
                                               class="bg-info" value="${itemQuery.byGName}" placeholder="可选输入商品名"/>
                </div>
                <div class="form-group col-lg-3 " role="presentation">
                    <label> 用户名称</label> <input type="text" placeholder="可选输入用户名"
                                                class="bg-info" name="byUName" value="${itemQuery.byUName}"/>
                </div>
                <div class="form-group col-lg-3 " role="presentation">
                    <input class="btn btn-warning btn-sm" type="submit" value="查询"> <input type="text"
                                                                                           style="width: 80px"
                                                                                           class="bg-info"
                                                                                           placeholder="每页显示4"
                                                                                           name="sPs">
                </div>
            </form>
        </div>
    </nav>

    <div class="container-fluid  ">
        <nav class="nav nav-pills navbar-left">
            <ul class="pagination ">
                <c:if test="${!empty pb.tList }">
                    <li>
                        <a href="<c:url value='/goods/searchlike?pc=1&sPs=${itemQuery.sPs}&byUName=${itemQuery.byUName}&byGName=${itemQuery.byGName}'/>">首页</a>
                    </li>
                    <c:if test="${pb.hasPre}">
                        <li>
                            <a
                                    href="<c:url value='/goods/searchlike?pc=${pb.pageNow-1}&sPs=${itemQuery.sPs}&byUName=${itemQuery.byUName}&byGName=${itemQuery.byGName}'/>">上一页</a>&nbsp;&nbsp;&nbsp;
                        </li>
                    </c:if>
                    <c:forEach var="i" begin="${pb.pageTag.left}"
                               end="${pb.pageTag.right}">

                        <c:choose>
                            <c:when test="${i==pb.pageNow}">
                                <li class="active ">
                                    <a class="">${i}</a>
                                </li>
                            </c:when>
                            <c:otherwise>
                                <li>
                                    <a
                                            href="<c:url value='/goods/searchlike?pc=${i}&sPs=${itemQuery.sPs}&byUName=${itemQuery.byUName}&byGName=${itemQuery.byGName}'/>">${i}</a>
                                </li>
                            </c:otherwise>
                        </c:choose>

                    </c:forEach>

                    <c:if test="${pb.hasNext}">
                        <li>
                            <a
                                    href="<c:url value='/goods/searchlike?pc=${pb.pageNow+1}&sPs=${itemQuery.sPs}&byUName=${itemQuery.byUName}&byGName=${itemQuery.byGName}'/>">下一页</a>
                        </li>
                    </c:if>
                    <li>
                        <a
                                href="<c:url value='/goods/searchlike?pc=${pb.totalPage}&sPs=${itemQuery.sPs}&byUName=${itemQuery.byUName}&byGName=${itemQuery.byGName}'/>">尾页</a>

                    </li>
                    <li>
                        <br>
                        <form class="input-group"
                              action="<c:url value='/goods/searchlike?byUName=${itemQuery.byUName}&byGName=${itemQuery.byGName}&sPs=${itemQuery.sPs}'/>"
                              method="post">

                            <input type="text" class="bg-info"
                                   style="width: 30px" name="pc">
                            <span class="" style="font-size:small;color: #1980DB">页</span>
                            &nbsp;&nbsp;
                            <input
                                    class="btn  btn-sm btn-xs"
                                    type="submit" value="跳转">
                            &nbsp;&nbsp;<span style="font-size: smaller;color: #FF0000"> ${pb.totalCount}条记录 </span>
                        </form>
                    </li>
                </c:if>
            </ul>
        </nav>
    </div>
    <div class="container-fluid ">
        <nav class="nav navbar-fixed-bottom left">
            <ul class="pagination  pagination-sm" style="padding-top:100px">
                <c:if test="${pb.hasPre}">
                    <li>
                        <a href="<c:url value='/goods/searchlike?pc=${pb.pageNow-1}&sPs=${itemQuery.sPs}&byUName=${itemQuery.byUName}&byGName=${itemQuery.byGName}'/>"
                           aria-label="Previous">
                            <span aria-hidden="true">&laquo;</span>
                        </a>
                    </li>
                </c:if>
                <c:forEach var="i" begin="${pb.pageTag.left}"
                           end="${pb.pageTag.right}">
                    <c:choose>
                        <c:when test="${i==pb.pageNow}">
                            <li class="active">
                                <a>${i}</a>
                            </li>
                        </c:when>
                        <c:otherwise>
                            <li>
                                <a href="<c:url value='/goods/searchlike?pc=${i}&sPs=${itemQuery.sPs}&byUName=${itemQuery.byUName}&byGName=${itemQuery.byGName}'/>">${i}</a>
                            </li>
                        </c:otherwise>
                    </c:choose>
                </c:forEach>
                <c:if test="${pb.hasNext}">
                    <li>
                        <a href="<c:url value='/goods/searchlike?pc=${pb.pageNow+1}&sPs=${itemQuery.sPs}&byUName=${itemQuery.byUName}&byGName=${itemQuery.byGName}'/>"
                           aria-label="Next">
                            <span aria-hidden="true">&raquo;</span>
                        </a>
                    </li>
                </c:if>
            </ul>
        </nav>
    </div>
</div>
</body>
</html>
