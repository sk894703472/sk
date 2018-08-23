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


import edu.ec.entity.Product;
import edu.ec.entity.User;
import edu.ec.util.JdbcUtils;

public class ProductDao {
	public void insert(EntityManager em,String id,String name,String type,String price){
		Product prod = new Product();
		prod.setId(id);
		prod.setName(name);
		prod.setType(type);
		prod.setPrice(price);
		em.getTransaction().begin();
		em.persist(prod);
		em.getTransaction().commit();
	}
	public void delete(EntityManager em,String id){
		em.getTransaction().begin();
		Product prod = (Product) em.find(Product.class, id);
	    em.remove(prod);
	    em.getTransaction().commit();
	}
	public void update(EntityManager em,String price,String id){
		em.getTransaction().begin();
//      User s = (User) em.find(User.class, name);
		Product prod = em.getReference(Product.class, id);
      System.out.println("Student id = " + prod.getId());
      System.out.println("Student Name = " + prod.getName());
      System.out.println("Student Age = " + prod.getType());
      System.out.println("Student Price = " + prod.getPrice());
      prod.setPrice(price);
      System.out.println("Student id = " + prod.getId());
      System.out.println("Student Name = " + prod.getName());
      System.out.println("Student Age = " + prod.getType());
      System.out.println("Student Price = " + prod.getPrice());
      em.getTransaction().commit();
	}
	public List<Product> selectAll(EntityManager em){
		Query query = em.createNativeQuery("select id,name,price,type from product_ec",Product.class);
		return query.getResultList();
	}
	public List<Product> selectName(EntityManager em,String name){
		Query query = em.createNativeQuery("select id,name,price,type from product_ec where name='"+name+"'",Product.class);
		return query.getResultList();
	}
	public List<Product> selectId(EntityManager em,String id){
		Query query = em.createNativeQuery("select id,name,price,type from product_ec where id='"+id+"'",Product.class);
		return query.getResultList();
	}
	public List<Product> selectType(EntityManager em,String type){
		Query query = em.createNativeQuery("select id,name,price,type from product_ec where type='"+type+"'",Product.class);
		return query.getResultList();
	}
	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("jpaProduct");
        EntityManager em = emf.createEntityManager();
        ProductDao jpa_prod = new ProductDao();
        jpa_prod.insert(em,"3682", "asx", "tool","455");
        jpa_prod.update(em, "3422", "5");
        jpa_prod.delete(em, "3223");
       List<Product> list = jpa_prod.selectName(em,"skk");
       for (Product pro : list) {
			System.out.println(pro);
		}
        em.close();
        emf.close();
	}
}
