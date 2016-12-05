package com.example.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the stock_default_template database table.
 * 
 */
@Entity
@Table(name="stock_default_template")
@NamedQuery(name="StockDefaultTemplate.findAll", query="SELECT s FROM StockDefaultTemplate s")
public class StockDefaultTemplate implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="stock_id")
	private Integer stockId;

	@Column(name="case_num")
	private Integer caseNum;

	@Temporal(TemporalType.DATE)
	@Column(name="expiration_date")
	private Date expirationDate;

	@Column(name="maker_name")
	private String makerName;

	@Column(name="product_id")
	private Integer productId;

	@Column(name="product_name")
	private Integer productName;

	@Column(name="sending_exowner")
	private String sendingExowner;

	@Column(name="size_standard")
	private String sizeStandard;

	@Column(name="user_id")
	private Integer userId;

	@Column(name="warehouse_name")
	private String warehouseName;

	public StockDefaultTemplate() {
	}

	public Integer getStockId() {
		return this.stockId;
	}

	public void setStockId(Integer stockId) {
		this.stockId = stockId;
	}

	public Integer getCaseNum() {
		return this.caseNum;
	}

	public void setCaseNum(Integer caseNum) {
		this.caseNum = caseNum;
	}

	public Date getExpirationDate() {
		return this.expirationDate;
	}

	public void setExpirationDate(Date expirationDate) {
		this.expirationDate = expirationDate;
	}

	public String getMakerName() {
		return this.makerName;
	}

	public void setMakerName(String makerName) {
		this.makerName = makerName;
	}

	public Integer getProductId() {
		return this.productId;
	}

	public void setProductId(Integer productId) {
		this.productId = productId;
	}

	public Integer getProductName() {
		return this.productName;
	}

	public void setProductName(Integer productName) {
		this.productName = productName;
	}

	public String getSendingExowner() {
		return this.sendingExowner;
	}

	public void setSendingExowner(String sendingExowner) {
		this.sendingExowner = sendingExowner;
	}

	public String getSizeStandard() {
		return this.sizeStandard;
	}

	public void setSizeStandard(String sizeStandard) {
		this.sizeStandard = sizeStandard;
	}

	public Integer getUserId() {
		return this.userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public String getWarehouseName() {
		return this.warehouseName;
	}

	public void setWarehouseName(String warehouseName) {
		this.warehouseName = warehouseName;
	}

}