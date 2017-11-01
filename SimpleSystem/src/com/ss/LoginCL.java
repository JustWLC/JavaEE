package com.ss;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


/**
 * Servlet implementation class LoginCL
 */
@WebServlet("/LoginCL")
public class LoginCL extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	public void init(){
		try
		{
			FileReader f=new FileReader("D:\\eclipse ee\\mycomputer.txt");		
		     BufferedReader br=new BufferedReader(f);
			 String numval=br.readLine();
			 this.getServletContext().setAttribute("visitTimes", numval);
			 br.close();
		} catch (Exception e)
		{
			e.printStackTrace();
		}
		
	}
	
	public void destroy(){
		 //再讲新的次数写回文件
		try
		{
			 FileWriter fw=new FileWriter("D:\\eclipse ee\\mycomputer.txt");		
			 BufferedWriter bw=new BufferedWriter(fw);
			 bw.write(this.getServletContext().getAttribute("visitTimes").toString());
			 bw.close();
		} catch (Exception e)
		{
			e.printStackTrace();
		}
		
	}
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginCL() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		PrintWriter pw=response.getWriter();
		 response.setContentType("text/html;gbk");
		 response.setCharacterEncoding("gbk");
	   	 request.setCharacterEncoding("gbk");
		 Connection con=null;
		 ResultSet rs=null;
		 Statement sm=null;
		
		//接收用户名和密码
		
		String u=request.getParameter("username");
		String p=request.getParameter("passwd");
		
			try{
		
			//调用UserbeanCL,1.创建一个对象
			UserBeanCL ubc=new UserBeanCL();
			//2.使用UserBeanCL的方法
			if(ubc.checkUser(u, p)){
				//合法
				//将验证成功的信息写入Session
				//1得到Session
	           // String dbpasswd=rs.getString(2);
	           
	            	String keep=request.getParameter("keep");
	            	if (keep!=null)
					{
	            	//将用户名和密码保存在客户端
	            	Cookie name=new Cookie("myname",u);
	            	Cookie pass=new Cookie("mypasswd",p);
	            	name.setMaxAge(3600);
	            	pass.setMaxAge(3600);
	            	response.addCookie(name);
	            	response.addCookie(pass);
					}	            	
	            	HttpSession hs=request.getSession(true);
					//修改Session的存在时间
					hs.setMaxInactiveInterval(20);
					hs.setAttribute("uname",u);
					response.sendRedirect("MainPage");
					//System.out.println((String)(hs.getAttribute("uname")));
					/*String times=this.getServletContext().getAttribute("visitTimes").toString();
					this.getServletContext().setAttribute("visitTimes", (Integer.parseInt(times)+1)+"");
					response.sendRedirect("MainpPage");
					 FileReader f=new FileReader("D:\\eclipse ee\\mycomputer.txt");		
				     BufferedReader br=new BufferedReader(f);
					 String numval=br.readLine();
					 br.close();
					 int times=Integer.parseInt(numval);
					 //增加一次
					  times++;
					 //再讲新的次数写回文件
					 FileWriter fw=new FileWriter("D:\\eclipse ee\\mycomputer.txt");		
					  BufferedWriter bw=new BufferedWriter(fw);
					  bw.write(times+"");
					  bw.close();*/
				
				}
	            else{
					response.sendRedirect("Login");
				}
			}
	            catch(Exception e){
			e.printStackTrace();
		}
	finally{
	         try {
	        	 if (rs!=null) {
	        		 rs.close();
				}
	        	 if (sm!=null) {
	        		 sm.close();
				}
				if (con!=null) {
					con.close();
				}
				
			} catch (Exception e2) {
				// TODO: handle exception
				e2.printStackTrace();
			}
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
