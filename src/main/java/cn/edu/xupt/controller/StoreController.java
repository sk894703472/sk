package cn.edu.xupt.controller;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class StoreController {
	@RequestMapping("/show")
	public String getMainJsp(HttpSession session) {
	Integer userName=(Integer)session.getAttribute("userId");
	if(userName==null) {
		return "login";
	}else {
		return "main";
	}
	}
	
}
