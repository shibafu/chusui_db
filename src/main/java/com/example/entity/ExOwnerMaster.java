package com.example.entity;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the ex_owner_master database table.
 * 
 */
@Entity
@Table(name="ex_owner_master")
@NamedQuery(name="ExOwnerMaster.findAll", query="SELECT e FROM ExOwnerMaster e")
public class ExOwnerMaster implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="sending_exowner_id")
	private Integer sendingExownerId;

	@Column(name="sending_ex_owner_master")
	private String sendingExOwnerMaster;

	public ExOwnerMaster() {
	}

	public Integer getSendingExownerId() {
		return this.sendingExownerId;
	}

	public void setSendingExownerId(Integer sendingExownerId) {
		this.sendingExownerId = sendingExownerId;
	}

	public String getSendingExOwnerMaster() {
		return this.sendingExOwnerMaster;
	}

	public void setSendingExOwnerMaster(String sendingExOwnerMaster) {
		this.sendingExOwnerMaster = sendingExOwnerMaster;
	}

}