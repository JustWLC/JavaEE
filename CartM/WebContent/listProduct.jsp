<%@page import="dao.ProductDao"%>
<%@page import="bean.Product"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
</head>
<body style="text-align: center;">
	<c:if test="${!empty user}">
		<div align="center">
		  当前用户: ${user.name}
		</div>
	</c:if>
<table align='center' border='1' cellspacing='0'>
 <!-- <%  List<Product> products=(List)request.getAttribute("products");
  %>-->
  
    <tr>
        <td>id</td>
        <td>名称</td>
        <td>价格</td>
        <td>购买</td>
    </tr>
    
  <!--<%
    for(int i=0;i<products.size();i++){
    	Product p=(Product)products.get(i);
        %>
            <tr>
            <td><%=p.getId() %></td>
			<td><%=p.getName() %></td>
			<td><%=p.getPrice() %></td>
			<td></td>
			</tr>
			<%} %> -->
    <c:forEach items="${products}" var="product" varStatus="st">
        <tr>
            <td>${product.id}</td>
            <td>${product.name}</td>
            <td>${product.price}</td>
            <td>
             
            <form action="OrderItemAddServlet" method="post">
             
            数量<input type="text" value="1" name="num">
            <input type="hidden" name="pid" value="${product.id}">
            <input type="submit" value="购买">
            </form>
              </td>
        </tr>
    </c:forEach>
</table>
</body>
</html>