package cn.edu.xupt.controller;

import java.io.IOException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import cn.edu.xupt.bean.Goodsinformation;
import cn.edu.xupt.bean.Orders;
import cn.edu.xupt.bean.Users;
import cn.edu.xupt.other.Result;
import cn.edu.xupt.service.GoodsService;
import cn.edu.xupt.service.OrdersService;
import cn.edu.xupt.service.Userservice;
@RequestMapping("/orders")
@Controller
public class OrdersController {
	private OrdersService ordersService=new OrdersService();
	private Userservice userservice=new Userservice();
	private GoodsService goodsService=new GoodsService();
	@RequestMapping("/list")
	public String getAll(Model model) {
		List<Orders> list=ordersService.getAll();
		if(list!=null) {
			model.addAttribute("orders", list);
		}
		return "ordersList";
	}
	@RequestMapping(value="/findone",method=RequestMethod.POST)
	public String getOne(@RequestParam("Id")Integer id,Model model) {
		List<Orders> list2=new ArrayList<>();
		if(id!=null) {
			Orders orders=ordersService.getOrdersById(id);
			if(orders!=null) {
				list2.add(orders);		
				model.addAttribute("orders",list2);
			}else {
				model.addAttribute("mess", "该商品不存在");
			}
		}
		return "ordersList";
	}
	@RequestMapping("/delete")
	public void delete(@RequestParam(value="id")Integer id,HttpServletRequest request,HttpServletResponse response) {
		ordersService.delete(id);
		try {
			response.sendRedirect(request.getContextPath()+"/orders/list");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	@RequestMapping("/toUpdate")
	public String update(@RequestParam(value="id")Integer id,Model model) {
		Orders goodsinformation=ordersService.getOrdersById(id);
		model.addAttribute("order", goodsinformation);
		return "updateOrders";
	}
	@RequestMapping("/update")
	public String updateGoods(Orders orders,Model model) {
		ordersService.updateOrders(orders);
		model.addAttribute("good", orders);
		return "success";
	}
	@RequestMapping("/showadd")
	public String showAdd() {
		return "addOrders";
	}
	@RequestMapping(value="/add",method=RequestMethod.POST)
	public String addGoods(@RequestParam("goodsId")Integer goodsId,@RequestParam("id")Integer userId,Model model) {
		Boolean re = false;
		Result result=new Result();
		Users users=userservice.findUserByid(userId);
		Goodsinformation goodsinformation=goodsService.findGoodsById(goodsId);
		if(users!=null&&goodsinformation!=null) {
			Orders orders=new Orders(null, users, goodsinformation, new Timestamp( new Date().getTime()));
			re=ordersService.add(orders);
		}
		if(re) {
			model.addAttribute("mess","添加成功");
			
		}else {
			model.addAttribute("mess","添加失败，商品不存在或是用户id错误");
		}
		
		return "addOrders";
	}
}
