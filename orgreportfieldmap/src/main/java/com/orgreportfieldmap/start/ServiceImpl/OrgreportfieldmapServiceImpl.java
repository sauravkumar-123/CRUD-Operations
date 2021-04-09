package com.orgreportfieldmap.start.ServiceImpl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.orgreportfieldmap.start.Dao.OrgreportfieldmapDao;
import com.orgreportfieldmap.start.Service.OrgreportfieldmapService;

@Service
public class OrgreportfieldmapServiceImpl implements OrgreportfieldmapService {

	@Autowired
	private OrgreportfieldmapDao OrgreportfieldmapDao;
	
	@Override
	public Object addOrgreportfieldmap(Map<String,Object> inputs) throws Exception {
		// TODO Auto-generated method stub
		inputs.put("IsActive", "A");
		this.OrgreportfieldmapDao.addOrgreportfieldmap(inputs);
		return "Orgreportfieldmap Value added";
	}

	@Override
	public List<Object> getOrgreportfieldmap(Map<String,Object> inputs) throws Exception {
		// TODO Auto-generated method stub
		inputs.put("IsActive", "A");
		List<Object> rows =(List<Object>) this.OrgreportfieldmapDao.getOrgreportfieldmap(inputs);
		return (!rows.isEmpty()) ? rows : new ArrayList();
	}

	@Override
	public Object updateOrgreportfieldmap(Map<String,Object> inputs) throws Exception {
		// TODO Auto-generated method stub
		String org_code=(String)inputs.get("Org_Code");
		String domain_code=(String)inputs.get("Domain_Code");
		String subdomain_code=(String)inputs.get("Subdomain_Code");
		String report_code=(String)inputs.get("Report_Code");
		String field_code=(String)inputs.get("Field_Code");
		inputs.put("org_code", org_code);
		inputs.put("domain_code", domain_code);
		inputs.put("subdomain_code", subdomain_code);
		inputs.put("report_code", report_code);
		inputs.put("field_code", field_code);
		inputs.put("isActive", "A");
		
		this.OrgreportfieldmapDao.updateOrgreportfieldmap(inputs);
		return "Orgreportfieldmap Value Updated";
	}

	@Override
	public void deleteOrgreportfieldmap(String org_code, String domain_code, String subdomain_code, String report_code,
			String field_Code) throws Exception {
		// TODO Auto-generated method stub
		
		this.OrgreportfieldmapDao.deleteOrgreportfieldmap(org_code, domain_code, subdomain_code, report_code, field_Code);
		
	}

}
