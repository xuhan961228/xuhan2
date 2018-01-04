<%--
  Created by IntelliJ IDEA.
  User: lanou3g
  Date: 2018/1/4
  Time: 20:02
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="/login" method="post">
    <h1>欢迎来到登录页面！！！</h1>
    账号： <h1 style="color: red">${username}</h1>
    密码： <h1 style="color: red">${password}</h1>
    用户名：<input type="text" name="username"
               <%
                   Cookie[] cookies = request.getCookies();
                   for (Cookie cookie : cookies) {
                       if (cookie.getName().equals("username")){
               %>
   value="<%
   out.write(cookie.getValue());
   %>"
          <%
                  }
              }
          %>
>

    密码：<input type="text" name="password">
    <input type="submit">




</body>

</html>
