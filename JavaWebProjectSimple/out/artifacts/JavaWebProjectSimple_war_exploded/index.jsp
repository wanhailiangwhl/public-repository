<%@ page import="com.wanhailiang.beans.User" %><%--
  Created by IntelliJ IDEA.
  User: 30261
  Date: 2023/3/2
  Time: 22:35
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>index</title>
    <h1>index.jsp</h1>
</head>
<body>
<%
    User user = (User)request.getAttribute("user");
%>
    <h1>您好，<%= user.getUsername() %>用户，你的年龄是<%= user.getAge() %></h1>
</body>
</html>
