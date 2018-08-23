package edu.ec.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import edu.ec.entity.Inventory;
import edu.ec.entity.User;
import edu.ec.util.JdbcUtils;

public class InventoryDao {
	public void insert(EntityManager em,String sum,String user,String product){
		Inventory invent = new Inventory();
		invent.setSum(sum);
		invent.setUser(user);
		invent.setProduct(product);
		em.getTransaction().begin();
		em.persist(invent);
		em.getTransaction().commit();
	}
	public void delete(EntityManager em,String id){
		em.getTransaction().begin();
		Inventory i = (Inventory) em.find(Inventory.class, id);
	     em.remove(i);
	     em.getTransaction().commit();
	}
	public void update(EntityManager em,String sum,String id){
		em.getTransaction().begin();
        //User s = (User) em.find(User.class, name);
		Inventory i = em.getReference(Inventory.class, id);
        System.out.println("Student id = " + i.getId());
        System.out.println("Student Sum = " + i.getSum());
        System.out.println("Student user = " + i.getUser());
        System.out.println("Student product = " + i.getProduct());
        
        i.setSum(sum);
        System.out.println("Student id = " + i.getId());
        System.out.println("Student Sum = " + i.getSum());
        System.out.println("Student user = " + i.getUser());
        System.out.println("Student product = " + i.getProduct());
		em.getTransaction().commit();
	}
	public List<Inventory> selectAll(EntityManager em){
		Query query = em.createNativeQuery("select id,sum,user,product from inventory_ec",Inventory.class);
		return query.getResultList();
	}
	public List<Inventory> selectProduct(EntityManager em,String product){
		Query query = em.createNativeQuery("select id,sum,user,product from inventory_ec where product='"+product+"'",Inventory.class);
		return query.getResultList();
	}
	public List<Inventory> selectId(EntityManager em,String product){
		Query query = em.createNativeQuery("select id,sum,user,product from inventory_ec where id='"+product+"'",Inventory.class);
		return query.getResultList();
	}
	public List<Inventory> selectUser(EntityManager em,String product){
		Query query = em.createNativeQuery("select id,sum,user,product from inventory_ec where user='"+product+"'",Inventory.class);
		return query.getResultList();
	}
	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("user");
        EntityManager em = emf.createEntityManager();
        InventoryDao jpa_invent = new InventoryDao();
        jpa_invent.insert(em, "20", "sk", "egg");
        jpa_invent.update(em, "500", "9");
        jpa_invent.delete(em, "12");
        List<Inventory> list = jpa_invent.selectAll(em);
        for (Inventory invent : list) {
			System.out.println(invent);
		}
	}
}
