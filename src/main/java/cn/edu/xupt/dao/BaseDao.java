package cn.edu.xupt.dao;

import java.util.List;

public interface BaseDao<T>{
	   List<T> listAll(final String table);
	   Object findById(Class<T> c,Integer id);
	   boolean save(Object object);
	   boolean update(Object object);
	   boolean delete(Object object);
}
