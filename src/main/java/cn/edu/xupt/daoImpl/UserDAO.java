package cn.edu.xupt.daoImpl;

import java.util.List;
import java.util.logging.Level;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import cn.edu.xupt.bean.Users;
import cn.edu.xupt.dao.EntityManagerHelper;

@Repository("userDAO")
public class UserDAO {
	public final String table="Users";
	public final String USERNAME="username";
	private EntityManager getEntityManager() {
		return EntityManagerHelper.getEntityManager();
	}
	public void save(Users entity) {
		EntityManagerHelper.log("saving Users instance", Level.INFO,
				null);
		try {
			EntityManager em=getEntityManager();
			em.getTransaction().begin();
			em.persist(entity);
			em.flush();
			em.getTransaction().commit();
		} catch (RuntimeException re) {
			EntityManagerHelper.log("save failed", Level.SEVERE, re);
			throw re;
		}
	}	//删除用户
	public void deleteUser(Users entity) {
		EntityManagerHelper.log("deleting Users instance",
				Level.INFO, null);
		try {
			EntityManager em=getEntityManager();
			em.getTransaction().begin();
			entity = em.getReference(Users.class,entity.getId());
			em.remove(entity);
			em.getTransaction().commit();
			EntityManagerHelper.log("delete successful", Level.INFO, null);
		} catch (RuntimeException re) {
			EntityManagerHelper.log("delete failed", Level.SEVERE, re);
			throw re;
		}
	}
	//修改用户信息
	public Users update(Users entity) {
		EntityManagerHelper.log("updating Users instance",
				Level.INFO, null);
		try {
			EntityManager em=getEntityManager();
			em.getTransaction().begin();
			Users result = getEntityManager().merge(entity);
			em.getTransaction().commit();
			EntityManagerHelper.log("update successful", Level.INFO, null);
			return result;
		} catch (RuntimeException re) {
			EntityManagerHelper.log("update failed", Level.SEVERE, re);
			throw re;
		}
	}
	//根据id查询用户
	public Users getUserById(Integer id) {
		EntityManagerHelper.log("finding Users instance with id: "
				+ id, Level.INFO, null);
		try {
			EntityManager em=getEntityManager();
			em.getTransaction().begin();
			Users instance =em.find(Users.class, id);
			em.getTransaction().commit();
			return instance;
		} catch (RuntimeException re) {
			EntityManagerHelper.log("find failed", Level.SEVERE, re);
			throw re;
		}
	}
	//查询所有用户
	@SuppressWarnings("unchecked")
	public List<Users> getAllUsers(){
		EntityManagerHelper.log("finding all Goodsinformation instances",
				Level.INFO, null);
		try {
			final String queryString = "select model from Users model";
			Query query = getEntityManager().createQuery(queryString);
			return query.getResultList();
		} catch (RuntimeException re) {
			EntityManagerHelper.log("find all failed", Level.SEVERE, re);
			throw re;
		}
	}
	//按姓名查询
	public List<Users> findUserByName(String username) {
		// TODO Auto-generated method stub
		//System.out.println(userDao);
		String sqlString="select id,username,age,password from users where username ='"+username+"'";
		Query query= getEntityManager().createNativeQuery(sqlString, Users.class);
		@SuppressWarnings("unchecked")
		List<Users> list=query.getResultList();
		return list;
}
}
