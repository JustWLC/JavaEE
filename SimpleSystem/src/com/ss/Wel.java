package com.ss;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class Wel
 */
@WebServlet("/Wel")
public class Wel extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Wel() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	    
		response.setContentType("text/html;UTF-8");
		response.setCharacterEncoding("gbk");
		request.setCharacterEncoding("gbk");
		 
		//连接数据库
		Connection con=null;
		ResultSet rs=null;
		Statement sm=null;
		PreparedStatement ps=null;
		PrintWriter pw=response.getWriter();
		
		
		try{
			HttpSession hs=request.getSession(true);
			String myname=(String)hs.getAttribute("uname");
			String name="";
			String passwd="";
			if(myname==null){
				//非法登录
				//如果session中没有用户信息，再看看cookie中有没有用户信息
				Cookie []allcookies=request.getCookies();
				int i=0;
				if (allcookies!=null)
				{
					for ( i = 0; i < allcookies.length; i++)
					{
						Cookie temp=allcookies[i];
						if (temp.getName().equals("myname"))
						{
							 name=temp.getValue();
						}else if(temp.getName().equals("mypasswd")){
                              passwd=temp.getValue();
						}
					}
					if (!name.equals("")&&!passwd.equals(""))
					{
						//到loginCL去验证
						response.sendRedirect("LoginCL?username="+name+"&passwd="+passwd);
						//return;
					}
				}
					response.sendRedirect("Login?info=error1");
					return;		
			}
			
			
			
			//在Servlet中显示图片
			 pw.println("<html>");
				pw.println("<meta http-equiv='Content-Type' content='text/html'; charset=UTF-8 >");
				pw.println("<style type='text/css'>");
				pw.println("div{position:relative;width:100%;height:100%;}");
				pw.println("div.imag{background-image:url("+request.getContextPath()+"/imgs/3.png);}");
				pw.println("a{text-decoration:none;text-color:#FFFFFF}");
				pw.println("</style>");
            pw.println("<center>");
           pw.println("<body >");
           pw.println("<div class='imag'>");
			pw.print("<img src='"+request.getContextPath()+"/imgs/1.gif' width='200' hight='50' ><br>");
			pw.print("welcome!Hello " + myname );
			
			  //---------------添加网页访问功能------------------------------
		  /*    FileReader f=new FileReader("D:\\eclipse ee\\mycomputer.txt");		
		      BufferedReader br=new BufferedReader(f);
		      String numval=br.readLine();
		      br.close();
		      int times=Integer.parseInt(numval);*/
			//===============分页功能===========================
			int pagesize=4;//一页显示3条记录
			int pageNow=1;//希望显示第几页
			int top=0;     //上一页
			int bottom=2;   //下一页
            String spageNow=request.getParameter("pageNow");			
			//动态的接收pageNow
       
			if (spageNow!=null)
			{
				pageNow=pagesize*(Integer.parseInt(spageNow)-1);
				top=pageNow/pagesize;
				bottom=top+2;
			}
			else{
				spageNow=("1");
				pageNow=0;
			}
          

			//调用UserBeanCL
			UserBeanCL ubc=new UserBeanCL();
			ArrayList  al=ubc.getResultbyPage(pageNow, pagesize);
		    pw.println("<table border=1 align='center' bordercolor:#A0F5CE>");
		    pw.println("<tr bgcolor='#50A0E8'><th>id</th><th>name</th><th>password</th><th>email</th><th>grade</th><th>修改用户</th><th>删除用户</th></tr>");
            for(int i=0;i<al.size();i++){
            	UserBean ub=(UserBean)al.get(i);
		    	pw.println("<tr >");
		    	pw.println("<td >"+ub.getUserId()+"</td>");
		    	pw.println("<td >"+ub.getUsername()+"</td>");
		    	pw.println("<td >"+ub.getPasswd()+"</td>");
		    	pw.println("<td >"+ub.getEmail()+"</td>");
		    	pw.println("<td >"+ub.getGrade()+"</td>");
		    	pw.println("<td ><a href=Update?UId="+ub.getUserId()+"&UName="+ub.getUsername()+"&UPasswd="+ub.getPasswd()+"&UEmail="+ub.getEmail()+"&UGrade="+ub.getGrade()+">修改</a></td>");
		    	pw.println("<td ><a href=DelUserCL?userId="+ub.getUserId()+" onclick=\"return window.confirm('是否确认删除？')\">删除</a></td>");
		    	pw.println("</tr>");
		    }
		    pw.println("</table>");
		  
		 //上一页
		   if (top==0) {
			   pw.print("<a href=Wel?pageNow=1>上一页</a>");
		   }else{
		       pw.print("<a href=Wel?pageNow="+top+">上一页</a>");
		       }
		  //分页显示标签
		   int pageCount=ubc.getpageCount();
		   if (Integer.parseInt(spageNow)<=pageCount)
		{
			   for(int i=Integer.parseInt(spageNow);i<=Integer.parseInt(spageNow)+4&i<=pageCount;i++){
			       pw.println("<a href=Wel?pageNow="+i+">"+i+"</a>");
			    }
		}else{
			 pw.println("<a href=Wel?pageNow="+pageCount+">"+pageCount+"</a>");
		}
		    
		  //下一页
		 	 if (bottom>=pageCount+1){
			   pw.print("<a href=Wel?pageNow="+pageCount+">下一页</a>");
			}else{
			   pw.print("<a href=Wel?pageNow="+bottom+">下一页</a><br>");
			   }
		 	 
		 	 pw.println("<form action=Wel>");
		 	 pw.println("<input type=text name=pageNow>");
		 	 pw.println("<input type=submit value=go");
		     pw.println("</from>");
			//返回到Login页面  
			pw.println("<br><a href=Login>返回重新登录</a><br>");
			
            //pw.println("该网页被访问了"+this.getServletContext().getAttribute("visitTimes").toString()+"次<br>");
            pw.println("您的主机地址为："+request.getRemoteAddr()+"<br>");
            pw.println("您的机器名为："+request.getRemoteHost());
            pw.println("<imag/>");
            pw.println("</body>");
			pw.println("</center>");
		
		}catch(Exception e){
			e.printStackTrace();
		}
		}
 
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
