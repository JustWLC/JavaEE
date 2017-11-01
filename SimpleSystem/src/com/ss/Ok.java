package com.ss;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Ok
 */
@WebServlet("/Ok")
public class Ok extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Ok() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;UTF-8");
		response.setCharacterEncoding("gbk");
		PrintWriter pw=response.getWriter();
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
	        pw.println("<h1>操作成功！</h1>");
	        pw.println("<br><br>");
	        pw.println("<a href=MainPage>返回主页</a>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<a href=Wel>继续执行</a>");
	        pw.println("</div>");
	        pw.println("</body>");
	        pw.println("</center>");
	        pw.println("</html>");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
