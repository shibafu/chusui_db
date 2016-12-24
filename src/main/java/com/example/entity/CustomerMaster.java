package com.example.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.Table;


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
	@GeneratedValue
	private Integer customerId;

	private String addres;

	@Column(name="company_block")
	private String companyBlock;

	@Column(name="customer_lastname")
	private String customerLastName;

	@Column(name="customer_firstname")
	private String customerFirstName;

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

	public String getCustomerLastName() {
		return this. customerLastName;
	}

	public void setCustomerLastName(String customerLastName) {
		this. customerLastName = customerLastName;
	}

	public String getCustomerFirstName() {
		return this. customerFirstName;
	}

	public void setCustomerFirstName(String  customerFirstName) {
		this. customerFirstName =  customerFirstName;
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