package com.orgreportfieldmap.start.Entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class OrgreportfieldmapPK implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Column(name = "Org_Code")
	private String org_code;
	
	@Column(name= "Domain_Code")
	private String domain_code;
	
	@Column(name = "Subdomain_Code")
	private String  subdomain_code;
	
	@Column(name="Report_Code")
	private String report_code;
	
	@Column(name = "Field_Code")
	private String field_code;

	public OrgreportfieldmapPK() {
		super();
		// TODO Auto-generated constructor stub
	}

	public OrgreportfieldmapPK(String org_code, String domain_code, String subdomain_code, String report_code,
			String field_code) {
		super();
		this.org_code = org_code;
		this.domain_code = domain_code;
		this.subdomain_code = subdomain_code;
		this.report_code = report_code;
		this.field_code = field_code;
	}

	public String getOrg_code() {
		return org_code;
	}

	public void setOrg_code(String org_code) {
		this.org_code = org_code;
	}

	public String getDomain_code() {
		return domain_code;
	}

	public void setDomain_code(String domain_code) {
		this.domain_code = domain_code;
	}

	public String getSubdomain_code() {
		return subdomain_code;
	}

	public void setSubdomain_code(String subdomain_code) {
		this.subdomain_code = subdomain_code;
	}

	public String getReport_code() {
		return report_code;
	}

	public void setReport_code(String report_code) {
		this.report_code = report_code;
	}

	public String getField_code() {
		return field_code;
	}

	public void setField_code(String field_code) {
		this.field_code = field_code;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((domain_code == null) ? 0 : domain_code.hashCode());
		result = prime * result + ((field_code == null) ? 0 : field_code.hashCode());
		result = prime * result + ((org_code == null) ? 0 : org_code.hashCode());
		result = prime * result + ((report_code == null) ? 0 : report_code.hashCode());
		result = prime * result + ((subdomain_code == null) ? 0 : subdomain_code.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		OrgreportfieldmapPK other = (OrgreportfieldmapPK) obj;
		if (domain_code == null) {
			if (other.domain_code != null)
				return false;
		} else if (!domain_code.equals(other.domain_code))
			return false;
		if (field_code == null) {
			if (other.field_code != null)
				return false;
		} else if (!field_code.equals(other.field_code))
			return false;
		if (org_code == null) {
			if (other.org_code != null)
				return false;
		} else if (!org_code.equals(other.org_code))
			return false;
		if (report_code == null) {
			if (other.report_code != null)
				return false;
		} else if (!report_code.equals(other.report_code))
			return false;
		if (subdomain_code == null) {
			if (other.subdomain_code != null)
				return false;
		} else if (!subdomain_code.equals(other.subdomain_code))
			return false;
		return true;
	}
	
}
