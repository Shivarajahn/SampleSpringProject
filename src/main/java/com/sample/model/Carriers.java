package com.sample.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "carriers")
public class Carriers implements Serializable {
	
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="carrier_id")
	private String carrier_id;
	
	@Column(name="description")
	private String description;
	
	@Column(name="status")
	private String status;

	public String getCarrier_id() {
		return carrier_id;
	}

	public void setCarrier_id(String carrier_id) {
		this.carrier_id = carrier_id;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}




}
