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

public class UserDelete extends HttpServlet {

	/**
	 * The doGet method of the servlet.
	 */
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
        
        int idx = Integer.parseInt(request.getParameter("idx"));
		System.out.println(idx);
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("user");
		EntityManager em = emf.createEntityManager();
		UserDao jpa_user = new UserDao();
        List<User> products = jpa_user.selectAll(em);
        String id = products.get(idx).getId();
        jpa_user.delete(em, id);
        request.setAttribute("msg", "É¾³ý³É¹¦");
        request.getRequestDispatcher("/UserQuery2").forward(request, response);
	}

	/**
	 * The doPost method of the servlet.
	 */
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request,response);
	}
}
