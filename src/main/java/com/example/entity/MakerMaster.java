package com.example.entity;

import java.io.Serializable;
import javax.persistence.*;


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