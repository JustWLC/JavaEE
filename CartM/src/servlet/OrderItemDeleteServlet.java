package servlet;

import java.io.IOException;
import java.util.ArrayList;

import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.OrderItem;

/**
 * Servlet implementation class OrderItemDeleteServlet
 */
@WebServlet("/OrderItemDeleteServlet")
public class OrderItemDeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public OrderItemDeleteServlet() {
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
		
		int pid=Integer.parseInt(request.getParameter("pid"));
		List<OrderItem> ois = (List<OrderItem>) request.getSession().getAttribute("ois");
		request.getSession().removeAttribute("ois");
		List<OrderItem> oisdelete=new ArrayList<OrderItem>();
		
		if (ois!=null)
		{
			for(OrderItem oItem:ois){
				System.out.println(oItem.getProduct().getName());
				if (oItem.getId()==pid)
				{
					oisdelete.add(oItem);
				}
			}
		}
		ois.removeAll(oisdelete);
		request.getSession().setAttribute("ois", ois);
		response.sendRedirect("OrderItemListServlet");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
