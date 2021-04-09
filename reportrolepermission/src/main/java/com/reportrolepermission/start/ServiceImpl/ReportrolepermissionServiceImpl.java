package com.reportrolepermission.start.ServiceImpl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.reportrolepermission.start.Dao.ReportrolepermissionDao;
import com.reportrolepermission.start.Service.ReportrolepermissionService;

@Service
public class ReportrolepermissionServiceImpl implements ReportrolepermissionService {

	@Autowired
	private ReportrolepermissionDao reportrolepermissiondao;
	
	@Override
	public Object addReportrolepermission(Map<String,Object> inputs) throws Exception {
		// TODO Auto-generated method stub
		inputs.put("IsActive", "A");
		this.reportrolepermissiondao.addReportrolepermission(inputs);
		return "Reportrolepermissiondao Value added";
	}

	@Override
	public List<Object> getReportrolepermission(Map<String,Object> inputs) throws Exception {
		// TODO Auto-generated method stub
		inputs.put("IsActive", "A");
		List<Object> rows =(List<Object>) this.reportrolepermissiondao.getReportrolepermission(inputs);
		return (!rows.isEmpty()) ? rows : new ArrayList();
	}

	@Override
	public Object updateReportrolepermission(Map<String,Object> inputs) throws Exception {
		// TODO Auto-generated method stub
		String org_code=(String)inputs.get("Org_Code");
		String subdomain_code=(String)inputs.get("Subdomain_Code");
		String role_code=(String)inputs.get("Role_Code");
		String report_code=(String)inputs.get("Report_Code");
		inputs.put("org_code", org_code);
		inputs.put("subdomain_code", subdomain_code);
		inputs.put("role_code", role_code);
		inputs.put("report_code", report_code);
		inputs.put("isActive", "A");
		
		this.reportrolepermissiondao.updateReportrolepermission(inputs);
		return "Reportrolepermission Value Updated";
	}

	@Override
	public void deleteReportrolepermission(String org_code, String subdomain_code, String role_code, String report_code)
			throws Exception {
		// TODO Auto-generated method stub
		this.reportrolepermissiondao.deleteReportrolepermission(org_code, subdomain_code, role_code, report_code);
		
	}

}
