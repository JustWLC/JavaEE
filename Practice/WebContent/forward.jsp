<%@page import="java.util.Date"%>
<%@page import="java.text.SimpleDateFormat"%>
<%
	Date date=(Date)request.getAttribute("date");
%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Forward跳转</title>
<link rel='stylesheet' type='text/css' href='<%= request.getContextPath() %>/css/style.css'>
<style type="text/css">
/**{
	margin: 0px;
	padding: 0px;
}
#line{
	width: 900px;
	font-size: 20px;
	font-style: bold;
}
.button{
	width: 60px;
	font-family: 30px;
	height: 35px;
	color: #fff;
	background: #69b946;
}*/
</style>
</head>
<body>
<div align="center">
<br>
<fieldset style="width: 90%">
	<legend>Forward跳转</legend>
	<br>
	<div style="line">
		<div>从ForwardServlet中取到的Data为</div>
		<div><%=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss:SSS").format(date) %></div>
	</div>
	<br>
	<div style="line">
	
			<input type="button" onclick='location"<%= request.getContextPath() %>/servlet/ForwardServlet?destination=servlet";' value="跳转到servlet" class="button">
			<input type="button" onclick='location"<%= request.getContextPath() %>/servlet/ForwardServlet?destination=file";' value="跳转到web.xml" class="button">
			<input type="button" onclick='location"<%= request.getContextPath() %>/servlet/ForwardServlet?destination=jsp";' value="跳转到JSP" class="button">
	
	</div>
</fieldset>
</div>
</body>
</html>