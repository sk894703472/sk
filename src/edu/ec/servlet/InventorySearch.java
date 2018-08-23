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

public class InventorySearch extends HttpServlet {

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
        InventoryDao jpa_invent = new InventoryDao();
        List<Inventory> invents =null;
        if(searchvalue.equals("")){
        	invents = jpa_invent.selectAll(em);
        }
        else if(searchtype.equals("id")){
        	invents = jpa_invent.selectId(em, searchvalue);
		}else if(searchtype.equals("user")){
			invents = jpa_invent.selectUser(em, searchvalue);
		}else if(searchtype.equals("product")){
			invents = jpa_invent.selectProduct(em, searchvalue);
		}
        System.out.println(invents);
        request.setAttribute("invent", invents);
        request.getRequestDispatcher("inventoryQuery.jsp").forward(request, response);
	}

	/**
	 * The doPost method of the servlet.
	 */
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request,response);
	}

}
