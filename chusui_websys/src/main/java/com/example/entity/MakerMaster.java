package com.example.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.Table;


/**
 * The persistent class for the maker_master database table.
 * 
 */
@Entity
@Table(name="maker_master")
@NamedQuery(name="MakerMaster.findAll", query="SELECT m FROM MakerMaster m")
public class MakerMaster implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="maker_id")
	@GeneratedValue
	private Integer makerId;

	@Column(name="maker_name")
	private String makerName;

	public MakerMaster() {
	}

	public Integer getMakerId() {
		return this.makerId;
	}

	public void setMakerId(Integer makerId) {
		this.makerId = makerId;
	}

	public String getMakerName() {
		return this.makerName;
	}

	public void setMakerName(String makerName) {
		this.makerName = makerName;
	}

}