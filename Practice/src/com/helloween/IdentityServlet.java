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
    
	
	//����ַ��ֵ�
    public static final char[] CHARS={'2','3','4','5','6','7','8','9','A','B','C','D','E','F','G'};
    
    //�����
    public static Random random=new Random();
    
    //��ȡ6λ�����
    public static String getRandomString(){
    	StringBuffer buffer=new StringBuffer();//�ַ�������
    	for(int i=0;i<6;i++){				   //ѭ��6��
    		buffer.append(CHARS[random.nextInt(CHARS.length)]);//ÿ��ȡһ���ַ���
    	}
    	return buffer.toString();
    }
    
    //��ȡ�������ɫ
    public static Color getRandomColor(){
    	return new Color(random.nextInt(225),random.nextInt(225),random.nextInt(225));
    }
    
    //����ĳ��ɫ�ķ�ɫ
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
		
		response.setContentType("image/jpeg");//�����������
		
		String randomString=getRandomString();//����ַ���
		request.getSession(true).setAttribute("randomString", randomString);//�ŵ�session��
		
		int width=100;
		int height=30;
		
		Color color=getRandomColor();
		Color reverse=getReverseColor(color);//��ɫ������ǰ��ɫ
		
		BufferedImage bi=new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);//����һ����ɫͼƬ
		Graphics2D g=bi.createGraphics();//��ȡ��ͼ����
		g.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 16));
		g.setColor(color);
		g.fillRect(0, 0, width,height);//���Ʊ���
		g.setColor(reverse);
		g.drawString(randomString, 18, 20);//��������ַ�
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
