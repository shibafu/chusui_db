package com.tsugaruweb.entity;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the user_master database table.
 * 
 */
@Entity
@Table(name="user_master")
@NamedQuery(name="UserMaster.findAll", query="SELECT u FROM UserMaster u")
public class UserMaster implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="user_id")
	private Integer userId;

	private String address;

	private String authority;

	private String email;

	private Boolean enabled;

	private String hadlename;

	private String password;

	private String phone;

	@Column(name="user_firstname")
	private String userFirstname;

	@Column(name="user_lastname")
	private String userLastname;

	public UserMaster() {
	}

	public Integer getUserId() {
		return this.userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public String getAddress() {
		return this.address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getAuthority() {
		return this.authority;
	}

	public void setAuthority(String authority) {
		this.authority = authority;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Boolean getEnabled() {
		return this.enabled;
	}

	public void setEnabled(Boolean enabled) {
		this.enabled = enabled;
	}

	public String getHadlename() {
		return this.hadlename;
	}

	public void setHadlename(String hadlename) {
		this.hadlename = hadlename;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getPhone() {
		return this.phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getUserFirstname() {
		return this.userFirstname;
	}

	public void setUserFirstname(String userFirstname) {
		this.userFirstname = userFirstname;
	}

	public String getUserLastname() {
		return this.userLastname;
	}

	public void setUserLastname(String userLastname) {
		this.userLastname = userLastname;
	}

}