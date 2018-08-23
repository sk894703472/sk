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

public class ProductInsert extends HttpServlet {


	/**
	 * The doGet method of the servlet.
	 */
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("user");
        EntityManager em = emf.createEntityManager();
        ProductDao jpa_prod = new ProductDao();
        String proid = request.getParameter("proid");
        String proname = request.getParameter("proname");
        String protype = request.getParameter("protype");
        System.out.println(protype);
        try{
        	String proprice = request.getParameter("proprice");
            if(proid!=""&&proname!=""&&protype!=""&&proprice!=""){
            	jpa_prod.insert(em, proid, proname, protype, proprice);
            	request.setAttribute("msg", "插入成功");
            }else{
            	request.setAttribute("msg", "信息有误");
            }
        }catch(Exception ee){
        	request.setAttribute("msg", "编号已存在");
        }
        List<Product> products = jpa_prod.selectAll(em);
        request.setAttribute("result", products);
        
        request.getRequestDispatcher("/productInsert.jsp").forward(request, response);
	}

	/**
	 * The doPost method of the servlet.
	 */
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request,response);
	}
}
