package cn.edu.xupt.bean;

import java.sql.Timestamp;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import cn.edu.xupt.bean.Users;


/**
 * Orders entity. @author MyEclipse Persistence Tools
 */
@SuppressWarnings("serial")
@Entity
@Table(name = "orders")
public class Orders implements java.io.Serializable {

	// Fields

	private Integer ordersId;
	private Users users;
	private Goodsinformation goodsinformation;
	private Timestamp time;

	// Constructors

	/** default constructor */
	public Orders() {
	}

	/** minimal constructor */
	public Orders(Integer ordersId) {
		this.ordersId = ordersId;
	}

	/** full constructor */
	

	// Property accessors
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "ordersid", unique = true, nullable = false)
	public Integer getOrdersId() {
		return this.ordersId;
	}

	public Orders(Integer ordersId, Users users, Goodsinformation goodsinformation, Timestamp time) {
		super();
		this.ordersId = ordersId;
		this.users = users;
		this.goodsinformation = goodsinformation;
		this.time = time;
	}

	public void setOrdersId(Integer ordersId) {
		this.ordersId = ordersId;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "userid")//维护在多的一方，外键
	public Users getUsers() {
		return this.users;
	}

	public void setUsers(Users users) {
		this.users = users;
	}

	@Column(name = "time", length = 19)
	public Timestamp getTime() {
		return this.time;
	}

	public void setTime(Timestamp time) {
		this.time = time;
	}
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "goodsid")
	public Goodsinformation getGoodsinformation() {
		return goodsinformation;
	}

	public void setGoodsinformation(Goodsinformation goodsinformation) {
		this.goodsinformation = goodsinformation;
	}

}