package cn.edu.xupt.service;

import java.util.List;

import org.springframework.stereotype.Service;

import cn.edu.xupt.bean.Orders;
import cn.edu.xupt.daoImpl.OrdersDAO;

@Service
public class OrdersService {
	private OrdersDAO ordersDAO=new OrdersDAO();
	/**
	 * 查询所有的订单
	 * @return
	 */
	public List<Orders> getAll(){
		return ordersDAO.findAll();
	}
	/**
	 * 根据id删除订单
	 * @param id
	 */
	public void delete(Integer id) {
		ordersDAO.delete(new Orders(id));
	}
	/**
	 * 添加订单
	 * @param id
	 */
	public void delete(Orders orders) {
		ordersDAO.save(orders);;
	}
	/**
	 * 修改订单
	 * @param orders
	 * @return
	 */
	public Orders updateOrders(Orders orders) {
		return ordersDAO.update(orders);
	}
	/**
	 * 
	 * @param username
	 * @return
	 */
	public List<Orders> getOrdersByUserId(Integer userId){
		return ordersDAO.findByProperty("userid", userId);
	}
	public Orders getOrdersById(Integer id){
		return ordersDAO.findById(id);
	}
	public Orders getOrdersByIdAndUserId(Integer id,Integer userId) {
		// TODO Auto-generated method stub
		return ordersDAO.findByIdadUserId(id,userId).get(0);
		 
	}
	public Boolean add(Orders orders) {
		// TODO Auto-generated method stub
		ordersDAO.save(orders);
		return true;
	}
	
}
