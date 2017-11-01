package com.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;



public class UserBeanCL
{
	private Connection ct=null;
	private PreparedStatement ps=null;
	private ResultSet rs=null;
	private int pageCount=0;
	private int rowCount=0;
	private int pageSize=3;
 
//返回pageSize
	public int pageSize(){
		return pageSize;
	}
//返回pageCount
	public int pageCount(){
		try
		{
			ConnDB cd=new ConnDB();
			ct=cd.getConnection();
			ps=ct.prepareStatement("select count(*) from users");
			rs=ps.executeQuery();
			if (rs.next())
			{
				rowCount=rs.getInt(1);
			} 
			if (rowCount%pageSize==0)
			{
				pageCount=rowCount/pageSize;
			}else{
				pageCount=rowCount/pageSize+1;
			}
		} catch (Exception e)
		{
			e.printStackTrace();
		}finally {
			this.close();
		}
		
		return pageCount;
	}
	
	//分页显示
public ArrayList getResultPage(int pageNow){
	int pagenow=0;
	pagenow=pageSize*(pageNow-1);
	ArrayList al=new ArrayList();
	try
	{
		
		ConnDB cd=new ConnDB();
		ct=cd.getConnection();
		ps=ct.prepareStatement("select count(*) from users");
		rs=ps.executeQuery();
		//构建表格
		ps=ct.prepareStatement("select * from users limit "+pagenow+","+pageSize+";");
		rs=ps.executeQuery();
		while(rs.next()){
			UserBean ub=new UserBean();
			ub.setUserId(rs.getInt(1));
			ub.setUsername(rs.getString(2));
			ub.setPasswd(rs.getString(3));
			ub.setEmail(rs.getString(4));
			ub.setGrade(rs.getInt(5));
			al.add(ub);
		}
	} catch (Exception e)
	{
		e.printStackTrace();
	}
	finally {
		this.close();
	}
	return al;
}

//验证用户
public boolean checkUser(String u,String p){
	
	boolean b=false;
	try
	{
	ConnDB cd=new ConnDB();
	ct=cd.getConnection();
	ps=ct.prepareStatement("select * from users where username='"+u+"'");
	rs=ps.executeQuery();
	if (rs.next())
	{
		String dpasswd=rs.getString(2);
		if (dpasswd.equals(p))
		{
			b=true;
		}
	}
	} catch (Exception e)
	{
		e.printStackTrace();
	}
	finally {
		this.close();
	}
	return b;
}




//关闭资源函数
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
