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
import javax.swing.JOptionPane;

import edu.ec.dao.UserDao;
import edu.ec.entity.User;

public class UserLogin extends HttpServlet {

	/**
	 * The doGet method of the servlet
	 */
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");

		String username = request.getParameter("username");
		String upsd = request.getParameter("password");
		String isLogin = null;
		HttpSession session=request.getSession(true);
		if(username != "" && upsd != ""){
			EntityManagerFactory emf = Persistence.createEntityManagerFactory("user");
	        EntityManager em = emf.createEntityManager();
	        UserDao jpa_user = new UserDao();
	        try{
				List<User> user = jpa_user.selectName(em, username);
				String uname = user.get(0).getName();
				String psd = user.get(0).getPassword();
				isLogin = (String) session.getAttribute("login");
				System.out.println(isLogin);
					if(uname!=null&&psd.equals(upsd)){
						if(isLogin==null){
							session.setAttribute("login", uname);
							request.setAttribute("msg", "登录成功，欢迎访问");
						}else{
							System.out.println(isLogin);
							if(isLogin.equals(uname)){
								request.setAttribute("msg", "用户已登录");
							}else{
								request.setAttribute("msg", "请先退出当前用户");
							}
						}
					}else{
						request.setAttribute("msg", "密码错误");
					}
			}catch(Exception ee){
				request.setAttribute("msg", "用户不存在");
			}
		}else{
			request.setAttribute("msg", "请输入用户名或密码");
		}
		request.setAttribute("success",session.getAttribute("login"));
		isLogin = (String) session.getAttribute("login");
		if(isLogin==null||isLogin.equals("")){
			request.getRequestDispatcher("/login.jsp").forward(request, response);
		}else{
			request.getRequestDispatcher("/index.jsp").forward(request, response);
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
