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
		 
		//�������ݿ�
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
				//�Ƿ���¼
				//���session��û���û���Ϣ���ٿ���cookie����û���û���Ϣ
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
						//��loginCLȥ��֤
						response.sendRedirect("LoginCL?username="+name+"&passwd="+passwd);
						//return;
					}
				}
					response.sendRedirect("Login?info=error1");
					return;		
			}
			
			
			
			//��Servlet����ʾͼƬ
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
			
			  //---------------�����ҳ���ʹ���------------------------------
		  /*    FileReader f=new FileReader("D:\\eclipse ee\\mycomputer.txt");		
		      BufferedReader br=new BufferedReader(f);
		      String numval=br.readLine();
		      br.close();
		      int times=Integer.parseInt(numval);*/
			//===============��ҳ����===========================
			int pagesize=4;//һҳ��ʾ3����¼
			int pageNow=1;//ϣ����ʾ�ڼ�ҳ
			int top=0;     //��һҳ
			int bottom=2;   //��һҳ
            String spageNow=request.getParameter("pageNow");			
			//��̬�Ľ���pageNow
       
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
          

			//����UserBeanCL
			UserBeanCL ubc=new UserBeanCL();
			ArrayList  al=ubc.getResultbyPage(pageNow, pagesize);
		    pw.println("<table border=1 align='center' bordercolor:#A0F5CE>");
		    pw.println("<tr bgcolor='#50A0E8'><th>id</th><th>name</th><th>password</th><th>email</th><th>grade</th><th>�޸��û�</th><th>ɾ���û�</th></tr>");
            for(int i=0;i<al.size();i++){
            	UserBean ub=(UserBean)al.get(i);
		    	pw.println("<tr >");
		    	pw.println("<td >"+ub.getUserId()+"</td>");
		    	pw.println("<td >"+ub.getUsername()+"</td>");
		    	pw.println("<td >"+ub.getPasswd()+"</td>");
		    	pw.println("<td >"+ub.getEmail()+"</td>");
		    	pw.println("<td >"+ub.getGrade()+"</td>");
		    	pw.println("<td ><a href=Update?UId="+ub.getUserId()+"&UName="+ub.getUsername()+"&UPasswd="+ub.getPasswd()+"&UEmail="+ub.getEmail()+"&UGrade="+ub.getGrade()+">�޸�</a></td>");
		    	pw.println("<td ><a href=DelUserCL?userId="+ub.getUserId()+" onclick=\"return window.confirm('�Ƿ�ȷ��ɾ����')\">ɾ��</a></td>");
		    	pw.println("</tr>");
		    }
		    pw.println("</table>");
		  
		 //��һҳ
		   if (top==0) {
			   pw.print("<a href=Wel?pageNow=1>��һҳ</a>");
		   }else{
		       pw.print("<a href=Wel?pageNow="+top+">��һҳ</a>");
		       }
		  //��ҳ��ʾ��ǩ
		   int pageCount=ubc.getpageCount();
		   if (Integer.parseInt(spageNow)<=pageCount)
		{
			   for(int i=Integer.parseInt(spageNow);i<=Integer.parseInt(spageNow)+4&i<=pageCount;i++){
			       pw.println("<a href=Wel?pageNow="+i+">"+i+"</a>");
			    }
		}else{
			 pw.println("<a href=Wel?pageNow="+pageCount+">"+pageCount+"</a>");
		}
		    
		  //��һҳ
		 	 if (bottom>=pageCount+1){
			   pw.print("<a href=Wel?pageNow="+pageCount+">��һҳ</a>");
			}else{
			   pw.print("<a href=Wel?pageNow="+bottom+">��һҳ</a><br>");
			   }
		 	 
		 	 pw.println("<form action=Wel>");
		 	 pw.println("<input type=text name=pageNow>");
		 	 pw.println("<input type=submit value=go");
		     pw.println("</from>");
			//���ص�Loginҳ��  
			pw.println("<br><a href=Login>�������µ�¼</a><br>");
			
            //pw.println("����ҳ��������"+this.getServletContext().getAttribute("visitTimes").toString()+"��<br>");
            pw.println("����������ַΪ��"+request.getRemoteAddr()+"<br>");
            pw.println("���Ļ�����Ϊ��"+request.getRemoteHost());
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
