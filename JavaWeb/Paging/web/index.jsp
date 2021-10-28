<%--
  Created by IntelliJ IDEA.
  User: XT
  Date: 2021/10/27
  Time: 10:36
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>$Title$</title>
    <style>
        table {
            border: 1px solid blue;
            margin: 0px auto;
            width: 80%
        }

        td, th {
            border: 1px solid black;
        }
    </style>
</head>
<body>
<div style="text-align: center">
    名字关键字:<input type="text" id="name" value="${name}">
    年龄下限<input type="text" id="age" value="${age}">
    <input type="button" value="查询" id="search" onclick="changePage(1)">
</div>
<table cellpadding="0" cellspacing="0">
    <tr>
        <th>序号</th>
        <th>编号</th>
        <th>姓名</th>
        <th>年龄</th>
        <th>性别</th>
        <th>照片</th>
        <th>照片类型</th>
        <th>操作</th>
    </tr>
    <c:forEach items="${pageList.data}" var="student" varStatus="studentStatus">
        <tr align="center">
            <td>${studentStatus.count}</td>
            <td>${student.id}</td>
            <td>${student.name}</td>
            <td>${student.age}</td>
            <td>${student.gender eq 1 ? "男" : "女"}</td>
            <td>${student.filename}</td>
            <td>${student.filetype}</td>
            <td>删除</td>
        </tr>
    </c:forEach>
    <tr align="center">
        <td colspan="8">
            <c:if test="${pageList.currentPage > 1}">
                <a href="javascript:void(0)" onclick="changePage(${pageList.currentPage - 1})">上一页</a>
            </c:if>
            <c:forEach var="p" begin="1" end="${pageList.totalPage}">
                <c:choose>
                    <c:when test="${p eq pageList.currentPage}">
                        <a href="javascript:void(0)" onclick="changePage('${p}')">[${p}]</a>
                        </c:when>
                    <c:otherwise>
                        <a href="javascript:void(0)" onclick="changePage('${p}')">${p}</a>
                    </c:otherwise>
                </c:choose>
            </c:forEach>
            <c:if test="${pageList.currentPage < pageList.totalPage}">
                <a href="javascript:void(0)" onclick="changePage('${pageList.currentPage + 1}')">下一页</a>
            </c:if>
            <a href="javascript:void(0)" onclick="changePage('${pageList.totalPage}')">尾页</a>
            &nbsp;&nbsp;&nbsp;
            每页<input id="pageSize" style="width: 40px" type="text" value="${pageList.pageSize}">条&nbsp;&nbsp;&nbsp;
            当前第${pageList.currentPage}页&nbsp;&nbsp;&nbsp;
            共${pageList.totalPage}页&nbsp;&nbsp;&nbsp;
            共${pageList.totalSize}条记录&nbsp;&nbsp;&nbsp;
        </td>
    </tr>
</table>
<script src="js/jquery.min.js"></script>
<script>
    function changePage(currentPage) {
        var name = $("#name").val()
        var age = $("#age").val()
        var pageSize = $("#pageSize").val()

        window.location.href = "students?name=" + name + "&age=" + age + "&currentPage=" + currentPage + "&pageSize=" + pageSize
    }
</script>
</body>
</html>
