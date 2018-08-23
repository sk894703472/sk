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

public class InventoryInsert extends HttpServlet {

	/**
	 * The doGet method of the servlet.
	 */
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("user");
        EntityManager em = emf.createEntityManager();
        InventoryDao jpa_invent = new InventoryDao();
        String inventproduct = request.getParameter("inventproduct");
        String inventsum = request.getParameter("inventsum");
        try{
        	String inventuser = request.getParameter("inventuser");
            if(inventsum!=""&&inventproduct!=""&&inventuser!=""){
            	jpa_invent.insert(em, inventsum, inventuser, inventproduct);
            	request.setAttribute("msg", "添加成功");
            }else{
            	request.setAttribute("msg", "信息有误");
            }
        }catch(Exception ee){
        	request.setAttribute("msg", "编号已存在");
        }
        List<Inventory> invent = jpa_invent.selectAll(em);
        request.setAttribute("invent", invent);
        request.getRequestDispatcher("/inventoryInsert.jsp").forward(request, response);
	}

	/**
	 * The doPost method of the servlet.
	 */
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request,response);
	}

}
