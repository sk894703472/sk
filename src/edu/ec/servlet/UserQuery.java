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
import edu.ec.entity.User;

public class UserQuery extends HttpServlet {

	/**
	 * The doGet method of the servlet.
	 */
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("user");
        EntityManager em = emf.createEntityManager();
        UserDao jpa_user = new UserDao();
        HttpSession session=request.getSession(true);
        String uname = (String) session.getAttribute("login");
        System.out.println(uname);
        if(uname==null){
        	request.setAttribute("msg", "请先登录,在进行修改");
        }else{
        	 User user = jpa_user.selectName(em, uname).get(0);
             request.setAttribute("user", user);
        }

        request.getRequestDispatcher("/userUpdate.jsp").forward(request, response);
	}

	/**
	 * The doPost method of the servlet.
	 */
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request,response);
	}

}
