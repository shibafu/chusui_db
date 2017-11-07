package com.example.entity;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the "Author" database table.
 *
 */
@Entity
@Table(name="\"Author\"")
@NamedQuery(name="Author.findAll", query="SELECT a FROM Author a")
public class Author implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="user_id")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "author_id_gen")
    @SequenceGenerator(name = "author_id_gen", sequenceName = "author_user_id_serial", allocationSize = 1)
	private Integer userId;

	private String authority;

	private Boolean enabled;

	@Column(name="user_email")
	private String userEmail;

	@Column(name="user_firstname")
	private String userFirstname;

	@Column(name="user_lastname")
	private String userLastname;

	@Column(name="user_password")
	private String userPassword;

	public Author() {
	}

	public Integer getUserId() {
		return this.userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
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

	public String getUserEmail() {
		return this.userEmail;
	}

	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
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

	public String getUserPassword() {
		return this.userPassword;
	}

	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}

}