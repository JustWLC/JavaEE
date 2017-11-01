package servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.Order;
import bean.OrderItem;
import bean.userbean;
import dao.OrderDao;
import dao.OrderItemDao;

/**
 * Servlet implementation class OrderCreateServlet
 */
@WebServlet("/OrderCreateServlet")
public class OrderCreateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public OrderCreateServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html");
		userbean user=(userbean)request.getSession().getAttribute("user");
		if (user==null)
		{
			response.sendRedirect("login.jsp");
			return;
		}
		try
		{
			Order order=new Order();
			order.setUser(user);
			
			new OrderDao().insert(order);
			
			List<OrderItem> ois=(List<OrderItem>)request.getSession().getAttribute("ois");
			for(OrderItem oi:ois){
				oi.setOrder(order);
				new OrderItemDao().insert(oi);
			}
			ois.clear();
			response.setContentType("text/html; charset=UTF-8");
	        response.getWriter().println("订单创建成功");
		} catch (Exception e)
		{
			// TODO: handle exception
		}
		
		
		
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
