package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import bean.userbean;
import util.DButil;

public class UserDao
{
	public userbean getuser(String name,String password)throws SQLException{
		userbean result=null;
		Connection c=DButil.getConnection();
		PreparedStatement ps=null;
		ResultSet rs=null;
		try
		{
			String sql="select * from user where name=? and password=?";
			ps=c.prepareStatement(sql);
			ps.setString(1, name);
			ps.setString(2, password);
			rs=ps.executeQuery();
			if (rs.next())
			{
				result=new userbean();
				result.setId(rs.getInt(1));
				result.setName(name);
				result.setPassword(password);
				
			}
		} finally
		{
			// TODO: handle finally clause
			DButil.close(rs, ps, c);
		}
		
		return result;
	}
}
