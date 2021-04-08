package com.fields.Dao;

import java.util.List;
import java.util.Map;

public interface FieldsDao {
	
	public Object addFields(Map<String,Object> inputs) throws Exception;
	public Object updateFields(Map<String,Object> inputs) throws Exception;
	public Object delFields(String id) throws Exception;
	public List<Object> getFields(Map<String,Object> inputs) throws Exception;
	
}
