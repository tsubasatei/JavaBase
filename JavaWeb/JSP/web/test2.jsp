<%--
  Created by IntelliJ IDEA.
  User: XT
  Date: 2021/10/25
  Time: 8:20
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <style>
        /*4css样式的注释*/
    </style>
    <script>
        /*5js中的注释*/
    </script>
</head>
<body>
<%--局部变量--%>
<%
    int a = 10;
%>
<%--成员变量--%>
<%!
    int b = 10;
%>

<%--
  1JSP中的注释
  --%>
<!--
2html注释
-->
<%
    for (int i = 0; i < 10 ; i++) {

    }
    /*3java中的注释*/
%>
index2
<%--
1JSP注释    仅仅存在于JSP页面     不会被编入java代码  不会响应给浏览器
2html注释   不仅仅存在于JSP页面 编入java代码        会响应给浏览器
3java注释   不仅仅存在于JSP页面 编入java代码        不会响应给浏览器
4css js注释 不仅仅存在于JSP      编入java代码        会响应给浏览器
推荐在JSP 页面使用JSP注释  尤其是在注释 html代码的时候
--%>

<ol>
    <!--</ol> -->
    <li>1</li>
</ol>
</body>
</html>
