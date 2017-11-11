package com.example.entity;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the picture_master database table.
 * 
 */
@Entity
@Table(name="picture_master")
@NamedQuery(name="PictureMaster.findAll", query="SELECT p FROM PictureMaster p")
public class PictureMaster implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="picture_id")
	private Long pictureId;

	@Column(name="picture_data")
	private byte[] pictureData;

	public PictureMaster() {
	}

	public Long getPictureId() {
		return this.pictureId;
	}

	public void setPictureId(Long pictureId) {
		this.pictureId = pictureId;
	}

	public byte[] getPictureData() {
		return this.pictureData;
	}

	public void setPictureData(byte[] pictureData) {
		this.pictureData = pictureData;
	}

}