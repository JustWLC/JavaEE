package com.model;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConnDB
{
private Connection ct=null;
public Connection getConnection(){
	try
	{
		Class.forName("com.mysql.jdbc.Driver");
		ct=DriverManager.getConnection("jdbc:mysql://localhost:3306/spdb", "root", "987654321");
	} catch (Exception e)
	{
		e.printStackTrace();
	}
	    return ct;
}
}
