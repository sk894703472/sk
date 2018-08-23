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

import edu.ec.dao.InventoryDao;
import edu.ec.dao.ProductDao;
import edu.ec.entity.Inventory;
import edu.ec.entity.Product;

public class InventoryDelete extends HttpServlet {

	/**
	 * The doGet method of the servlet.
	 */
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		int idx = Integer.parseInt(request.getParameter("idx"));
		System.out.println(idx);
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("user");
		EntityManager em = emf.createEntityManager();
        InventoryDao jpa_invent = new InventoryDao();
        List<Inventory> invents = jpa_invent.selectAll(em);
        String id = invents.get(idx).getId();
        jpa_invent.delete(em, id);
        request.setAttribute("msg", "É¾³ý³É¹¦");
        request.getRequestDispatcher("/InventoryQuery?p=query").forward(request, response);
	}

	/**
	 * The doPost method of the servlet.
	 */
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request,response);
	}

}
