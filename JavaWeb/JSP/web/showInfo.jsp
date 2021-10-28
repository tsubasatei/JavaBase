<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="com.xt.entity.User" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.Map" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%-- JSP 九大内置对象
四个域对象
pageContext  page域     当前页面内可用
request       reqeust域  单次请求
session       session域   单次会话
application   application 域项目运行

响应对象
response   响应对象
输出流对象
out        打印流对象

其他三个对象
servletConfig:由于JSP本身也是一个Servlet,所以容器也会给我们准备一个ServletConfig
page        就是他this对象 当前JSP对象本身
exception   异常对象,在错误提示页上使用,当isErrorpage=true 才具有该对象
--%>

<%--向pageContext域中放数据--%>
<%
    pageContext.setAttribute("msg", "pageContextMessage");
    pageContext.setAttribute("userx", new User(1, "大黄", "abcdefg"));
%>
<%--从域中取出数据--%>
pageContext:<br/>
msg:<%=pageContext.getAttribute("msg")%><br/>
username:<%=((User) pageContext.getAttribute("userx")).getUsername()%><br/>
request域中的数据:<br/>
msg:<%=request.getAttribute("msg")%><br/>
username:<%=((User) request.getAttribute("user")).getUsername()%><br/>
session域中的数据:<br/>
msg:<%=session.getAttribute("msg")%><br/>
username:<%=((List<User>) session.getAttribute("users")).get(0).getUsername()%><br/>
application域中的数据:<br/>
msg:<%=application.getAttribute("msg")%><br/>
username:<%=((Map<String, User>) application.getAttribute("userMap")).get("a").getUsername()%><br/>

<hr/>


<%--
从域中取出数据
El表达式在获取对象属性值得时候,是通过对象的属性的get方法获取的
保证对象的要获取的属性必须有对应get方法才可以
EL表达式在使用时是不需要import其他类的
El如果获取的是NULL值,是不展示任何信息的
--%>
pageContext域中的数据:<br/>
msg:${pageScope.msg}<br/>
username:${pageScope.userx.username}<br/>
<hr/>
request域中的数据:<br/>
msg:${requestScope.msg}<br/>
username:${requestScope.user.username}<br/>
<hr/>
session域中的数据:<br/>
msg:${sessionScope.msg}<br/>
username:${sessionScope.users[1].username}<br/>
<hr/>
application域中的数据:<br/>
msg:${applicationScope.msg}<br/>
username:${applicationScope.userMap.a.username}<br/>
<hr/>
<%--EL表达式在取出数据的时候是可以省略域标志的
EL表达式会自动依次到四个域中去找数据
--%>
PageContext username:${userx.username}<br/>
Request username:${user.username}<br/>
Session username:${users[1].username}<br/>
Application username:${userMap.a.username}<br/>
<hr/>
<%--
${数据的名字}如果省略域标志,取数据的顺序如下
pageContext
request
session
application
--%>
${msg}
<hr/>
<%--
移除域中的数据
--%>
<%
//    pageContext.removeAttribute("msg");// pageContext.removeAttribute()方法会移除四个域中的所有的同名的数据
    request.removeAttribute("msg"); // 只会移除request
%>
pageContextMsg: ${pageScope.msg}<br/>
requestMsg: ${requestScope.msg}<br/>
sessionMsg: ${sessionScope.msg}<br/>
applicationMsg: ${applicationScope.msg}<br/>
<hr/>
<%--
EL表达式获取请求中的参数
--%>
username: ${param.username}<br/>
hobby: ${paramValues.hobby[0]}
hobby: ${paramValues.hobby[1]}
</body>
</html>
