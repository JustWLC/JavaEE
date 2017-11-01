package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import bean.OrderItem;
import util.DButil;

public class OrderItemDao
{
	public void insert(OrderItem oItem)throws SQLException{
		Connection con=DButil.getConnection();
		PreparedStatement ps=null;
		ResultSet rs=null;
		try
		{
			System.out.println("OrderItemDao");
			String sql="insert into orderitem values(null,?,?,?)";
			ps=con.prepareStatement(sql);
			ps.setInt(1, oItem.getProduct().getId());
			ps.setInt(2, oItem.getNum());
			ps.setInt(3, oItem.getOrder().getId());
			
			ps.execute();
		} finally
		{
			// TODO: handle finally clause
			DButil.close(rs, ps, con);
		}
	}
}
