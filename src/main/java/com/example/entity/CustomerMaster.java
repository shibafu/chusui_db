package com.example.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
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
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer customerId;

	@Column(name="addres")
	private String addres;

	@Column(name="company_block")
	private String companyBlock;

	@Column(name="customer_lastname")
	private String customerLastName;

	@Column(name="customer_firstname")
	private String customerFirstName;

	@Column(name="customer_password")
	private String customerPassword;

	@Column(name="email")
	private String email;

	@Column(name="system_num")
	private String systemNum;

	@Column(name="company_name")
	private String companyName;

	@Column(name="authority")
	private String authority;

	@Column(name="enabled")
	private Boolean enabled;

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
	public String getCompanyName() {
		return this.companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	public String getAuthority() {
		return this.authority;
	}

	public void setAuthority(String authority) {
		this.authority = authority;
	}

	public Boolean getEnabled() {
		return this.enabled;
	}

	public void setEnabled(Boolean enabled) {
		this.enabled = enabled;
	}
}