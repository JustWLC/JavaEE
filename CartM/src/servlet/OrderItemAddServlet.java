package servlet;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.OrderItem;
import bean.Product;
import dao.ProductDao;

/**
 * Servlet implementation class OrderItemAddServlet
 */
@WebServlet("/OrderItemAddServlet")
public class OrderItemAddServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public OrderItemAddServlet() {
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
		int num=Integer.parseInt(request.getParameter("num"));
		int pid=Integer.parseInt(request.getParameter("pid"));
		ProductDao productDao=new ProductDao();
		try{
		Product p=productDao.getproduct(pid);
		p=productDao.getproduct(pid);
		OrderItem orderItem=new OrderItem();
		orderItem.setProduct(p);
		orderItem.setNum(num);
			List<OrderItem> ois=(List<OrderItem>)request.getSession().getAttribute("ois");
			if (ois==null)
			{
				ois=new ArrayList<OrderItem>();
				
			}
			boolean found=false;
			for(OrderItem orderItem2:ois){
				if (orderItem2.getProduct().getId()==orderItem.getProduct().getId())
				{
					orderItem2.setNum(orderItem2.getNum()+orderItem.getNum());
					found=true;
					break;
				}
			}
			if (!found)
			{
				ois.add(orderItem);
			}
			request.getSession().setAttribute("ois", ois);
		    response.sendRedirect("OrderItemListServlet");
		}catch(SQLException e){
			e.printStackTrace();
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
