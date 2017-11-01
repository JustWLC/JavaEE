<%@ page language="java" contentType="text/html; utf-8"
    pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
<style type="text/css">
	div {
	float: left;
	padding:3px;
	width: 250px;
	text-align: center;
	border: 1px solid #000000;
}
</style>
</head>
<body>
<c:forEach var="num" begin="2" end="100" step="2">
	<div>	${num}
	<c:if test="${num }%10==0"><br></c:if>
	</div>
		
</c:forEach>
</body>
</html>