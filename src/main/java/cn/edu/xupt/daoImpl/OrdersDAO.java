package cn.edu.xupt.daoImpl;

import java.util.List;
import java.util.logging.Level;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import cn.edu.xupt.bean.Orders;
import cn.edu.xupt.dao.EntityManagerHelper;
import cn.edu.xupt.dao.IOrdersDAO;
@Repository("ordersDAO")
public class OrdersDAO implements IOrdersDAO {
	// property constants

	private EntityManager getEntityManager() {
		return EntityManagerHelper.getEntityManager();
	}

	
	public void save(Orders entity) {
		EntityManagerHelper.log("saving Orders instance", Level.INFO, null);
		try {
			getEntityManager().persist(entity);
			EntityManager em=getEntityManager();
			em.getTransaction().begin();
			em.persist(entity);
			em.flush();
			em.getTransaction().commit();
		} catch (RuntimeException re) {
			EntityManagerHelper.log("save failed", Level.SEVERE, re);
			throw re;
		}
	}

	public void delete(Orders entity) {
		EntityManagerHelper.log("deleting Orders instance", Level.INFO, null);
		try {
			EntityManager em=getEntityManager();
			em.getTransaction().begin();
			entity = em.getReference(Orders.class,entity.getOrdersId());
			em.remove(entity);
			em.getTransaction().commit();
			EntityManagerHelper.log("delete successful", Level.INFO, null);
		} catch (RuntimeException re) {
			EntityManagerHelper.log("delete failed", Level.SEVERE, re);
			throw re;
		}
	}

	
	public Orders update(Orders entity) {
		EntityManagerHelper.log("updating Orders instance", Level.INFO, null);
		try {
			EntityManager em=getEntityManager();
			em.getTransaction().begin();
			Orders result = getEntityManager().merge(entity);
			em.getTransaction().commit();
			EntityManagerHelper.log("update successful", Level.INFO, null);
			return result;
		} catch (RuntimeException re) {
			EntityManagerHelper.log("update failed", Level.SEVERE, re);
			throw re;
		}
	}

	public Orders findById(Integer id) {
		EntityManagerHelper.log("finding Orders instance with id: " + id,
				Level.INFO, null);
		try {
			EntityManager em=getEntityManager();
			em.getTransaction().begin();
			Orders instance =em.find(Orders.class, id);
			em.getTransaction().commit();
			return instance;
		} catch (RuntimeException re) {
			EntityManagerHelper.log("find failed", Level.SEVERE, re);
			throw re;
		}
	}

	
	@SuppressWarnings("unchecked")
	public List<Orders> findByProperty(String propertyName, final Object value) {
		EntityManagerHelper.log("finding Orders instance with property: "
				+ propertyName + ", value: " + value, Level.INFO, null);
		try {
			final String queryString = "select model from Orders model where model."
					+ propertyName + "= :propertyValue";
			Query query = getEntityManager().createQuery(queryString);
			query.setParameter("propertyValue", value);
			return query.getResultList();
		} catch (RuntimeException re) {
			EntityManagerHelper.log("find by property name failed",
					Level.SEVERE, re);
			throw re;
		}
	}
	@SuppressWarnings("unchecked")
	public List<Orders> findAll() {
		EntityManagerHelper.log("finding all Orders instances", Level.INFO,
				null);
		try {
			final String queryString = "select model from Orders model";
			Query query = getEntityManager().createQuery(queryString);
			return query.getResultList();
		} catch (RuntimeException re) {
			EntityManagerHelper.log("find all failed", Level.SEVERE, re);
			throw re;
		}
	}


	@SuppressWarnings("unchecked")
	public List<Orders> findByIdadUserId(Integer id, Integer userId) {
		// TODO Auto-generated method stub
		try {
			final String queryString = "select ordersid,time,o.userid,username,goodsname join orders o,"
					+ "user u,goodsinformation g on u.id=o.userid,o.goodsid=g.goodsid";
			Query query = getEntityManager().createNativeQuery(queryString);
			return query.getResultList();
		} catch (RuntimeException re) {
			EntityManagerHelper.log("find all failed", Level.SEVERE, re);
			throw re;
		}
		//return null;
	}


}
