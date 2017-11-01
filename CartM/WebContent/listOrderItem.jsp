<%@page import="bean.OrderItem"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8" isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
</head>
<body style="text-align: center;">
<center>
	<h1>购物车</h1>
	
	<table border="1" cellspacing="0">
		<tr>
			<td>商品名称</td>
			<td>商品价格</td>
			<td>商品数量</td>
			<td>商品小计</td>
			<td></td>
		</tr>
		<%int total=0; %>
		<c:forEach items="${ois}" var="oi" varStatus="st">
			<tr>
				<td>${oi.product.name }</td>
				<td>${oi.product.price }</td>
				<td>${oi.num }</td>
				<td>${oi.product.price*oi.num }</td>
				<td><a href="OrderItemDeleteServlet?pid=${oi.product.id}">删除</a></td>
			</tr>
		</c:forEach>
		
		<c:if test="${!empty ois }">
			<tr>
				<td colspan="4" align="right">
					<a href="OrderCreateServlet">生成订单</a>
				</td>
			</tr>
		</c:if>
	</table>
</center>
</body>
</html>