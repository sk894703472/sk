package edu.ec.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import edu.ec.dao.UserDao;

public class UserRegister extends HttpServlet {
	/**
	 * The doGet method of the servlet.ccurred
	 */
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session=request.getSession(true);
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("user");
        EntityManager em = emf.createEntityManager();
        UserDao jpa_user = new UserDao();
        String username = request.getParameter("username");
        String userpsd = request.getParameter("userpsd");
        if(username!=""&&userpsd!=""){
        	jpa_user.insert(em, username, userpsd);
        	request.setAttribute("msg", "注册成功，请登录");
        }else{
        	request.setAttribute("msg", "信息有误");
        }
        request.setAttribute("success",session.getAttribute("login"));
        request.getRequestDispatcher("/index.jsp").forward(request, response);
	}

	/**
	 * The doPost method of the servlet.
	 */
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request,response);
	}
}
