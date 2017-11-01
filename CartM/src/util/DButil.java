package util;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Properties;

public class DButil
{
	//定义链接所需要的变量  
    private static Connection con = null;  
    private static PreparedStatement ps = null;  
    private static ResultSet rs = null;  
      
    //定义链接数据库所需要的参数  
   private static String url = "jdbc:mysql://localhost:3306/cart?useUnicode=true&amp;characterEncoding=UTF-8";  
    private static String username = "root";  
    private static String driver="com.mysql.jdbc.Driver";  
    private static String password="987654321";  
 
      
   
    /** 
     * 加载驱动 
     */  
    static {  
    	 try{
  		   System.out.println("驱动连接成功");
  		  Class.forName(driver); 
  		
  	   }catch (Exception e) {
  		// TODO: handle exception
  		   System.out.println("驱动加载失败！");  
             e.printStackTrace();  
  	   }
              
    }  
      
    /** 
     * 得到Connection链接 
     * @return Connection 
     */  

    public static Connection getConnection() {  
          
        try {  
            //建立连接  
            con = DriverManager.getConnection(url, username, password);  
              
        } catch (Exception e) {  
            System.out.println("数据库链接失败！");  
            e.printStackTrace();  
        }  
          
        return con;  
    }  
      
    /** 
     * 统一的资源关闭函数 
     * @param rs 
     * @param ps 
     * @param ct 
     */  
    public static void close(ResultSet rs,Statement ps, Connection con){  
          
        if(rs != null) {  
            try {  
                rs.close();  
            } catch (Exception e) {  
                e.printStackTrace();  
            }  
        }  
        if(ps != null) {  
            try {  
                ps.close();  
            } catch (Exception e) {  
                e.printStackTrace();  
            }  
        }  
        if(con != null) {  
            try {  
                con.close();  
            } catch (Exception e) {  
                e.printStackTrace();  
            }  
        }  
    }  
}
