package com.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.model.UserBeanCL;

/**
 * Servlet implementation class UsersCLServlet
 */
@WebServlet("/UsersCLServlet")
public class UsersCLServlet extends HttpServlet {
	
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		//得到用户希望显示的pageNow
		String s_pageNow=request.getParameter("pageNow");
		try
		{
			int pageNow=Integer.parseInt(s_pageNow);
			//调用UserBeanCL
			UserBeanCL ubc=new UserBeanCL();
			ArrayList al=ubc.getResultPage(pageNow);
			int pageCount=ubc.pageCount();
			int pageSize=ubc.pageSize();
			request.setAttribute("result", al);
			request.setAttribute("pageCount", pageCount+"");
			request.setAttribute("pageSize", pageSize+"");
			
			request.getRequestDispatcher("wel.jsp").forward(request, response);
		} catch (Exception e)
		{
			// TODO: handle exception
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
