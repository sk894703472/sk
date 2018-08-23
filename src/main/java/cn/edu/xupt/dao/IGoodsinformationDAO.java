package cn.edu.xupt.dao;

import java.util.List;

import cn.edu.xupt.bean.Goodsinformation;

/**
 * Interface for GoodsinformationDAO.
 * 
 * @author MyEclipse Persistence Tools
 */

public interface IGoodsinformationDAO {
	
	public void save(Goodsinformation entity);

	/**
	 * Delete a persistent Goodsinformation entity. This operation must be
	 * performed within the a database transaction context for the entity's data
	 * to be permanently deleted from the persistence store, i.e., database.
	 * This method uses the
	 * {@link javax.persistence.EntityManager#remove(Object)
	 * EntityManager#delete} operation.
	 * 
	 * <pre>
	 * EntityManagerHelper.beginTransaction();
	 * IGoodsinformationDAO.delete(entity);
	 * EntityManagerHelper.commit();
	 * entity = null;
	 * </pre>
	 * 
	 * @param entity
	 *            Goodsinformation entity to delete
	 * @throws RuntimeException
	 *             when the operation fails
	 */
	public void delete(Goodsinformation entity);

	/**
	 * Persist a previously saved Goodsinformation entity and return it or a
	 * copy of it to the sender. A copy of the Goodsinformation entity parameter
	 * is returned when the JPA persistence mechanism has not previously been
	 * tracking the updated entity. This operation must be performed within the
	 * a database transaction context for the entity's data to be permanently
	 * saved to the persistence store, i.e., database. This method uses the
	 * {@link javax.persistence.EntityManager#merge(Object) EntityManager#merge}
	 * operation.
	 * 
	 * <pre>
	 * EntityManagerHelper.beginTransaction();
	 * entity = IGoodsinformationDAO.update(entity);
	 * EntityManagerHelper.commit();
	 * </pre>
	 * 
	 * @param entity
	 *            Goodsinformation entity to update
	 * @return Goodsinformation the persisted Goodsinformation entity instance,
	 *         may not be the same
	 * @throws RuntimeException
	 *             if the operation fails
	 */
	public Goodsinformation update(Goodsinformation entity);

	public Goodsinformation findById(Integer id);

	
	public List<Goodsinformation> findByProperty(String propertyName,
			Object value);

	public List<Goodsinformation> findByGoodsName(Object goodsName);

	public List<Goodsinformation> findByGoodsNum(Object goodsNum);

	public List<Goodsinformation> findByGoodsPrice(Object goodsPrice);

	
	public List<Goodsinformation> findAll();
}