package com.example.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;


/**
 * The persistent class for the proposal_default_template database table.
 * 
 */
@Entity
@Table(name="proposal_default_template")
@NamedQuery(name="ProposalDefaultTemplate.findAll", query="SELECT p FROM ProposalDefaultTemplate p")
public class ProposalDefaultTemplate implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="proposal_id")
	@GeneratedValue
	private Integer proposalId;

	@Column(name="availiable_num")
	private Integer availiableNum;

	@Column(name="customer_id")
	private Integer customerId;

	@Column(name="customer_name")
	private String customerName;

	@Temporal(TemporalType.DATE)
	@Column(name="effective_date")
	private Date effectiveDate;

	@Column(name="product_id")
	private Integer productId;

	@Column(name="product_name")
	private String productName;

	@Column(name="proposer_id")
	private Integer proposerId;

	@Column(name="proposer_name")
	private String proposerName;

	@Column(name="size_standard")
	private String sizeStandard;

	@Column(name="stock_id")
	private Integer stockId;

	@Column(name="warehouse_name")
	private String warehouseName;

	public ProposalDefaultTemplate() {
	}

	public Integer getProposalId() {
		return this.proposalId;
	}

	public void setProposalId(Integer proposalId) {
		this.proposalId = proposalId;
	}

	public Integer getAvailiableNum() {
		return this.availiableNum;
	}

	public void setAvailiableNum(Integer availiableNum) {
		this.availiableNum = availiableNum;
	}

	public Integer getCustomerId() {
		return this.customerId;
	}

	public void setCustomerId(Integer customerId) {
		this.customerId = customerId;
	}

	public String getCustomerName() {
		return this.customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public Date getEffectiveDate() {
		return this.effectiveDate;
	}

	public void setEffectiveDate(Date effectiveDate) {
		this.effectiveDate = effectiveDate;
	}

	public Integer getProductId() {
		return this.productId;
	}

	public void setProductId(Integer productId) {
		this.productId = productId;
	}

	public String getProductName() {
		return this.productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public Integer getProposerId() {
		return this.proposerId;
	}

	public void setProposerId(Integer proposerId) {
		this.proposerId = proposerId;
	}

	public String getProposerName() {
		return this.proposerName;
	}

	public void setProposerName(String proposerName) {
		this.proposerName = proposerName;
	}

	public String getSizeStandard() {
		return this.sizeStandard;
	}

	public void setSizeStandard(String sizeStandard) {
		this.sizeStandard = sizeStandard;
	}

	public Integer getStockId() {
		return this.stockId;
	}

	public void setStockId(Integer stockId) {
		this.stockId = stockId;
	}

	public String getWarehouseName() {
		return this.warehouseName;
	}

	public void setWarehouseName(String warehouseName) {
		this.warehouseName = warehouseName;
	}

}