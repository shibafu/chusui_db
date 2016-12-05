package com.example.entity;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the product_master database table.
 * 
 */
@Entity
@Table(name="product_master")
@NamedQuery(name="ProductMaster.findAll", query="SELECT p FROM ProductMaster p")
public class ProductMaster implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="product_id")
	private Integer productId;

	@Column(name="maker_name")
	private String makerName;

	@Column(name="product_name")
	private String productName;

	@Column(name="sending_exowner_name")
	private String sendingExownerName;

	@Column(name="size_standard")
	private String sizeStandard;

	public ProductMaster() {
	}

	public Integer getProductId() {
		return this.productId;
	}

	public void setProductId(Integer productId) {
		this.productId = productId;
	}

	public String getMakerName() {
		return this.makerName;
	}

	public void setMakerName(String makerName) {
		this.makerName = makerName;
	}

	public String getProductName() {
		return this.productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public String getSendingExownerName() {
		return this.sendingExownerName;
	}

	public void setSendingExownerName(String sendingExownerName) {
		this.sendingExownerName = sendingExownerName;
	}

	public String getSizeStandard() {
		return this.sizeStandard;
	}

	public void setSizeStandard(String sizeStandard) {
		this.sizeStandard = sizeStandard;
	}

}