package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import bean.Order;
import util.DButil;

public class OrderDao
{
	public void insert(Order o)throws SQLException{
		
		
		Connection con=DButil.getConnection();
		PreparedStatement ps=null;
		ResultSet rs=null;
		
		try
		{
			System.out.println("OrderDao");
			String sql="insert into order_ (uid)values (?)";
		
			ps=con.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);
			ps.setInt(1, o.getUser().getId());
			ps.executeUpdate();
			rs=ps.getGeneratedKeys();
			if (rs.next())
			{
				int id=rs.getInt(1);
				o.setId(id);
			}
			
			
		} finally
		{
			// TODO: handle finally clause
			DButil.close(rs, ps, con);
		}
	}
}
