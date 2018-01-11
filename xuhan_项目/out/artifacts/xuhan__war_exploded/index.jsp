<%--
  Created by IntelliJ IDEA.
  User: lanou3g
  Date: 2018/1/8
  Time: 15:25
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>$Title$</title>
  </head>
  <body>
  <h1  style="color: red">${applicationScope.mjh}</h1>
  <form action="../../user" method="post">
    <input type="hidden" name="method" value="jihuo"/>
    请输入激活码：<input type="text" name="jihuoma" value=""/>${applicationScope.a}<br/>
    <input type="submit" value="去激活">
  </form>
  </body>
</html>
