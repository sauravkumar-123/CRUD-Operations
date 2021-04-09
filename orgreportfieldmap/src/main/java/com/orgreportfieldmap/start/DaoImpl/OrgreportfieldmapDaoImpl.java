package com.orgreportfieldmap.start.DaoImpl;

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

import com.orgreportfieldmap.start.Dao.OrgreportfieldmapDao;
import com.orgreportfieldmap.start.Entity.Orgreportfieldmap;
import com.orgreportfieldmap.start.Entity.OrgreportfieldmapPK;

@Repository
public class OrgreportfieldmapDaoImpl implements OrgreportfieldmapDao{

	@PersistenceContext
	private EntityManager entityManager;
	
	@Transactional(rollbackOn = Exception.class)
	@Override
	public Object addOrgreportfieldmap(Map<String,Object> inputs) throws Exception {

		System.out.println("Inupts===>"+inputs);
		Session session=entityManager.unwrap(Session.class);
		try {
			Orgreportfieldmap or=new Orgreportfieldmap();
			OrgreportfieldmapPK orpk=new OrgreportfieldmapPK();
			orpk.setOrg_code((String)inputs.get("Org_Code"));
			orpk.setDomain_code((String)inputs.get("Domain_Code"));
			orpk.setSubdomain_code((String)inputs.get("Subdomain_Code"));
			orpk.setReport_code((String)inputs.get("Report_Code"));
			orpk.setField_code((String)inputs.get("Field_Code"));
			or.setId(orpk);
			or.setIsActive((String)inputs.get("IsActive"));
			or.setCreated_by((String)inputs.get("Created_By"));
			or.setCreated_datetime(new Date());
			or.setModified_by((String)inputs.get("Modified_By"));
			or.setModified_datetime(new Date());
			//session.beginTransaction();
			session.save(or);
			session.flush();
			//session.getTransaction().commit();
			return true;
		}
		catch(Exception e) {
			e.printStackTrace();
			throw new Exception("pass correct data");
		}
	}	
		
	@Override
	public List<Object> getOrgreportfieldmap(Map<String,Object> inputs) throws Exception {
		// TODO Auto-generated method stub
		Session session=entityManager.unwrap(Session.class);
		System.out.println("Inupts===>"+inputs);
		try {
			Criteria criteria=session.createCriteria(Orgreportfieldmap.class);
			if(null!=inputs.get("Org_Code")) {
				criteria.add(Restrictions.eq("id.org_code", inputs.get("Org_Code")));
			}
			if(null!=inputs.get("Domain_Code")) {
				criteria.add(Restrictions.eq("id.domain_code", inputs.get("Domain_Code")));
			}
			if(null!=inputs.get("Subdomain_Code")) {
				criteria.add(Restrictions.eq("id.subdomain_code", inputs.get("Subdomain_Code")));
			}
			if(null!=inputs.get("Report_Code")) {
				criteria.add(Restrictions.eq("id.report_code", inputs.get("Report_Code")));
			}
			if(null!=inputs.get("Field_Code")) {
				criteria.add(Restrictions.eq("id.field_code", inputs.get("Field_Code")));
			}
			if(null!=inputs.get("IsActive")) {
				criteria.add(Restrictions.eq("isActive", inputs.get("IsActive")));
			}
			
			criteria.setProjection(Projections.projectionList()
					.add(Projections.property("id.org_code").as("Org_Code"))
					.add(Projections.property("id.domain_code").as("Domain_Code"))
					.add(Projections.property("id.subdomain_code").as("Subdomain_Code"))
					.add(Projections.property("id.report_code").as("Report_Code"))
					.add(Projections.property("id.field_code").as("Field_Code"))
					.add(Projections.property("isActive").as("IsActive"))
					.add(Projections.property("created_by").as("Created_By"))
					.add(Projections.property("created_datetime").as("Created_DateTime"))
					.add(Projections.property("modified_by").as("Modified_By"))
					.add(Projections.property("modified_datetime").as("Modified_DateTime")));
			criteria.setResultTransformer(Criteria.ALIAS_TO_ENTITY_MAP);
			return criteria.list();
		}
		catch(Exception e) {
			e.printStackTrace();
			throw new Exception("Pass proper data");
		}
		
	}

	@Transactional
	@Override
	public Object updateOrgreportfieldmap(Map<String,Object> inputs) throws Exception {
		// TODO Auto-generated method stub
		System.out.println("Inupts===>"+inputs);
		Session session=entityManager.unwrap(Session.class);
		
		if(inputs.containsKey("Created_By")) {
			throw new Exception("Created_By shouldn't be Update");
		}
		
		try {
			//session.beginTransaction();
			Orgreportfieldmap or=(Orgreportfieldmap)session.get(Orgreportfieldmap.class, new OrgreportfieldmapPK((String)inputs.get("Org_Code"),(String)inputs.get("Domain_Code"),
					(String)inputs.get("Subdomain_Code"),(String)inputs.get("Report_Code"),(String)inputs.get("Field_Code")));
			
			or.setIsActive((null != inputs.get("IsActive")) ? (String)inputs.get("IsActive") : or.getIsActive());
			or.setCreated_by((null!=inputs.get("Created_By")) ? (String)inputs.get("Created_By") :or.getCreated_by());
			or.setCreated_datetime(new Date());
			or.setModified_by((null!=inputs.get("Modified_By")) ? (String)inputs.get("Modified_By") : or.getModified_by());
			or.setModified_datetime(new Date());
			session.update(or);
			//session.getTransaction().commit();
			return "updated";
		}
	catch (Exception e) {
		e.printStackTrace();
		throw new Exception("User is not present");
	}
	}

	@Transactional
	@Override
	public void deleteOrgreportfieldmap(String org_code, String domain_code, String subdomain_code, String report_code,
			String field_code) throws Exception {
		// TODO Auto-generated method stub
		Session session=entityManager.unwrap(Session.class);
		try {
			Criteria cr = session.createCriteria(Orgreportfieldmap.class);
			
			cr.add(Restrictions.eq("id.org_code", org_code));
			cr.add(Restrictions.eq("id.domain_code", domain_code));
			cr.add(Restrictions.eq("id.subdomain_code", subdomain_code));
			cr.add(Restrictions.eq("id.report_code", report_code));
			cr.add(Restrictions.eq("id.field_code", field_code));
			Orgreportfieldmap org=(Orgreportfieldmap)cr.uniqueResult();
			org.setIsActive("D");
			//session.beginTransaction();
			session.update(org);
			session.flush(); 
			session.clear();
			//session.getTransaction().commit();
			}
			catch (Exception e) {
				e.printStackTrace();
				session.getTransaction().rollback();
				throw new Exception("Data not present");
			}
		
	}

}
