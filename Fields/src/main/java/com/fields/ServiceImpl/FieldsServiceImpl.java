package com.fields.ServiceImpl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fields.Dao.FieldsDao;
import com.fields.DaoImpl.FieldsDaoImpl;
import com.fields.Entity.Fields;
import com.fields.Service.FieldsService;

@Service
public class FieldsServiceImpl implements FieldsService {

	@Autowired
	public FieldsDao fieldsdao;
	
	@Override
	public Object addFields(Map<String,Object> inputs) throws Exception {
		// TODO Auto-generated method stub
		inputs.put("IsActive", "A");
		this.fieldsdao.addFields(inputs);
		return "Fields Value added";
		
	}

	@Override
	public Object updateFields(Map<String,Object> inputs) throws Exception {
		// TODO Auto-generated method stub
		String field_id=(String)inputs.get("Field_Code");
		inputs.put("field_code", field_id);
		inputs.put("isActive", "A");
		
		this.fieldsdao.updateFields(inputs);
		return "Fields Value Updated";
	}

	@Override
	public Object delFields(String field_code) throws Exception {
		// TODO Auto-generated method stub
		return this.fieldsdao.delFields(field_code);
	}

	@Override
	public List<Object> getFields(Map<String,Object> inputs) throws Exception {
		// TODO Auto-generated method stub
		inputs.put("IsActive", "A");
		List<Object> rows =(List<Object>) this.fieldsdao.getFields(inputs);
		return (!rows.isEmpty()) ? rows : new ArrayList();
	}

	
}
