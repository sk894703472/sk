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

public class ProductUpdate extends HttpServlet {

	/**
	 * The doGet method of the servlet.
	 */
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		int idx = Integer.parseInt(request.getParameter("idx"));
		System.out.println(idx);
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("user");
		EntityManager em = emf.createEntityManager();
        ProductDao jpa_prod = new ProductDao();
        List<Product> products = jpa_prod.selectAll(em);
        request.setAttribute("result", products);
        String newidx = "pro"+idx;
        String newprice = request.getParameter(newidx);
        System.out.println(newidx);
        System.out.println(newprice);
        String id = products.get(idx).getId();
        jpa_prod.update(em, newprice, id);
        request.setAttribute("msg", "更新成功");
        request.getRequestDispatcher("/ProductQuery?p=query").forward(request, response);
	}

	/**
	 * The doPost method of the servlet.
	 */
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request,response);
	}

}
