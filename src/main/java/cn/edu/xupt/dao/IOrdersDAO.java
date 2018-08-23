package cn.edu.xupt.dao;

import java.util.List;

import cn.edu.xupt.bean.Orders;



public interface IOrdersDAO {

	public void save(Orders entity);


	public void delete(Orders entity);


	public Orders update(Orders entity);

	public Orders findById(Integer id);

	
	public List<Orders> findByProperty(String propertyName, Object value);

	
	public List<Orders> findAll();
}