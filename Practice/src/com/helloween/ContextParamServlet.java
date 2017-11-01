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
		
		response.setCharacterEncoding("UTF-8");//����response����
		response.setContentType("text/html");  //����response�������
		
		PrintWriter out=response.getWriter();//��ȡout����
		out.println("<!DOCTYPE html PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\">");
		out.println("<HTML>");
		out.println("<HEAD><TITLE>��ȡ�����Ĳ���</TITLE></HEAD>");
		//out.println("<link href='http://how2j.cn/study/css/bootstrap/3.3.6/bootstrap.min.css' type='text/css' rel='stylesheet'>");
		out.println("<BODY>");
		out.println("<div align=center><br/>");
		out.println("<fieldset style='width:90%'><legend>���е������Ĳ���</legend><br/>");
		
		ServletContext servletContext=getServletConfig().getServletContext();//��ȡ������
		String uploadFolder=servletContext.getInitParameter("upload folder");
		String allowedFileType=servletContext.getInitParameter("allowed file type");
		 
		out.println("<div class='line'>");
		out.print(" <div align='left' class='leftDiv'>�ϴ��ļ���</div>");
		out.println(" <div align='left' class='rightDiv'>" + uploadFolder + "</div>");
		out.println("</div>");
		
		out.println("<div class='line'>");
		out.print(" <div align='left' class='leftDiv'>ʵ�ʴ���·��</div>");
		out.println(" <div align='left' class='rightDiv'>" + servletContext.getRealPath(uploadFolder) + "</div>");
		out.println("</div>");
		
		out.print("<div class='line'>");
		out.print(" <div align='left' class='leftDiv'>�����ϴ�������</div>");
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
