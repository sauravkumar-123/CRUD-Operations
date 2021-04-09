package com.orgreportfieldmap.start.Service;

import java.util.List;
import java.util.Map;

public interface OrgreportfieldmapService {

	public Object addOrgreportfieldmap(Map<String,Object> inputs) throws Exception;
	public List<Object> getOrgreportfieldmap(Map<String,Object> inputs) throws Exception;
	public Object updateOrgreportfieldmap(Map<String,Object> inputs) throws Exception;
	public void deleteOrgreportfieldmap(String org_code,String domain_code,String subdomain_code,String report_code, String field_Code) throws Exception;
}
