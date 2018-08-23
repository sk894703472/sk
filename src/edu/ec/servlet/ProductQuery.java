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
import javax.servlet.http.HttpSession;

import edu.ec.dao.ProductDao;
import edu.ec.entity.Product;

public class ProductQuery extends HttpServlet {


	/**
	 * The doGet method of the servlet.
	 */
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("user");
        EntityManager em = emf.createEntityManager();
        HttpSession session=request.getSession(true);
        String uname = (String) session.getAttribute("login");
        if(uname!=null){
	        ProductDao jpa_prod = new ProductDao();
	        List<Product> products = jpa_prod.selectAll(em);
	        request.setAttribute("result", products);
        }else{
        	request.setAttribute("msg", "ÇëÏÈµÇÂ¼");
        }
        String page = request.getParameter("p");
        if(page.equals("query")){
        	request.getRequestDispatcher("productQuery.jsp").forward(request, response);
        }else if(page.equals("insert")){
        	request.getRequestDispatcher("productInsert.jsp").forward(request, response);
        }
	}

	/**
	 * The doPost method of the servlet.
	 */
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request,response);
	}

}
