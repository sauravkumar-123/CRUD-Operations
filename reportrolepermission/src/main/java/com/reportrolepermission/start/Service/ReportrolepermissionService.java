package com.reportrolepermission.start.Service;

import java.util.List;
import java.util.Map;

public interface ReportrolepermissionService {

	public Object addReportrolepermission(Map<String,Object> inputs) throws Exception;
	public List<Object> getReportrolepermission(Map<String,Object> inputs) throws Exception;
	public Object updateReportrolepermission(Map<String,Object> inputs) throws Exception;
	public void deleteReportrolepermission(String org_code,String subdomain_code,String role_code, String report_code) throws Exception;
}
