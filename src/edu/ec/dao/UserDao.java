package edu.ec.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import edu.ec.entity.User;



public class UserDao {
	public void insert(EntityManager em, String name, String password){
		User users = new User();
		users.setName(name);
		users.setPassword(password);
		em.getTransaction().begin();
		em.persist(users);
		em.getTransaction().commit();
	}
	public void delete(EntityManager em,String id){
		 em.getTransaction().begin();
	     User s = (User) em.find(User.class, id);
	     em.remove(s);
	     em.getTransaction().commit();
	}
	public void update(EntityManager em,String password,String id,String name){
		em.getTransaction().begin();
        //User s = (User) em.find(User.class, name);
		User s = em.getReference(User.class, id);
        System.out.println("Student id = " + s.getId());
        System.out.println("Student Name = " + s.getName());
        System.out.println("Student Age = " + s.getPassword());
        s.setName(name);
        s.setPassword(password);
        
        System.out.println("Student id = " + s.getId());
        System.out.println("Student Name = " + s.getName());
        System.out.println("Student Age = " + s.getPassword());
		em.getTransaction().commit();
	}
	public List<User> selectAll(EntityManager em){  
		Query query = em.createNativeQuery("select id,name,password from user_ec",User.class);
		return query.getResultList();

	}
	public List<User> selectName(EntityManager em,String name){
		Query query = em.createNativeQuery("select id,password,name from user_ec where name='"+name+"'",User.class);
		return query.getResultList();
	}
	public List<User> selectId(EntityManager em,String id){
		Query query = em.createNativeQuery("select id,password,name from user_ec where id='"+id+"'",User.class);
		return query.getResultList();
	}
	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("user");
        EntityManager em = emf.createEntityManager();
        UserDao jpa_user = new UserDao();
        jpa_user.insert(em, "是的深V是", "35");
        jpa_user.delete(em, "12");
        jpa_user.update(em, "22", "16", "sdfff");
        jpa_user.selectName(em, "2");
        List<User> list = jpa_user.selectName(em,"sk");
        for (User user : list) {
			System.out.println(user);
		}
        em.close();
        emf.close();
	}
	 
}
