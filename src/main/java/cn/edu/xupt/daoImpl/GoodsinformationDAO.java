package cn.edu.xupt.daoImpl;

import java.util.List;
import java.util.logging.Level;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import cn.edu.xupt.bean.Goodsinformation;
import cn.edu.xupt.dao.EntityManagerHelper;
import cn.edu.xupt.dao.IGoodsinformationDAO;
@Repository("goodsinformationDAO")
public class GoodsinformationDAO implements IGoodsinformationDAO {
	// property constants
	public  final String TABLE = "Goodsinfomation";
	public final String GOODS_NUM = "goodsNum";
	public  final String GOODS_PRICE = "goodsPrice";
	public  final String GOODS_ID = "goodsId";
	public  final String GOODS_NAME = "goodsName";
	private EntityManager getEntityManager() {
		return EntityManagerHelper.getEntityManager();
	}
		public void save(Goodsinformation entity) {
			EntityManagerHelper.log("saving Goodsinformation instance", Level.INFO,
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
		}
		public void delete(Goodsinformation entity) {
			EntityManagerHelper.log("deleting Goodsinformation instance",
					Level.INFO, null);
			try {
				EntityManager em=getEntityManager();
				em.getTransaction().begin();
				entity = em.getReference(Goodsinformation.class,entity.getGoodsId());
				em.remove(entity);
				em.getTransaction().commit();
				EntityManagerHelper.log("delete successful", Level.INFO, null);
			} catch (RuntimeException re) {
				EntityManagerHelper.log("delete failed", Level.SEVERE, re);
				throw re;
			}
		}

		
		public Goodsinformation update(Goodsinformation entity) {
			EntityManagerHelper.log("updating Goodsinformation instance",
					Level.INFO, null);
			try {
				EntityManager em=getEntityManager();
				em.getTransaction().begin();
				Goodsinformation result = getEntityManager().merge(entity);
				em.getTransaction().commit();
				EntityManagerHelper.log("update successful", Level.INFO, null);
				return result;
			} catch (RuntimeException re) {
				EntityManagerHelper.log("update failed", Level.SEVERE, re);
				throw re;
			}
		}

		public Goodsinformation findById(Integer id) {
			EntityManagerHelper.log("finding Goodsinformation instance with id: "
					+ id, Level.INFO, null);
			try {
				EntityManager em=getEntityManager();
				em.getTransaction().begin();
				Goodsinformation instance =em.find(Goodsinformation.class, id);
				em.getTransaction().commit();
				return instance;
			} catch (RuntimeException re) {
				EntityManagerHelper.log("find failed", Level.SEVERE, re);
				throw re;
			}
		}
		@SuppressWarnings("unchecked")
		public List<Goodsinformation> findByProperty(String propertyName,
				final Object value) {
			EntityManagerHelper.log(
					"finding Goodsinformation instance with property: "
							+ propertyName + ", value: " + value, Level.INFO, null);
			try {
				final String queryString = "select model from Goodsinformation model where model."
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

		public List<Goodsinformation> findByGoodsName(Object goodsName) {
			return findByProperty(GOODS_NAME, goodsName);
		}
		
		public List<Goodsinformation> findByGoodsNum(Object goodsNum) {
			return findByProperty(GOODS_NUM, goodsNum);
		}

		public List<Goodsinformation> findByGoodsPrice(Object goodsPrice) {
			return findByProperty(GOODS_PRICE, goodsPrice);
		}

		
		@SuppressWarnings("unchecked")
		public List<Goodsinformation> findAll() {
			EntityManagerHelper.log("finding all Goodsinformation instances",
					Level.INFO, null);
			try {
				final String queryString = "select model from Goodsinformation model";
				Query query = getEntityManager().createQuery(queryString);
				return query.getResultList();
			} catch (RuntimeException re) {
				EntityManagerHelper.log("find all failed", Level.SEVERE, re);
				throw re;
			}
		}
//	public List<Goodsinformation> findAllGoodsinformation() {
//		String sqlString="select goodsId,goodsName,goodsNum,goodsPrice from goodsinformation";
//		//System.out.println(entityManager);
//		Query query= getEntityManager().createNativeQuery(sqlString, Goodsinformation.class);
//		@SuppressWarnings("unchecked")
//		List<Goodsinformation> list=query.getResultList();
//		return list;
//		//return listAll(TABLE);
//	}
	public int updateGoodsNumber(Goodsinformation goodsinformation) {
		// TODO Auto-generated method stub
		String sqlString="update goodsinformation set goodsnum=goodsnumber+"+
		goodsinformation.getGoodsNum()+" where goodsid="+goodsinformation.getGoodsId();
		Query query= getEntityManager().createNativeQuery(sqlString, Goodsinformation.class);
		int n=query.executeUpdate();
		return n;
	}
	
}