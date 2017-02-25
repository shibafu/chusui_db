package com.example.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.Table;


/**
 * The persistent class for the "Warehouse_master" database table.
 *
 */
@Entity
@Table(name="\"Warehouse_master\"")
@NamedQuery(name="WarehouseMaster.findAll", query="SELECT w FROM WarehouseMaster w")
public class WarehouseMaster implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="warehouse_id")
	@GeneratedValue
	private Integer warehouseId;

	@Column(name="warehouse_name")
	private String warehouseName;

	public WarehouseMaster() {
	}

	public Integer getWarehouseId() {
		return this.warehouseId;
	}

	public void setWarehouseId(Integer warehouseId) {
		this.warehouseId = warehouseId;
	}

	public String getWarehouseName() {
		return this.warehouseName;
	}

	public void setWarehouseName(String warehouseName) {
		this.warehouseName = warehouseName;
	}

}