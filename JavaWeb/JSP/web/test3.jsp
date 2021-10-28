<%--告知浏览器以什么格式和编码解析 响应的数据--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%--设置JSP页面转换的语言--%>
<%@ page language="java"%>
<%--导包--%>
<%@ page import="java.util.Date" %>
<%--在转换成java代码时使用的编码 一般不用设置--%>
<%@ page pageEncoding="UTF-8" %>
<%--指定错误页 当页面发生错误时 指定跳转的页面--%>
<%@ page errorPage="error500.jsp" %>
<%--指定当前页为异常提示页 当前页面可以接收异常对象 --%>
<%--<%@page isErrorPage="true" %>--%>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <% int i = 10 / 0; %>
</body>
</html>
