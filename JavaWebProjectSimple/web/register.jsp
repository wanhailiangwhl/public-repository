<%@ page import="com.wanhailiang.beans.User" %><%--
  Created by IntelliJ IDEA.
  User: 30261
  Date: 2023/3/2
  Time: 23:17
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>register</title>
</head>
<body>
<%
    String message = (String)request.getAttribute("message") == null ? "" : (String)request.getAttribute("message");
    User user = (User)request.getAttribute("user");
    String username = user == null ? "" : user.getUsername();
    String pwd = user == null ? "" : user.getPwd();
    String age = user == null ? "" : ((Integer)user.getAge()).toString();
%>
    <form action="/JavaWebProjectSimple/UserServlet" method="post">
        <input type="hidden" name="method" value="register">
        注册界面<br/>
        用户名：<input type="text" name="username" value="<%= username %>"/><br/>
        密码：<input type="password" name="pwd" value="<%= pwd %>"/><br/>
        年龄：<input type="text" name="age" value="<%= age %>"/><br/>
        <input type="submit" value="注册">
        <span style="color: red"><%= message %></span>
    </form>
</body>
</html>
