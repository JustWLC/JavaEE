<%@page import="java.util.ArrayList"%>
<%@page import="com.helloween.Person"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
<style type="text/css">
.title{
	background-color: #FFFF00;
	text-align: center;
}
</style>
</head>
<body>
<%
	List<Person> personlist=new ArrayList<Person>();

	Person person=new Person();
	person.setId(1);
	person.setName("吕蒙");
	person.setAge(19);
	person.setSex("男");
	person.setCity("吴");
	person.setAddress("吴国建邺");
	person.setTelephone("0000 0000");
	personlist.add(person);
	
	Person person2=new Person();
	person2.setId(2);
	person2.setName("陆逊");
	person2.setAge(22);	
	person2.setSex("男");
	person2.setCity("吴");
	person2.setAddress("吴国建邺西");
	person2.setTelephone("0000 0001");
	personlist.add(person2);
	request.setAttribute("personlist", personlist);
%>

<table width="500px" border="0" cellpadding="0" cellspacing="1">
	<tr class="title">
		<td>编号</td>
		<td>姓名</td>
		<td>年龄</td>
		<td>性别</td>
		<td>国籍</td>
		<td>居住地</td>
		<td>军籍号</td>
	</tr>
	<c:forEach items="${personlist }" var="person">
		<tr align="center">
			<td>${ person.id }</td>
			<td>${ person.name }</td>
			<td>${ person.age }</td>
			<td>${ person.sex }</td>
			<td>${ person.city }</td>
			<td>${ person.address }</td>
			<td>${ person.telephone }</td>	
		</tr>
	</c:forEach>
</table>
</body>
</html>