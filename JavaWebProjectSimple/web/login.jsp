<%--
  Created by IntelliJ IDEA.
  User: 30261
  Date: 2023/3/2
  Time: 23:17
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>login</title>
    <h1>login.jsp</h1>
</head>
<body>
<%
    String messageUsername = (String)request.getAttribute("messageUsername") == null ? "" : (String)request.getAttribute("messageUsername");
    String messagePassword = (String)request.getAttribute("messagePassword") == null ? "" : (String)request.getAttribute("messagePassword");
%>
    <form action="/JavaWebProjectSimple/UserServlet" method="post">
        <input type="hidden" name="method" value="login">
        请登录！<br/>
        用户名：<input type="text" name="username"/><span style="color: red"><%= messageUsername %></span><br/>
        密码：<input type="password" name="pwd"/><span style="color: red"><%= messagePassword %></span><br/>
        <input type="submit" value="登录">
    </form>
    <a href="/JavaWebProjectSimple/register.jsp">注册</a>
</body>
</html>
