package com.fields.Entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

@Entity
@Table(name = "fields")
public class Fields {

	@Id
	@Column(name = "Field_Code")
	private String field_code;
	
	@Column(name = "Field_Name")
	private String field_name;
	
	@Column(name = "Field_Description")
	private String field_description;
	
	@Column(name = "Field_Type_Code")
	private String field_type_code;
	
	@Column(name = "Default_Value")
	private String default_value;
	
	@Column(name = "Field_Data_Type")
	private String field_data_type;
	
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

	
	public Fields() {
		super();
		// TODO Auto-generated constructor stub
	}


	public Fields(String field_code, String field_name, String field_description, String field_type_code,
			String default_value, String field_data_type, String isActive, String created_by, Date created_datetime,
			String modified_by, Date modified_datetime) {
		super();
		this.field_code = field_code;
		this.field_name = field_name;
		this.field_description = field_description;
		this.field_type_code = field_type_code;
		this.default_value = default_value;
		this.field_data_type = field_data_type;
		this.isActive = isActive;
		this.created_by = created_by;
		this.created_datetime = created_datetime;
		this.modified_by = modified_by;
		this.modified_datetime = modified_datetime;
	}


	public String getField_code() {
		return field_code;
	}


	public void setField_code(String field_code) {
		this.field_code = field_code;
	}


	public String getField_name() {
		return field_name;
	}


	public void setField_name(String field_name) {
		this.field_name = field_name;
	}


	public String getField_description() {
		return field_description;
	}


	public void setField_description(String field_description) {
		this.field_description = field_description;
	}


	public String getField_type_code() {
		return field_type_code;
	}


	public void setField_type_code(String field_type_code) {
		this.field_type_code = field_type_code;
	}


	public String getDefault_value() {
		return default_value;
	}


	public void setDefault_value(String default_value) {
		this.default_value = default_value;
	}


	public String getField_data_type() {
		return field_data_type;
	}


	public void setField_data_type(String field_data_type) {
		this.field_data_type = field_data_type;
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
