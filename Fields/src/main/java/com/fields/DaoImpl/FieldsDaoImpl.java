package com.fields.DaoImpl;

import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import com.fields.Dao.FieldsDao;
import com.fields.Entity.Fields;

@Repository
public class FieldsDaoImpl implements FieldsDao {
	
	@PersistenceContext
	private EntityManager entityManager;

	@Transactional
	@Override
	public Object addFields(Map<String,Object> inputs) throws Exception {
		// TODO Auto-generated method stub
		Session session=entityManager.unwrap(Session.class);
		System.out.println("Inputs==>"+inputs);
		try {
			Fields fields=new Fields();
			fields.setField_code((String)inputs.get("Field_Code"));
			fields.setField_name((String)inputs.get("Field_Name"));
			fields.setField_description((String)inputs.get("Field_Description"));
			fields.setField_type_code((String)inputs.get("Field_Type_Code"));
			fields.setDefault_value((String)inputs.get("Default_Value"));
			fields.setField_data_type((String)inputs.get("Field_Data_Type"));
			fields.setIsActive((String)inputs.get("IsActive"));
			fields.setCreated_by((String)inputs.get("Created_By"));
			fields.setCreated_datetime(new Date());
			fields.setModified_by((String)inputs.get("Modified_By"));
			fields.setModified_datetime(new Date());
			
			//session.beginTransaction();
			session.save(fields);
			session.flush();
			//session.getTransaction().commit();
			return true;
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			throw new Exception("Invalid data");
		}
		
	}

	@Transactional
	@Override
	public Object updateFields(Map<String,Object> inputs) throws Exception {
		// TODO Auto-generated method stub
		System.out.println("Inputs===>"+inputs);
		Session session=entityManager.unwrap(Session.class);
		if(inputs.containsKey("Field_Name") || inputs.containsKey("Created_By")) {
			throw new Exception("Field_Name and Created_By shouldn't be updated");
		}
		
		try {
		//session.beginTransaction();
		Fields f=(Fields)session.get(Fields.class,(String) inputs.get("Field_Code"));
		
		f.setIsActive((null != inputs.get("IsActive")) ? (String)inputs.get("IsActive") : f.getIsActive());
		f.setField_description((null != inputs.get("Field_Description")) ? (String)inputs.get("Field_Description") : f.getField_description());
		f.setField_type_code((null != inputs.get("Field_Type_Code")) ? (String)inputs.get("Field_Type_Code") : f.getField_type_code());
		f.setDefault_value((null != inputs.get("Default_Value")) ? (String)inputs.get("Default_Value") : f.getDefault_value());
		f.setField_data_type((null != inputs.get("Field_Data_Type")) ? (String)inputs.get("Field_Data_Type") : f.getField_data_type());
		f.setModified_by((null != inputs.get("Modified_By")) ? (String)inputs.get("Modified_By") : f.getModified_by());
		f.setModified_datetime(new Date());
		
		session.update(f);
		//session.getTransaction().commit();
		return "data updated";
		
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			throw new Exception("User is not present");
		}
		
	}

	@Transactional
	@Override
	public Object delFields(String id) throws Exception {
		// TODO Auto-generated method stub
		Session session=entityManager.unwrap(Session.class);
		
		try {
			Criteria cr = session.createCriteria(Fields.class);
			cr.add(Restrictions.eq("field_code", id));
			Fields fields=(Fields)cr.uniqueResult();
			fields.setIsActive("D");
			//session.beginTransaction();
			session.update(fields);
			session.flush(); 
			session.clear();
			//session.getTransaction().commit();
			return "Successfully deleted";
		}catch(Exception e){
			// TODO: handle exception
		    e.printStackTrace();
		    session.getTransaction().rollback();
			throw new Exception("Data not present");
		}
		
	}

	@Override
	public List<Object> getFields(Map<String,Object> inputs) throws Exception {
		// TODO Auto-generated method stub
		Session session=entityManager.unwrap(Session.class);
		
		System.out.println("Inputs=====>"+inputs);
		try {
			Criteria criteria = session.createCriteria(Fields.class);
			if ((null != inputs.get("Field_Code"))) {
				criteria.add(Restrictions.eq("field_code", (String)inputs.get("Field_Code")));
			}
			if ((null != inputs.get("IsActive"))) {
				criteria.add(Restrictions.eq("isActive", (String)inputs.get("IsActive")));
			}
			if ((null != inputs.get("Field_Type_Code"))) {
				criteria.add(Restrictions.eq("field_type_code", (String)inputs.get("Field_Type_Code")));
			}
			criteria.setProjection(
					Projections.projectionList().
					              add(Projections.property("field_code").as("Field_Code"))
					             .add(Projections.property("field_name").as("Field_Name"))
					             .add(Projections.property("field_description").as("Field_Description"))
					             .add(Projections.property("field_type_code").as("Field_Type_Code"))
					             .add(Projections.property("default_value").as("Default_Value"))
					             .add(Projections.property("field_data_type").as("Field_Data_Type"))
					             .add(Projections.property("isActive").as("IsActive"))
					             .add(Projections.property("created_by").as("Created_By"))
					             .add(Projections.property("created_datetime").as("Created_DateTime"))
					             .add(Projections.property("modified_by").as("Modified_By"))
					             .add(Projections.property("modified_datetime").as("Modified_DateTime"))
					          
					
					);
			criteria.setResultTransformer(Criteria.ALIAS_TO_ENTITY_MAP);
			return criteria.list();
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new Exception("Pass proper data");
		}
	}

}
