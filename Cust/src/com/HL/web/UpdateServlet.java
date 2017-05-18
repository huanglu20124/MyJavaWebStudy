package com.HL.web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;

import com.HL.domain.Customer;
import com.HL.factory.BasicFactory;
import com.HL.service.CustService;

public class UpdateServlet extends HttpServlet {

	/**
	 * Constructor of the object.
	 */
	public UpdateServlet() {
		super();
	}

	/**
	 * Destruction of the servlet. <br>
	 */
	public void destroy() {
		super.destroy(); // Just puts "destroy" string in log
		// Put your code here
	}

	/**
	 * The doGet method of the servlet. <br>
	 *
	 * This method is called when a form has its tag value method equals to get.
	 * 
	 * @param request the request send by the client to the server
	 * @param response the response send by the server to the client
	 * @throws ServletException if an error occurred
	 * @throws IOException if an error occurred
	 */
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	}

	/**
	 * The doPost method of the servlet. <br>
	 *
	 * This method is called when a form has its tag value method equals to post.
	 * 
	 * @param request the request send by the client to the server
	 * @param response the response send by the server to the client
	 * @throws ServletException if an error occurred
	 * @throws IOException if an error occurred
	 */
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
//		CustService service = new CustServiceImpl();
		CustService service = BasicFactory.getFactory().getInstance(CustService.class);
		try {
			Customer customer = new Customer();
			BeanUtils.populate(customer, request.getParameterMap());
			//单独处理preference
			String[]prefs = request.getParameterValues("preference");
			StringBuffer sb = new StringBuffer();
			for(String pre : prefs){
				sb.append(pre+",");
			}
			String preference = sb.substring(0, sb.length()-1);
			customer.setPreference(preference);
//			customer.setId(Integer.parseInt(request.getParameter("id")));
//			System.out.println(customer.getId());
			//
			service.updateCust(customer);
			//请求转发是服务器发出的，重定向是浏览器发出的，路径不同
//			request.getRequestDispatcher("/servlet/ListServlet").forward(request, response);
			response.sendRedirect(request.getContextPath()+"/servlet/ListServlet");
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

	/**
	 * Initialization of the servlet. <br>
	 *
	 * @throws ServletException if an error occurs
	 */
	public void init() throws ServletException {
		// Put your code here
	}

}
