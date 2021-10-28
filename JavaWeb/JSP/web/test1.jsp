<%--
  Created by IntelliJ IDEA.
  User: XT
  Date: 2021/10/25
  Time: 7:59
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%--在JSP页面上,随机生成一个1-100 的一个分数,然后根据分数显示分数等级
100-90 A   89-80 B  79-70 C  69 -60 D 60- E--%>
<% int score = (int)(Math.random() * 101); %>
<%= score %>
<br/>
等级：
<%
    int grade = score / 10;
    switch (grade){
        case 10:
        case 9:
%>
<%="A"%>
<%
        break;
    case 8:
%>
<%="B"%>
<%
        break;
    case 7:
%>
<%="C"%>
<%
        break;
    case 6:
%>
<%="D"%>
<%
        break;
    default:
%>
<%="E"%>
<%
    }
%>
</body>
</html>
