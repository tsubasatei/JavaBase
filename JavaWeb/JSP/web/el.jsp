<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %><%--
  Created by IntelliJ IDEA.
  User: XT
  Date: 2021/10/25
  Time: 14:28
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%--
+两端如果有字符串,会尝试将字符串转换成数字之后进行加法运算
/如果除以0 结果为Infinity 而不是出现异常
%如果和0取余数,那么会出现异常
--%>
算数运算符：
<hr/>
${10 + 10}<br/>
${"10" + 10}<br/>
${"10" + "10"}<br/>
<%--${"10a" + 10}<br/>--%>
${10/0}<br/>
<%-- ${10%0}<br/>--%>
关系运算符/比较运算符
<%--
比较运算符推荐写成字母形式,不推荐使用 == >=  <=
--%>
<hr/>
${10 == 10}<br/>
${10 eq 10}<br/>
${10 gt 8}<br/>
逻辑运算符
<hr/>
${ true || false}<br/>
${ true or false}<br/>
${ true && false}<br/>
${ true and false}<br/>
条件运算符/三目运算符
<hr/>
${(100-1)%3==0?10+1:10-1}<br/>
判断空运算符
<%--empty 为null 则为true--%>
<%  //向域中放入数据
    pageContext.setAttribute("a", null);
    pageContext.setAttribute("b", "");
    int[] arr = {};
    pageContext.setAttribute("arr", arr);
    List list = new ArrayList();
    pageContext.setAttribute("list", list);
%>
<hr/>
${empty a}<br/>
${empty b}<br/><%--字符串长度为0 则认为是空--%>
${empty arr}<br/><%--数组长度为0 认为不是空--%>
${empty list}<br/><%--集合长度为0 认为是空--%>
${list.size() eq 0}<br/><%--集合长度为0 认为是空--%>
</body>
</html>
