package com.example.entity;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the "Warehouse_master" database table.
 * 
 */
@Entity
@Table(name="\"Warehouse_master\"")
@NamedQuery(name="Warehouse_master.findAll", query="SELECT w FROM Warehouse_master w")
public class WarehouseMaster implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="warehouse_id")
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