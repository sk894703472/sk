package edu.ec.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edu.ec.dao.ProductDao;
import edu.ec.dao.UserDao;
import edu.ec.entity.Product;
import edu.ec.entity.User;

public class UserSearch extends HttpServlet {

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
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=utf-8");
		String searchvalue = request.getParameter("searchvalue");
		String searchtype = request.getParameter("protype");
		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("user");
        EntityManager em = emf.createEntityManager();
        UserDao jpa_user = new UserDao();
        List<User> products =null;
        if(searchvalue.equals("")){
        	products = jpa_user.selectAll(em);
        }
        else if(searchtype.equals("id")){
        	products = jpa_user.selectId(em, searchvalue);
		}else if(searchtype.equals("name")){
			products = jpa_user.selectName(em, searchvalue);
		}
        request.setAttribute("result", products);
        System.out.println(products);
        request.getRequestDispatcher("userQuery.jsp").forward(request, response);
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

		doGet(request,response);
	}

}
