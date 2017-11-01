<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
<style type="text/css">
.ff{
	background: url("imgs/e.jpg");
}
.submit{
	width: 50px; 
	height: 28px;
	font: bold 18px/1.5 simsun;
	background: #69b946;
	color: #fff;
	border: none;
}
</style>
</head>
	<body >
		<center>
		<div align="center" style="width: 500px;height: 800px;" class="ff" >
			 <form action="UserLoginServlet" method="post">
			 	<fieldset style="width: 480px;height: 600px;">
			 		<legend>登录系统</legend>
			 		<table style="padding-top: 260px; padding-right: 270px;">
			 			<tr>
			 				<td align="right">用户名：</td>
			 				<td><input type="text" name="name"/></td>
			 			</tr>
			 			
			 			<tr>
			 				<td align="right">密&nbsp;&nbsp;&nbsp;&nbsp;码：</td>
			 				<td><input type="password" name="password"/></td>
			 			</tr>
			 			<tr>
			 			<td></td>
			 			<td align="center"><input type="submit" value="提交" class="submit"/></td>
			 			</tr>
			 		</table>
			 	</fieldset>
			 </form>
		</div>
		</center>
	</body>
</html>