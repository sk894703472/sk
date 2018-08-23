package cn.edu.xupt.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import cn.edu.xupt.bean.Users;
import cn.edu.xupt.other.Result;
import cn.edu.xupt.service.Userservice;

@Controller
@RequestMapping("/user")
@SessionAttributes("userId")
public class UserController {
	//@Autowired
	private Userservice userservice=new Userservice();
	@RequestMapping("/showAdd")
	public String showAdd() {
		
		return "/usermanager/adduser";
	}
//	@ResponseBody
//	@RequestMapping(value="/updatePass",method=RequestMethod.POST)
//	public String updatePass(@RequestParam("newpass")String newpass,HttpSession session) {
//		Users users=userservice.findUserByid((Integer) session.getAttribute("userId"));
//		users.setPassword(newpass);
//		userservice.update(users);
//		return newpass;
//	}
	@RequestMapping("/toUpdate")
	public ModelAndView toUpdate(@RequestParam("id")Integer id,ModelAndView modelAndView) {
		Users user=userservice.findUserByid(id);
		modelAndView.setViewName("/usermanager/updateUsers");
		modelAndView.addObject("user", user);
		return modelAndView;
	}
	@RequestMapping("/update")
	public void Update(Users users,HttpServletRequest request,HttpServletResponse response) {
		userservice.update(users);
		request.setAttribute("re", "恭喜你，修改成功！");
		try {
			request.getRequestDispatcher("/user/select").forward(request, response);
		} catch (ServletException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//return "success";
	}
	@ResponseBody
	@RequestMapping("/updatePass")
	public String UpdatePass(@RequestParam("newpass")String newpass,HttpSession session) {
		Integer id=(Integer) session.getAttribute("userId");
		Users users=userservice.findUserByid(id);
		users.setPassword(newpass);
		userservice.update(users);
		return newpass;
	}
	@RequestMapping("/add")
	public String addUser(Users users,Model model) {
		userservice.save(users);
		model.addAttribute("re", "添加成功");
		return "/usermanager/adduser";
	}
	@RequestMapping("/login")
	public String login(Users users,Model model) {
		Users users2=userservice.findUserByName(users.getUserName());
		if(users2!=null&&users2.getPassword().equals(users.getPassword())) {
			System.out.println(users2.getId());
			model.addAttribute("userId", users2.getId());
			return "main";
		} else {
			model.addAttribute("mess","用户不存在或密码错误");
			return "login";
		}
	}
	@RequestMapping("/logout")
	public String loginout(HttpServletRequest request) {
		request.getSession().removeAttribute("userId");
		return "login";
		
	}
	@RequestMapping("/select")
	public String Select(Model model) {
		List<Users> users=userservice.getAll();
		if(users!=null&&users.size()!=0) {
			model.addAttribute("users", users);
		}
		return "/usermanager/UserList";
	}
	@RequestMapping("/find")
	public String find(Users users,Model model) {
		Result result;
		Users users2;
		Integer id=users.getId();
		if(id!=null) {
			users2=userservice.findUserByid(id);
		}else {
			users2=userservice.findUserByName(users.getUserName());
		}
		if(users2==null) {
			result=new Result(0,"该用户不存在",null);
		}else {
			result=new Result(1,"存在", users2);
		}
		model.addAttribute("re", result);
		return "/usermanager/select";
	}
	@RequestMapping("/showfind")
	public String Showfind(Model model) {
		return "/usermanager/select";
	}
	@ResponseBody
	@RequestMapping("/delete")
	public Result delete(@RequestParam("id")Integer id) {
		Result result=new Result();
		boolean re=userservice.deleteUser(id);
		if(re) {
			result.setMessage("删除成功");
		}else {
			result.setMessage("删除失败");
		}
		return result;
	}
	
}
