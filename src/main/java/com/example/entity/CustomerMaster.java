package com.example.entity;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the customer_master database table.
 * 
 */
@Entity
@Table(name="customer_master")
@NamedQuery(name="CustomerMaster.findAll", query="SELECT c FROM CustomerMaster c")
public class CustomerMaster implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="customer_id")
	private Integer customerId;

	private String addres;

	@Column(name="company_block")
	private String companyBlock;

	@Column(name="customer_name")
	private String customerName;

	@Column(name="customer_password")
	private String customerPassword;

	private String email;

	@Column(name="system_num")
	private String systemNum;

	public CustomerMaster() {
	}

	public Integer getCustomerId() {
		return this.customerId;
	}

	public void setCustomerId(Integer customerId) {
		this.customerId = customerId;
	}

	public String getAddres() {
		return this.addres;
	}

	public void setAddres(String addres) {
		this.addres = addres;
	}

	public String getCompanyBlock() {
		return this.companyBlock;
	}

	public void setCompanyBlock(String companyBlock) {
		this.companyBlock = companyBlock;
	}

	public String getCustomerName() {
		return this.customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public String getCustomerPassword() {
		return this.customerPassword;
	}

	public void setCustomerPassword(String customerPassword) {
		this.customerPassword = customerPassword;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getSystemNum() {
		return this.systemNum;
	}

	public void setSystemNum(String systemNum) {
		this.systemNum = systemNum;
	}

}