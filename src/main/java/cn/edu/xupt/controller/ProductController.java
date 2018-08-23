package cn.edu.xupt.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import cn.edu.xupt.bean.Goodsinformation;
import cn.edu.xupt.other.Result;
import cn.edu.xupt.service.GoodsService;

@Controller
@RequestMapping(value="/goods")
public class ProductController {
	Result result=new Result();
	private GoodsService goodsService=new GoodsService();
	
	@RequestMapping(value="/select")
	public String getAll(Model model) {
		
		List<Goodsinformation> goods=goodsService.getAllGoods();
		//System.out.println("...."+goods);
		model.addAttribute("goodsInfo", goods);
		return "/goodsManager/goods";
	}
	@RequestMapping(value="/add",method=RequestMethod.POST)
	public String addGoods(Model model,Goodsinformation goodsinformation) {
		Boolean re=goodsService.add(goodsinformation);
		
		if(re) {
			result.setMessage("添加成功");
			
		}else {
			result.setMessage("添加失败");
		}
		model.addAttribute("result",result);
		return "/goodsManager/addgoods";
	}
	@RequestMapping("/showAdd")
	public String addGoods() {
		
		return "/goodsManager/addgoods";
	}
	//删除
	@RequestMapping("/delete")
	public void delete(@RequestParam(value="id")Integer id,HttpServletRequest request,HttpServletResponse response) {
		goodsService.deleteGoods(id);
		try {
			response.sendRedirect(request.getContextPath()+"/goods/select");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	@RequestMapping("/showfind")
	public String showFind() {
		
		return "/goodsManager/select";
	}
	@RequestMapping("/toUpdate")
	public String update(@RequestParam(value="id")Integer id,Model model) {
		Goodsinformation goodsinformation=goodsService.findGoodsById(id);
		model.addAttribute("good", goodsinformation);
		return "/goodsManager/updateGoods";
	}
	@RequestMapping("/update")
	public void updateGoods(Goodsinformation goodsinformation,HttpServletRequest request,HttpServletResponse response) {
		goodsService.updateGoods(goodsinformation);
		try {
			response.sendRedirect(request.getContextPath()+"/goods/select");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//return "success";
	}
	@RequestMapping("/find")
	public String findGoodsByNameOrId(Goodsinformation goodsinformation,Model model) {
		int flag=0;
		Goodsinformation goodsinformation2=new Goodsinformation();
		Integer id=goodsinformation.getGoodsId();
		if(id!=null) {
			goodsinformation2=goodsService.findGoodsById(id);
		}else {
			goodsinformation2=goodsService.findGoodsByName(goodsinformation.getGoodsName());
		}
		if(goodsinformation2!=null) {
			result=new Result(1,"存在", goodsinformation2);
		}
		if(goodsinformation2==null&&goodsinformation!=null){
			result=new Result(0,"该商品不存在",null);
		}
		model.addAttribute("re", result);
		return "/goodsManager/select";
	}
}
