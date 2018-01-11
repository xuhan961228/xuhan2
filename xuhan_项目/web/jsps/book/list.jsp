<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>图书列表</title>
    
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
	body {
		font-size: 10pt;
	}
	.icon {
		margin:10px;
		border: solid 2px gray;
		width: 160px;
		height: 180px;
		text-align: center;
		float: left;
	}
</style>
  </head>

  <body>



<c:forEach items="${requestScope.books}" var="books" step="1">
  <div class="icon">
    <a href="<c:url value='/se?method=xq&bid=${books.bid}'/>"><img src="<c:url value='${books.image}'/>" border="0"/></a>
      <br/>
   	<a href="<c:url value='/se?method=xq&bid=${books.bid}'/>">${books.bname}</a>
  </div>
</c:forEach>

<c:forEach items="${requestScope.se}" var="sebooks" step="1">
    <div class="icon">
        <a href="<c:url value='/se?method=xq&bid=${sebooks.bid}'/>"><img src="<c:url value='${sebooks.image}'/>" border="0"/></a>
        <br/>
        <a href="<c:url value='/se?method=xq&bid=${sebooks.bid}'/>">${sebooks.bname}</a>
    </div>
</c:forEach>

<c:forEach items="${requestScope.ee}" var="eebooks" step="1">
    <div class="icon">
        <a href="<c:url value='/se?method=xq&bid=${eebooks.bid}'/>"><img src="<c:url value='${eebooks.image}'/>" border="0"/></a>
        <br/>
        <a href="<c:url value='/se?method=xq&bid=${eebooks.bid}'/>">${eebooks.bname}</a>
    </div>
</c:forEach>

<c:forEach items="${requestScope.js}" var="jsbooks" step="1">
    <div class="icon">
        <a href="<c:url value='/se?method=xq&bid=${jsbooks.bid}'/>"><img src="<c:url value='${jsbooks.image}'/>" border="0"/></a>
        <br/>
        <a href="<c:url value='/se?method=xq&bid=${jsbooks.bid}'/>">${jsbooks.bname}</a>
    </div>
</c:forEach>

<%--<div class="icon">--%>
    <%--<a href="<c:url value='/jsps/book/desc.jsp'/>"><img src="<c:url value='/book_img/8991366-1_l.jpg'/>" border="0"/></a>--%>
    <%--<br/>--%>
    <%--<a href="<c:url value='/jsps/book/desc.jsp'/>">Java开发详解</a>--%>
<%--</div>--%>
  </body>
 
</html>

