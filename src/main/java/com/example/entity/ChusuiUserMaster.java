package com.example.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.Table;


/**
 * The persistent class for the chusui_user_master database table.
 *
 */
@Entity
@Table(name="chusui_user_master")
@NamedQuery(name="ChusuiUserMaster.findAll", query="SELECT c FROM ChusuiUserMaster c")
public class ChusuiUserMaster implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="user_id")
	@GeneratedValue
	private Integer userId;

	@Column(name="user_lastname")
	private String userLastName;

	@Column(name="user_firstname")
	private String userFirstName;

	@Column(name="user_password")
	private String userPassword;

	@Column(name="user_email")
	private String userEmail;

	public ChusuiUserMaster() {
	}

	public Integer getUserId() {
		return this.userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public String getUserLastName() {
		return this.userLastName;
	}

	public void setUserLastName(String userLastName) {
		this.userLastName = userLastName;
	}

	public String getUserFirstName() {
		return this.userFirstName;
	}

	public void setUserFirstName(String userFirstName) {
		this.userFirstName = userFirstName;
	}

	public String getUserPassword() {
		return this.userPassword;
	}

	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}

	public String getUserEmail() {
		return this.userEmail;
	}

	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}

}