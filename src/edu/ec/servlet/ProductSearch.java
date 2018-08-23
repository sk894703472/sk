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
import edu.ec.entity.Product;

public class ProductSearch extends HttpServlet {

	/**
	 * The doGet method of the servlet.
	 */
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		String searchvalue = request.getParameter("searchvalue");
		String searchtype = request.getParameter("protype");
		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("user");
        EntityManager em = emf.createEntityManager();
        ProductDao jpa_prod = new ProductDao();
        List<Product> products =null;
        if(searchvalue.equals("")){
        	products = jpa_prod.selectAll(em);
        }
        else if(searchtype.equals("id")){
        	products = jpa_prod.selectId(em, searchvalue);
		}else if(searchtype.equals("type")){
			products = jpa_prod.selectType(em, searchvalue);
		}else if(searchtype.equals("name")){
			products = jpa_prod.selectName(em, searchvalue);
		}
        request.setAttribute("result", products);
        System.out.println(products);
        request.getRequestDispatcher("productQuery.jsp").forward(request, response);
	}

	/**
	 * The doPost method of the servlet.
	 */
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request,response);
	}

}
