package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;



import bean.Product;
import util.DButil;

public class ProductDao
{ 
	
	
	public List<Product> listproduct()throws SQLException{
		List<Product> products=new ArrayList<Product>();
		Connection c=DButil.getConnection();
		PreparedStatement ps=null;
		ResultSet rs=null;
		try
		{
		   String sql="select * from product";
		    ps=c.prepareStatement(sql);
		    rs=ps.executeQuery();
		   
		   while(rs.next()){
			   Product product=new Product();
			
			   product.setId(rs.getInt("id"));
			   product.setName(rs.getString("name"));
			   product.setPrice(rs.getFloat("price"));
			   products.add(product);
		   }
		 
		   
		} finally
		{
			// TODO: handle finally clause
			DButil.close(rs, ps, c);
		}
		return products;
	}
	
	public Product getproduct(int id)throws SQLException{
		Product  result=null;
		Connection c=DButil.getConnection();
		PreparedStatement ps=null;
		ResultSet rs=null;
		try
		{
			String sql="select * from product where id=?";
			ps=c.prepareStatement(sql);
			ps.setInt(1, id);
			rs=ps.executeQuery();
			if (rs.next())
			{
				result=new Product();
				result.setId(id);
				
				String name=rs.getString(2);
				Float price=rs.getFloat(3);
				
				result.setName(name);
				result.setPrice(price);
			}
			
		} finally
		{
			// TODO: handle finally clause
			DButil.close(rs, ps, c);
		}
		
		return result;
	}
}
