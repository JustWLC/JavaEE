package com.ss;

import java.io.IOException;
import java.io.PrintWriter;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Login
 */
@WebServlet("/Login")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Login() {
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
	        //���ص�¼����
		    pw.println("<html>");
			pw.println("<meta http-equiv='Content-Type' content='text/html'; charset=UTF-8 >");
			pw.println("<style type='text/css'>");
			pw.println("div{position:relative;top=50px;width:100%;height:100%;}");
			pw.println("div.image{background-image:url("+request.getContextPath()+"/imgs/f.jpg);background-repeat:no-repeat;background-position:left;}");
			pw.println("div.right{margin-left:900px;border=1;}");
			pw.println("</style>");
			//pw.println("<center>");
			pw.println("<body>");
			pw.println("<div class='image'>");
			
	       // pw.println("<body background='"+request.getContextPath()+"/imgs/f.jpg'; topmargin=30px");
	     
	        //�õ�error��Ϣ
	        String ifo=(String)request.getParameter("info");
	      
	       
	        if(ifo!=null){
	        	pw.println("<h2><marquee behavior='alternate'>�����û������������!</marquee></h2><br>");
	        }
	      
	        pw.println("<br>");
	        pw.println("<br>");
	        pw.println("<br>");
	        pw.println("<br>");
	        pw.println("<br>");
	        pw.println("<br>");
	        pw.println("<br>");
	        pw.println("<div class='right'>");
			pw.println("<h1>&nbsp;&nbsp;&nbsp;&nbsp;��¼����</h1>");
			pw.println("<form action=LoginCL method=post>");
			pw.println("�û���:<input type=text name=username><br>");
			pw.println("<br>");
			pw.println("��  �룺<input type=password name=passwd><br>");
			pw.println("&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input type=checkbox name=keep value=2>�����ڲ������µ�¼<br>");
			pw.println("&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input type=submit value=��¼>          <br>");
			pw.println("</form>");
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
