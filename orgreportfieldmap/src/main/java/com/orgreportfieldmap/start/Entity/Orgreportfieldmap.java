package com.orgreportfieldmap.start.Entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

@Entity
@Table(name = "orgreportfieldmap")
public class Orgreportfieldmap {

	@EmbeddedId
	private OrgreportfieldmapPK id;
	
	@Column(name = "IsActive")
	private String isActive;
	
	@Column(name = "Created_By")
	private String created_by;
	
	//@CreationTimestamp
	@Column(name = "Created_DateTime")
	private Date created_datetime;
	
	@Column(name = "Modified_By")
	private String modified_by;
	
	//@UpdateTimestamp
	@Column(name = "Modified_DateTime")
	private Date modified_datetime;

	public Orgreportfieldmap() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Orgreportfieldmap(OrgreportfieldmapPK id, String isActive, String created_by, Date created_datetime,
			String modified_by, Date modified_datetime) {
		super();
		this.id = id;
		this.isActive = isActive;
		this.created_by = created_by;
		this.created_datetime = created_datetime;
		this.modified_by = modified_by;
		this.modified_datetime = modified_datetime;
	}

	public OrgreportfieldmapPK getId() {
		return id;
	}

	public void setId(OrgreportfieldmapPK id) {
		this.id = id;
	}

	public String getIsActive() {
		return isActive;
	}

	public void setIsActive(String isActive) {
		this.isActive = isActive;
	}

	public String getCreated_by() {
		return created_by;
	}

	public void setCreated_by(String created_by) {
		this.created_by = created_by;
	}

	public Date getCreated_datetime() {
		return created_datetime;
	}

	public void setCreated_datetime(Date created_datetime) {
		this.created_datetime = created_datetime;
	}

	public String getModified_by() {
		return modified_by;
	}

	public void setModified_by(String modified_by) {
		this.modified_by = modified_by;
	}

	public Date getModified_datetime() {
		return modified_datetime;
	}

	public void setModified_datetime(Date modified_datetime) {
		this.modified_datetime = modified_datetime;
	}
	
}
