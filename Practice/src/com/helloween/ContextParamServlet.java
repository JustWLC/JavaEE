package com.helloween;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ContextParamServlet
 */
@WebServlet("/ContextParamServlet")
public class ContextParamServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ContextParamServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		response.setCharacterEncoding("UTF-8");//设置response编码
		response.setContentType("text/html");  //设置response输出类型
		
		PrintWriter out=response.getWriter();//获取out对象
		out.println("<!DOCTYPE html PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\">");
		out.println("<HTML>");
		out.println("<HEAD><TITLE>读取上下文参数</TITLE></HEAD>");
		//out.println("<link href='http://how2j.cn/study/css/bootstrap/3.3.6/bootstrap.min.css' type='text/css' rel='stylesheet'>");
		out.println("<BODY>");
		out.println("<div align=center><br/>");
		out.println("<fieldset style='width:90%'><legend>所有的上下文参数</legend><br/>");
		
		ServletContext servletContext=getServletConfig().getServletContext();//获取上下文
		String uploadFolder=servletContext.getInitParameter("upload folder");
		String allowedFileType=servletContext.getInitParameter("allowed file type");
		 
		out.println("<div class='line'>");
		out.print(" <div align='left' class='leftDiv'>上传文件夹</div>");
		out.println(" <div align='left' class='rightDiv'>" + uploadFolder + "</div>");
		out.println("</div>");
		
		out.println("<div class='line'>");
		out.print(" <div align='left' class='leftDiv'>实际磁盘路径</div>");
		out.println(" <div align='left' class='rightDiv'>" + servletContext.getRealPath(uploadFolder) + "</div>");
		out.println("</div>");
		
		out.print("<div class='line'>");
		out.print(" <div align='left' class='leftDiv'>允许上传的类型</div>");
		out.print(" <div align='left' class='rightDiv'>" + allowedFileType + "</div>");
		out.print("</div>");
		
		out.println("</fieldset></div>");
		out.println("</BODY>");
		out.println("</HTML");
		out.flush();
		out.close();	
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
