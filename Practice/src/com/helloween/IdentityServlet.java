package com.helloween;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Random;

import javax.imageio.plugins.jpeg.JPEGImageReadParam;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;





/**
 * Servlet implementation class IdentityServlet
 */
@WebServlet("/IdentityServlet")
public class IdentityServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	
	//随机字符字典
    public static final char[] CHARS={'2','3','4','5','6','7','8','9','A','B','C','D','E','F','G'};
    
    //随机数
    public static Random random=new Random();
    
    //获取6位随机数
    public static String getRandomString(){
    	StringBuffer buffer=new StringBuffer();//字符串缓存
    	for(int i=0;i<6;i++){				   //循环6次
    		buffer.append(CHARS[random.nextInt(CHARS.length)]);//每次取一个字符数
    	}
    	return buffer.toString();
    }
    
    //获取随机的颜色
    public static Color getRandomColor(){
    	return new Color(random.nextInt(225),random.nextInt(225),random.nextInt(225));
    }
    
    //返回某颜色的反色
    public static Color getReverseColor(Color c){
    	return new Color(255-c.getRed(), 255-c.getGreen(), 255-c.getBlue());
    }
	
	
    public IdentityServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("image/jpeg");//设置输出类型
		
		String randomString=getRandomString();//随机字符串
		request.getSession(true).setAttribute("randomString", randomString);//放到session中
		
		int width=100;
		int height=30;
		
		Color color=getRandomColor();
		Color reverse=getReverseColor(color);//反色，用于前景色
		
		BufferedImage bi=new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);//创建一个彩色图片
		Graphics2D g=bi.createGraphics();//获取绘图对象
		g.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 16));
		g.setColor(color);
		g.fillRect(0, 0, width,height);//绘制背景
		g.setColor(reverse);
		g.drawString(randomString, 18, 20);//绘制随机字符
		for (int i = 0,n=random.nextInt(50); i < n; i++)
		{
			g.drawRect(random.nextInt(width), random.nextInt(height), 1, 1);
		}
		
		ServletOutputStream out=response.getOutputStream();
	/*	JPEGImageEncoder encoder=JPEGCodec.createJPEGEncoder(out);
		encoder.encode(bi);*/
		out.flush();
		
	
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
