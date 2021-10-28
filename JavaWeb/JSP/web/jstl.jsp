<%@ page import="java.util.Random" %><%--
  Created by IntelliJ IDEA.
  User: XT
  Date: 2021/10/25
  Time: 14:44
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<c:set scope="page" var="msg" value="pageScopeMsg"/>
<c:set scope="request" var="msg" value="requestScopeMsg"/>
<c:set scope="session" var="msg" value="sessionScopeMsg"/>
<c:set scope="application" var="msg" value="applicationScopeMsg"/>

<c:remove var="msg" scope="page"/>
<c:remove var="msg" scope="request"/>
<%--<c:remove var="msg" scope="session"/>--%>
<c:remove var="msg" scope="application"/>
<hr/>
${pageScope.msg} <br/>
${requestScope.msg}<br/>
${sessionScope.msg}<br/>
${applicationScope.msg}<br/>
<hr/>
<c:out value="${pageScope.msg}" default="page scope not found"/><br/>
<c:out value="${requestScope.msg}" default="request scope not found"/><br/>
<c:out value="${sessionScope.msg}" default="session scope not found"/><br/>
<c:out value="${applicationScope.msg}" default="application scope not found"/><br/>

<hr/>
<%
    int score = new Random().nextInt(101);
    pageContext.setAttribute("score", score);
%>
分数: ${score}<br/>
等级:
<c:if test="${score ge 90}" scope="page" var="f1">A</c:if>
<c:if test="${score lt 90 and score ge 80}" scope="page" var="f2">B</c:if>
<c:if test="${score lt 80 and score ge 70}" scope="page" var="f3">C</c:if>
<c:if test="${score lt 70 and score ge 60}" scope="page" var="f4">D</c:if>
<c:if test="${score lt 60}" scope="page" var="f5">E</c:if>
<hr/>
${f1}
${f2}
${f3}
${f4}
${f5}
<hr/>
<c:choose>
    <c:when test="${score ge 60}">及格</c:when>
    <c:when test="${score lt 60}">不及格</c:when>
</c:choose>

<hr/>
<c:forEach var="i" begin="1" end="9" step="1">
    <c:forEach var="j" begin="1" end="${i}" step="1">
        ${j} * ${i} = ${j * i}
    </c:forEach>
    <br/>
</c:forEach>
</body>
</html>
