package com.ss;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class MainPage
 */
@WebServlet("/MainPage")
public class MainPage extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MainPage() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;gbk");
		response.setCharacterEncoding("gbk");
		request.setCharacterEncoding("gbk");
		try{
			
			PrintWriter pw=response.getWriter();
	        //返回登录界面
		    pw.println("<html>");
			pw.println("<meta http-equiv='Content-Type' content='text/html'; charset=UTF-8 >");
			pw.println("<style type='text/css'>");
			pw.println("div{position:absolute;width:100%;height:100%;}");
			pw.println("div.image{background-image:url("+request.getContextPath()+"/imgs/1.png);}");
			pw.println("div.right{top:60px;text-align:center;text-color:white;}");
			pw.println("a{text-decoration:none;}");
			pw.println("</style>");
			pw.println("<body link='#FFFFFF' alink='#FFFFFF' vlink='#FFFFFF' >");
			pw.println("<div class='image'>");
			pw.println("<div class='right'>");
			pw.print("<h1>主界面<h1>");
			pw.println("<h3><a href=Wel >用户管理<a/></h3>");
			pw.println("<h3><a href=?>添加用户</a></h3>");
			pw.println("<h3><a href=?>查找用户</a></h3>");
			pw.println("<h3><a href=?>管理用户</a></h3>");
			pw.println("</div>");
	        pw.println("</div>");
			pw.println("</body>");
		
		//	 pw.println("</center>");
			 
			pw.println("</html>");
		}
		
		catch(Exception e){
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
