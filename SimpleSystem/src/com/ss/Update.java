package com.ss;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Update
 */
@WebServlet("/Update")
public class Update extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Update() {
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
			pw.println("div{position:absolute;width:100%;height:100%}");
			pw.println("div.image{background-image:url("+request.getContextPath()+"/imgs/update.png);}");
			pw.println("a{text-decoration:none;}");
			pw.println("</style>");
			pw.println("<center>");
			pw.println("<body link='#FFFFFF' alink='#FFFFFF' vlink='#FFFFFF' >");
			pw.println("<div class='image'>");
			pw.print("<h1>修改界面<h1>");
			pw.println("<form action=UpdateCL>");
			pw.println("<table border=1>");
			pw.println("<tr><td>ID</td><td><input readonly type=text name=uId value="+request.getParameter("UId")+"></td></tr>");
			pw.println("<tr><td>Name</td><td><input readonly type=text value="+request.getParameter("UName")+"></td></tr>");
			pw.println("<tr><td>Password</td><td><input type=text name=upasswd value="+request.getParameter("UPasswd")+"></td></tr>");
			pw.println("<tr><td>Email</td><td><input type=text name=uemail value="+request.getParameter("UEmail")+"></td></tr>");
			pw.println("<tr><td>Grade</td><td><input type=text name=ugrade value="+request.getParameter("UGrade")+"></td></tr>");
			pw.println("<tr align=center><td colspan=2><input type=submit value=修改></td></tr>");
			pw.println("</table>");
			pw.println("</form>");
			pw.println("</div>");
	        pw.println("</div>");
			pw.println("</body>");
			pw.println("</center>"); 
			pw.println("</html>");}
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
