<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>


<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>购物车列表</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<meta http-equiv="content-type" content="text/html;charset=utf-8">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
<style type="text/css">
	* {
		font-size: 11pt;
	}
	div {
		margin:20px;
		border: solid 2px gray;
		width: 150px;
		height: 150px;
		text-align: center;
	}
	li {
		margin: 10px;
	}
	
	#buy {
		background: url(<c:url value='/images/all.png'/>) no-repeat;
		display: inline-block;
		
		background-position: 0 -902px;
		margin-left: 30px;
		height: 36px;
		width: 146px;
	}
	#buy:HOVER {
		background: url(<c:url value='/images/all.png'/>) no-repeat;
		display: inline-block;
		
		background-position: 0 -938px;
		margin-left: 30px;
		height: 36px;
		width: 146px;
	}
</style>
  </head>
  
  <body>
<h1>购物车</h1>

<table border="1" width="100%" cellspacing="0" background="black">
	<tr>
		<td colspan="7" align="right" style="font-size: 15pt; font-weight: 900">
			<a href="<c:url value='http://localhost:8080/se?method=removeAll'/>">清空购物车</a>
		</td>
	</tr>
	<tr>
		<th>图片</th>
		<th>书名</th>
		<th>作者</th>
		<th>单价</th>
		<th>数量</th>
		<th>小计</th>
		<th>操作</th>
	</tr>

	<%--<tr>--%>
		<%--<td><div><img src="<c:url value='/book_img/8758723-1_l.jpg'/>"/></div></td>--%>
		<%--<td>Java详解</td>--%>
		<%--<td>张孝祥</td>--%>
		<%--<td>39.9元</td>--%>
		<%--<td>2</td>--%>
		<%--<td>79.8元</td>--%>
		<%--<td><a href="javascript:alert('删除购物项成功！');">删除</a></td>--%>
	<%--</tr>--%>
	<%--<tr>--%>
		<%--<td><div><img src="<c:url value='/book_img/8758723-1_l.jpg'/>"/></div></td>--%>
		<%--<td>Java详解</td>--%>
		<%--<td>张孝祥</td>--%>
		<%--<td>39.9元</td>--%>
		<%--<td>2</td>--%>
		<%--<td>79.8元</td>--%>
		<%--<td><a href="javascript:alert('删除购物项成功！');">删除</a></td>--%>
	<%--</tr>--%>

	<%--<c:forEach items="${sessionScope.gwc}" var="bbb" step="1">--%>
	<c:if test="${sessionScope.gwc!=null}">
		<c:forEach items="${sessionScope.gwc}" var="gwc">
			<tr>
				<td><div><img src="<c:url value='${gwc.value.image}'/>"/></div></td>
				<td>${gwc.value.bname}</td>
				<td>${gwc.value.author}</td>
				<td>${gwc.value.price}元</td>
				<td>${gwc.value.count}</td>
				<td>${(gwc.value.price)*(gwc.value.count)}元</td>
				<td><a href="<c:url value='/se?method=remove&bid=${gwc.value.bid}'/>">删除</a></td>
					<%--${((gwc.value.price)*(gwc.value.count))*i}--%>
			</tr>
		</c:forEach>
	</c:if>
	<c:set var="sum" value="0"/>
	<c:if test="${sessionScope.gwc != null}">
		<c:forEach var="carItem" items="${sessionScope.gwc}">
			<c:set var="sum" value="${sum + (carItem.value.price) * (carItem.value.count) }"/>
		</c:forEach>
	</c:if>
	<%--</c:forEach>--%>
	<tr>
		<td colspan="7" align="right" style="font-size: 15pt; font-weight: 900">
			合计：${sum}
		</td>
	</tr>
	<tr>
		<td colspan="7" align="right" style="font-size: 15pt; font-weight: 900">
			<a id="buy" href="<c:url value='/se?method=buy&price=${sum}'/>"></a>
		</td>
	</tr>
</table>
  </body>
</html>
