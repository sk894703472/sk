package cn.edu.xupt.bean;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Goodsinformation entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "goodsinformation")
public class Goodsinformation implements java.io.Serializable {

	// Fields

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Integer goodsId;
	private String goodsName;
	private Integer goodsNum;
	private Double goodsPrice;

	// Constructors

	/** default constructor */
	public Goodsinformation() {
	}

	/** minimal constructor */
	public Goodsinformation(Integer goodsId) {
		this.goodsId = goodsId;
	}

	/** full constructor */
	public Goodsinformation(Integer goodsId, String goodsName,
			Integer goodsNum, Double goodsPrice) {
		this.goodsId = goodsId;
		this.goodsName = goodsName;
		this.goodsNum = goodsNum;
		this.goodsPrice = goodsPrice;
	}

	// Property accessors
	@Id
	@Column(name = "goodsId", unique = true, nullable = false)
	public Integer getGoodsId() {
		return this.goodsId;
	}

	public void setGoodsId(Integer goodsId) {
		this.goodsId = goodsId;
	}

	@Column(name = "goodsName", length = 16)
	public String getGoodsName() {
		return this.goodsName;
	}

	public void setGoodsName(String goodsName) {
		this.goodsName = goodsName;
	}

	@Column(name = "goodsNum")
	public Integer getGoodsNum() {
		return this.goodsNum;
	}

	public void setGoodsNum(Integer goodsNum) {
		this.goodsNum = goodsNum;
	}

	@Column(name = "goodsPrice", precision = 22, scale = 0)
	public Double getGoodsPrice() {
		return this.goodsPrice;
	}

	public void setGoodsPrice(Double goodsPrice) {
		this.goodsPrice = goodsPrice;
	}

}

