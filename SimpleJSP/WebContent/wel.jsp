<%@page import="com.model.ConnDB"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.model.UserBeanCL"%>
<%@page import="com.model.UserBean"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@page import="java.sql.*"%>
<%@ page import="com.mysql.jdbc.Driver" %> 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<center>
<%
if(session.getAttribute("myname")==null){
	response.sendRedirect("login.jsp");
	return;
}
%>
welcome!&nbsp;&nbsp;&nbsp;&nbsp;<%=session.getAttribute("myname") %><br>
<hr>
<a href="login.jsp"> 返回重新登录</a>
<h1>用户信息列表</h1>
<%
   //定义四个变量
   int pageSize;
   int pageCount;
   int pageNow=1;
   int top=0;
   int bottom=2;
 
 
   String spageNow=request.getParameter("pageNow");	
   ArrayList al=(ArrayList)request.getAttribute("result");
   String s_pagecount=(String)request.getAttribute("pageCount");
   pageCount=Integer.parseInt(s_pagecount);
   
   String s_pagesize=(String)request.getAttribute("pageSize");
   pageSize=Integer.parseInt(s_pagesize);

	//动态的接收pageNow

	if (spageNow!=null)
	{
		top=Integer.parseInt(spageNow)-1;
		bottom=top+2;
	}
	else{
		spageNow=("1");
	}
	
%>
   <table border="1">
   <tr><td>用户ID</td><td>用户名</td><td>密码</td><td>电邮</td><td>级别</td></tr>
   <%
   for(int i=0;i<al.size();i++){
	   UserBean ub=(UserBean)al.get(i);
	   %>
	   
	   <tr>
	   <td><%=ub.getUserId() %></td>
	   <td><%=ub.getUsername()%></td>
	   <td><%=ub.getPasswd() %></td>
	   <td><%=ub.getEmail() %></td>
	   <td><%=ub.getGrade() %></td>
	   <%
   }
   %>
   </table>
  
   <%
   //显示超链接
    if (top==0) {
			   out.print("<a href=UsersCLServlet?pageNow=1>上一页</a>");
		   }else{
		       out.print("<a href=UsersCLServlet?pageNow="+top+">上一页</a>");
		       }
		  //分页显示标签
		   if (Integer.parseInt(spageNow)<=pageCount)
		{
			   for(int i=Integer.parseInt(spageNow);i<=Integer.parseInt(spageNow)+2&i<=pageCount;i++){
			       out.println("<a href=UsersCLServlet?pageNow="+i+">["+i+"]</a>");
			      }
		}else{
			 out.println("<a href=UsersCLServlet?pageNow="+pageCount+">"+pageCount+"</a>");
		}
		    
		  //下一页
		 	 if (bottom>=pageCount+1){
			   out.print("<a href=UsersCLServlet?pageNow="+pageCount+">下一页</a>");
			}else{
			   out.print("<a href=UsersCLServlet?pageNow="+bottom+">下一页</a><br>");
			   }
   %>
</center>
</body>
</html>