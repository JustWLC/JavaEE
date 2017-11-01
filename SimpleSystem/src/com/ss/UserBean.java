package com.ss;
//这是一个userbean<------>users表映射
//它的一个对象<----->users表的一条记录对应
public class UserBean
{
private int userId;
private String username;
private String passwd;
private String email;
private int grade;

public String getUsername()
{
	return username;
}
public void setUsername(String username)
{
	this.username = username;
}
public String getPasswd()
{
	return passwd;
}
public void setPasswd(String passwd)
{
	this.passwd = passwd;
}
public String getEmail()
{
	return email;
}
public void setEmail(String email)
{
	this.email = email;
}
public int getGrade()
{
	return grade;
}
public void setGrade(int grade)
{
	this.grade = grade;
}
public void setUserId(int userId){
	this.userId=userId;
}
public int getUserId(){
	return userId;
}
}
