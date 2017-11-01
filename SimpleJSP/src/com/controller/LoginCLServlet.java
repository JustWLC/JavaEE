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
 * Servlet implementation class LoginCLServlet
 */
@WebServlet("/LoginCLServlet")
public class LoginCLServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginCLServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//�õ��û���������
		String u=request.getParameter("username");
		String p=request.getParameter("passwd");
		
		
		//ʹ��ģ�ͣ�UserBeanCL�� ��ɶ��û�����֤
		//1.����һ��UserBeanCl����
		  //���ö���
		UserBeanCL ubc=new UserBeanCL();
		if(ubc.checkUser(u, p)){
			ArrayList al=ubc.getResultPage(1);
			int pageCount=ubc.pageCount();
			int pageSize=ubc.pageSize();
			request.setAttribute("result", al);
			request.setAttribute("pageCount", pageCount+"");
			request.setAttribute("pageSize", pageSize+"");
			//���û�������session�Ա�����
			request.getSession().setAttribute("myname", u);
			request.getSession().setMaxInactiveInterval(600);
			request.getRequestDispatcher("wel.jsp?uname="+u).forward(request, response);
		}else {
			request.getRequestDispatcher("login.jsp").forward(request, response);
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
