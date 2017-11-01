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
	//������������Ҫ�ı���  
    private static Connection con = null;  
    private static PreparedStatement ps = null;  
    private static ResultSet rs = null;  
      
    //�����������ݿ�����Ҫ�Ĳ���  
   private static String url = "jdbc:mysql://localhost:3306/cart?useUnicode=true&amp;characterEncoding=UTF-8";  
    private static String username = "root";  
    private static String driver="com.mysql.jdbc.Driver";  
    private static String password="987654321";  
 
      
   
    /** 
     * �������� 
     */  
    static {  
    	 try{
  		   System.out.println("�������ӳɹ�");
  		  Class.forName(driver); 
  		
  	   }catch (Exception e) {
  		// TODO: handle exception
  		   System.out.println("��������ʧ�ܣ�");  
             e.printStackTrace();  
  	   }
              
    }  
      
    /** 
     * �õ�Connection���� 
     * @return Connection 
     */  

    public static Connection getConnection() {  
          
        try {  
            //��������  
            con = DriverManager.getConnection(url, username, password);  
              
        } catch (Exception e) {  
            System.out.println("���ݿ�����ʧ�ܣ�");  
            e.printStackTrace();  
        }  
          
        return con;  
    }  
      
    /** 
     * ͳһ����Դ�رպ��� 
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
