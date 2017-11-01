package com.ss;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;


//����һ�������ࣨ����users��<------->����userBean
public class UserBeanCL
{
//ҵ���߼�
	private Connection ct=null;
	private PreparedStatement ps=null;
	private ResultSet rs=null;
	private int pageCount=0;
	
	public int getpageCount(){
		return this.pageCount;
	}
	
//��ҳ��ʾ
public ArrayList getResultbyPage(int pageNow,int pagesize){
	ArrayList al=new ArrayList();
	try{
	int rowCount=0;//һ���м�����¼
    
	ConnDB cd=new ConnDB();
	ct=cd.getConn();
	ps=ct.prepareStatement("select count(*) from users");
	rs=ps.executeQuery();
	if (rs.next())
	{
		rowCount=rs.getInt(1);
	}
	 //����pagecount
	 if (rowCount%pagesize==0)
	{
		 pageCount=rowCount/pagesize;
	}
	 else{
		 pageCount=rowCount/pagesize+1;
	 }
	 
    //�������
	ps=ct.prepareStatement("select * from users limit "+pageNow+","+pagesize+";");
    rs=ps.executeQuery();
    while(rs.next()){
    	//��rs�е�ÿ����¼��װ��UserBean��
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

//��֤�û�
	public boolean checkUser(String u,String p){
		boolean b=false;
		try
		{
			//�õ�����
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
//	ɾ���û�
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
				//ɾ���ɹ�
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
//	�޸��û�
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
