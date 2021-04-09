package com.reportrolepermission.start.Model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class ReportrolepermissionPK implements Serializable {
	
	private static final long serialVersionUID = 1L;

	
	@Column(name = "Org_Code")
	private String org_code;
	
	@Column(name = "Subdomain_Code")
	private String  subdomain_code;
	
	@Column(name="Role_Code")
	private String role_code;
	
	@Column(name="Report_Code")
	private String report_code;

	public ReportrolepermissionPK() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ReportrolepermissionPK(String org_code, String subdomain_code, String role_code, String report_code) {
		super();
		this.org_code = org_code;
		this.subdomain_code = subdomain_code;
		this.role_code = role_code;
		this.report_code = report_code;
	}

	public String getOrg_code() {
		return org_code;
	}

	public void setOrg_code(String org_code) {
		this.org_code = org_code;
	}

	public String getSubdomain_code() {
		return subdomain_code;
	}

	public void setSubdomain_code(String subdomain_code) {
		this.subdomain_code = subdomain_code;
	}

	public String getRole_code() {
		return role_code;
	}

	public void setRole_code(String role_code) {
		this.role_code = role_code;
	}

	public String getReport_code() {
		return report_code;
	}

	public void setReport_code(String report_code) {
		this.report_code = report_code;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((org_code == null) ? 0 : org_code.hashCode());
		result = prime * result + ((report_code == null) ? 0 : report_code.hashCode());
		result = prime * result + ((role_code == null) ? 0 : role_code.hashCode());
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
		ReportrolepermissionPK other = (ReportrolepermissionPK) obj;
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
		if (role_code == null) {
			if (other.role_code != null)
				return false;
		} else if (!role_code.equals(other.role_code))
			return false;
		if (subdomain_code == null) {
			if (other.subdomain_code != null)
				return false;
		} else if (!subdomain_code.equals(other.subdomain_code))
			return false;
		return true;
	}

}
