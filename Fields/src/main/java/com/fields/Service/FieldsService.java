package com.fields.Service;

import java.util.List;
import java.util.Map;

public interface FieldsService {

	public Object addFields(Map<String,Object> inputs) throws Exception;
	public Object updateFields(Map<String,Object> inputs) throws Exception;
	public Object delFields(String field_code) throws Exception;
	public List<Object> getFields(Map<String,Object> inputs) throws Exception;
}
