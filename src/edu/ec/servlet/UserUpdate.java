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

import edu.ec.dao.UserDao;
import edu.ec.entity.User;

public class UserUpdate extends HttpServlet {

	/**
	 * The doGet method of the servlet.
	 */
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		HttpSession session = request.getSession(true);
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("user");
        EntityManager em = emf.createEntityManager();
        UserDao jpa_user = new UserDao();
        String userid = request.getParameter("id");
        String username = request.getParameter("name");
        String userpsd = request.getParameter("password");
        User olduser = jpa_user.selectId(em, userid).get(0);
        String oldname = olduser.getName();
        if(username != oldname){
        	session.setAttribute("login", username);
        }
        System.out.print(session.getAttribute("login")+"222");
        jpa_user.update(em, userpsd, userid, username);
        System.out.println(username);
        request.setAttribute("msg", "ÐÞ¸Ä³É¹¦");
        request.getRequestDispatcher("/UserQuery").forward(request, response);

	}

	/**
	 * The doPost method of the servlet.
	 */
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request,response);
	}

	/**
	 * Initialization of the servlet. <br>
	 *
	 * @throws ServletException if an error occurs
	 */
	public void init() throws ServletException {
		// Put your code here
	}

}
