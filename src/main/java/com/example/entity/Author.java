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
	@Column(name="author_id")
	private Integer authorId;

	@Column(name="author_firstname")
	private String authorFirstname;

	@Column(name="author_lastname")
	private String authorLastname;

	private String authority;

	private String email;

	private Boolean enabled;

	private String password;

	public Author() {
	}

	public Integer getAuthorId() {
		return this.authorId;
	}

	public void setAuthorId(Integer authorId) {
		this.authorId = authorId;
	}

	public String getAuthorFirstname() {
		return this.authorFirstname;
	}

	public void setAuthorFirstname(String authorFirstname) {
		this.authorFirstname = authorFirstname;
	}

	public String getAuthorLastname() {
		return this.authorLastname;
	}

	public void setAuthorLastname(String authorLastname) {
		this.authorLastname = authorLastname;
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

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

}