<%--
  Created by IntelliJ IDEA.
  User: XT
  Date: 2021/10/25
  Time: 8:25
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%--指定当前页为异常提示页 当前页面可以接收异常对象 --%>
<%@page isErrorPage="true" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    this is error 500 page
<%=exception.getMessage()%>
</body>
</html>
