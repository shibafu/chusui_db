package com.example.entity;

import java.io.Serializable;
import javax.persistence.*;


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
	private Integer userId;

	@Column(name="user_name")
	private String userName;

	@Column(name="user_password")
	private String userPassword;

	public ChusuiUserMaster() {
	}

	public Integer getUserId() {
		return this.userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return this.userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getUserPassword() {
		return this.userPassword;
	}

	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}

}