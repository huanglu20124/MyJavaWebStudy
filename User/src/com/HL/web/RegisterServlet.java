package com.HL.web;

import java.io.IOException;
import java.io.PrintWriter;
import java.lang.reflect.InvocationTargetException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;

import com.HL.domain.User;
import com.HL.exception.MsgException;
import com.HL.service.UserService;

public class RegisterServlet extends HttpServlet {

	/**
	 * Constructor of the object.
	 */
	public RegisterServlet() {
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

		response.setContentType("text/html");

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

		response.setContentType("text/html;charset=utf-8");
		response.setCharacterEncoding("utf-8");
		request.setCharacterEncoding("utf-8");
	    //��װУ�鴦������
		//�õ�BeanUtils���,��map������Զ�Ӧ�ظ�ֵ��user
		try {
			    //���쳣ͳһ������user�������ף�������try-catch��ס
		        User user = new User();
		        UserService userService = new UserService();
		        BeanUtils.populate(user, request.getParameterMap());
	            user.checkValue();
				userService.registUser(user);
				response.getWriter().write("��ϲע��ɹ���3��󷵻���ҳ��");
				response.setHeader("refresh", "3;url=" + request.getContextPath() + "/index.jsp");
				request.getSession().setAttribute("user", user);
		} catch (MsgException e) {
				// TODO Auto-generated catch block
				request.setAttribute("msg", e.getMessage());
				request.getRequestDispatcher("/register.jsp").forward(request, response);
			} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			//����runtimeException�ĕr�򣬳��򳹵׹ҵ�
			throw new RuntimeException(e);
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
