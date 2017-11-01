package com.ss;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;


//这是一个处理类（处理users）<------->操作userBean
public class UserBeanCL
{
//业务逻辑
	private Connection ct=null;
	private PreparedStatement ps=null;
	private ResultSet rs=null;
	private int pageCount=0;
	
	public int getpageCount(){
		return this.pageCount;
	}
	
//分页显示
public ArrayList getResultbyPage(int pageNow,int pagesize){
	ArrayList al=new ArrayList();
	try{
	int rowCount=0;//一共有几条记录
    
	ConnDB cd=new ConnDB();
	ct=cd.getConn();
	ps=ct.prepareStatement("select count(*) from users");
	rs=ps.executeQuery();
	if (rs.next())
	{
		rowCount=rs.getInt(1);
	}
	 //计算pagecount
	 if (rowCount%pagesize==0)
	{
		 pageCount=rowCount/pagesize;
	}
	 else{
		 pageCount=rowCount/pagesize+1;
	 }
	 
    //构建表格
	ps=ct.prepareStatement("select * from users limit "+pageNow+","+pagesize+";");
    rs=ps.executeQuery();
    while(rs.next()){
    	//将rs中的每条记录封装到UserBean中
    	UserBean ub=new UserBean();
    	ub.setUserId(rs.getInt(1));
    	ub.setUsername(rs.getString(2));
    	ub.setPasswd(rs.getString(3));
    	ub.setEmail(rs.getString(4));
    	ub.setGrade(rs.getInt(5));;
    	al.add(ub);
    }
    }
catch (Exception e) {
	// TODO: handle exception
	e.printStackTrace();
}finally {
	this.close();
}
	return al;
	}

//验证用户
	public boolean checkUser(String u,String p){
		boolean b=false;
		try
		{
			//得到连接
		ConnDB cd=new ConnDB();
		ct=cd.getConn();
		ps=ct.prepareStatement("select * from users where username='"+u+"'");
		rs=ps.executeQuery();
		if (rs.next())
		{
			String dbpasswd=rs.getString(2);
			if (dbpasswd.equals(p))
			{
				b=true;
			}
		}
		} catch (Exception e)
		{
			// TODO: handle exception
		}finally {
			this.close();
		}
		return b;
	}
//	删除用户
	public boolean delUser(String id){
		boolean b=false;
		try
		{
			ConnDB cd=new ConnDB();
			ct=cd.getConn();
			
			String sql="delete from users where userId='"+id+"'";
			ps=ct.prepareStatement(sql);
			int num=ps.executeUpdate();
			if(num==1){
				//删除成功
				b=true;	
			}
		} catch (Exception e)
		{
			e.printStackTrace();
		}finally{
			this.close();
		}
		return b;
	}
//	修改用户
	public boolean updateUser(String id,String email,String passwd,String grade){
		boolean b=false;
		try
		{
			ConnDB cd=new ConnDB();
			ct=cd.getConn();
			
			String sql="update users set passwd='"+passwd+"',email='"+email+"',grade='"+grade+"' where userId='"+id+"'";
			ps=ct.prepareStatement(sql);
			int num=ps.executeUpdate();
			if(num==1){
				b=true;	
			}
		} catch (Exception e)
		{
			e.printStackTrace();
		}finally{
			this.close();
		}
		return b;
	}
	public void close(){
		try
		{
			if (rs!=null)
			{
				rs.close();
				rs=null;
			}
			if (ps!=null)
			{
				ps.close();
				ps=null;
			}
			if (ct!=null)
			{
				ct.close();
				ct=null;
			}
		} catch (Exception e1)
		{
			e1.printStackTrace();
		}
	}
}
