<%--
  Created by IntelliJ IDEA.
  User: lanou3g
  Date: 2018/1/3
  Time: 19:33
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>欢迎来到书店</title>
    <script src="js/jquery-3.2.1.min.js"></script>
</head>
<body>
<h1>欢迎来到书店</h1>
<%


    if (session.getAttribute("username")!=null){
        System.out.println(session.getAttribute("username"));

        out.write("用户名为："+pageContext.findAttribute("username").toString()+"-----------------------"+
                "密码为："+pageContext.findAttribute("password").toString());



}else {
%>
<a href="login.html">请去登录</a>
<%
    }
%>
<form action="quit" method="post">
    <input type="submit">
</form>
<table style="border: 2px" id="b">
</table>


</body>
<script type="text/javascript">
    $.getJSON("http://localhost:8080/zhuye",function (json,status) {
        if (status == "success") {
            $('#b').append(
                $('<tr>').append(
                    $('<th>').text("书名")
                ).append(
                    $('<th>').text("作者")
                ).append(
                    $('<th>').text("价钱")
                )
            );
            $.each(json, function (index, obj) {
                var bookname = obj['bname'];
                var writer = obj['author'];
                var price = obj['price'];
                $('#b').append(
                    $('<tr>')
                        .append(
                            $('<td>').text(bookname)
                        ).append(
                        $('<td>').text(writer)
                    ).append(
                        $('<td>').text(price)
                    )
                )
            })
        }
    })



</script>
</html>
