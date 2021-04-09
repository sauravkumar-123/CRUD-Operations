package com.orgreportfieldmap.start.Controller;

import java.util.Enumeration;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.orgreportfieldmap.start.Service.OrgreportfieldmapService;

@RestController
public class OrgreportfieldmapController {

	@Autowired
	private OrgreportfieldmapService orgreportfieldmapService;
	
	@RequestMapping(value = "/orgreportfieldmap" , method = RequestMethod.GET)
	public ResponseEntity<List<?>> getFields(HttpServletRequest request) throws Exception{
		Enumeration<String> parameterNames = request.getParameterNames();
		Map<String,Object> input =  new HashMap<String, Object>();
		
		while (parameterNames.hasMoreElements()) {
			String string = (String) parameterNames.nextElement();
			System.out.println(string);
			String parameter = request.getParameter(string);
			System.out.println(parameter);
			input.put(string, parameter);
			
		}
		  List<Object> list=this.orgreportfieldmapService.getOrgreportfieldmap(input);
		  
		  if(list.isEmpty() || list.size()==0) {
	        	
				return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
	      }
		  else {
			  System.out.println("Result==>"+list);
			  return ResponseEntity.status(HttpStatus.OK).body(list);
		  }
		}
	
	
	
	
	@RequestMapping(value = "/orgreportfieldmap" , method = RequestMethod.POST)
	public ResponseEntity<Object> AddFields(@RequestBody HashMap<String,Object> inputs)
	{
		System.out.println("Inputs=="+inputs);
		if(inputs.isEmpty() || inputs==null) {
			
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Wrong input !! Please check");
		}
		else {
			System.out.println("orgvalue value "+inputs);
			try {
				this.orgreportfieldmapService.addOrgreportfieldmap(inputs);
				//System.out.println("get fields===>"+fieldsinfo);
				return ResponseEntity.status(HttpStatus.OK).build();
			}
			catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
				System.out.println("Internal Server Error found!!!!!!!");
			}
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
		
	}
	
	
	
	
	@RequestMapping(value = "/orgreportfieldmap" , method = RequestMethod.DELETE)
	public ResponseEntity<?> DeleteFields(@RequestParam(value = "Org_Code",required = true) String org_code,
			                              @RequestParam(value = "Domain_Code",required = true) String domain_code,
			                              @RequestParam(value = "Subdomain_Code",required = true) String subdomain_code,
			                              @RequestParam(value = "Report_Code",required = true) String report_code,
			                              @RequestParam(value = "Field_Code",required = true) String field_code)
	{
				
		if((org_code.isEmpty() || org_code==null) 
		  && (domain_code.isEmpty() || domain_code==null)
		  && (subdomain_code.isEmpty() || subdomain_code==null)
		  && (report_code.isEmpty() || report_code==null)
		  && (field_code.isEmpty() || field_code==null)) {
					
			 return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Primary Key either Missing Or Wrong");
		}
		else {
			try {
				this.orgreportfieldmapService.deleteOrgreportfieldmap(org_code, domain_code, subdomain_code, report_code, field_code);
				return ResponseEntity.status(HttpStatus.OK).build();
			} catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
				return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
			}
		}
	}
	
	
	
	
	@RequestMapping(value = "/orgreportfieldmap" , method = RequestMethod.PUT)
	public ResponseEntity<Object> UpdateContact(@RequestBody HashMap<String,Object> inputs)
	{
		
        if(inputs.isEmpty() || inputs==null) {
			
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Wrong input !! Please check");
		}
        else {
        	try {
        		this.orgreportfieldmapService.updateOrgreportfieldmap(inputs);
        		return ResponseEntity.status(HttpStatus.OK).build();
        	} catch (Exception e) {
        		// TODO: handle exception
        		e.printStackTrace();
        		return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        	}
		}
	}
}
