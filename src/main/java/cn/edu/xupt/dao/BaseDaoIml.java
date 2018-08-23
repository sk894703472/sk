package cn.edu.xupt.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.springframework.stereotype.Component;

@Component("baseDao")
public class BaseDaoIml<T> implements BaseDao<T> {

   //@PersistenceContext(unitName="sjPU")
   protected EntityManager entityManager=EntityManagerHelper.getEntityManager();
   
   
   public boolean delete(Object object) {
       try {
           entityManager.remove(object);
           return true;
       } catch (Exception e) {
           e.printStackTrace();
       }
       return false;
   }

   public Object findById(Class<T> c,Integer id) {
       try {
           return entityManager.find(c, id);
       } catch (Exception e) {
           e.printStackTrace();
       }
       return null;
   }
   @SuppressWarnings("unchecked")
   public List<T> findByProperty(final String table,final String propertyName,final Object value) {
	   try {
		   final String queryString = "select * from "+table+" model where model."
					+ propertyName + "="+value;
			Query query = entityManager.createNativeQuery(queryString);
			//query.setParameter("propertyValue", value);
			return query.getResultList();
		} catch (RuntimeException re) {
			re.printStackTrace();
		}
	   return null;
   }
   public boolean save(Object object) {
       try {
           entityManager.persist(object);
           return true;
       } catch (Exception e) {
           e.printStackTrace();
       }
       return false;
   }

   public boolean update(Object object) {
       try {
           entityManager.merge(object);
           return true;
       } catch (Exception e) {
           e.printStackTrace();
       }
       return false;
   }

   @SuppressWarnings("unchecked")
   public List<T> listAll(final String table) {
       try {
           Query query=entityManager.createQuery(" from "+table);
           return query.getResultList();
       } catch (Exception e) {
           e.printStackTrace();
       }
       return null;
   }

}
