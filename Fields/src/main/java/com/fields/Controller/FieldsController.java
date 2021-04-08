package com.fields.Controller;

import java.util.Enumeration;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.fields.Service.FieldsService;

@RestController
public class FieldsController {

	@Autowired
	private FieldsService fieldservice;
	
	@RequestMapping(value = "/fields" , method = RequestMethod.GET)
	public ResponseEntity<List<?>> getFields(HttpServletRequest request) throws Exception{
		
		Enumeration<String> parameterName = request.getParameterNames();
		Map<String,Object> input =  new HashMap<String, Object>();
		
		while (parameterName.hasMoreElements()) {
			String data = (String) parameterName.nextElement();
			String parameter = request.getParameter(data);
			input.put(data, parameter);
			
		}
		  List<Object> list=this.fieldservice.getFields(input);
		  
		  if(list.isEmpty() || list==null) {
	        	
				return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
	      }
		  else {
			  System.out.println("Result==>"+list);	
			  return ResponseEntity.status(HttpStatus.OK).body(list);
		   }
		  
		}	
	
	
	@RequestMapping(value = "/fields" , method = RequestMethod.POST)
	public ResponseEntity<Object> AddFields(@RequestBody HashMap<String,Object> inputs)
	{
            if(inputs.isEmpty() || inputs==null) {
			
			  return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Wrong input !! Please check");
		    }
            else {
            	System.out.println("Fields value "+inputs);
        		
        		try {
        			this.fieldservice.addFields(inputs);
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
	
	
	
	
	@RequestMapping(value = "/fields" , method = RequestMethod.DELETE)
	public ResponseEntity<?> DeleteFields(@RequestParam(value = "Field_Code",required = true) String fieldsid)
	{
             if(fieldsid.isEmpty() || fieldsid==null) {
			
			     return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Wrong Field_Id !! Please check");
		      }
             else {
            	    
         		try {
         			this.fieldservice.delFields(fieldsid);
         			return ResponseEntity.status(HttpStatus.OK).build();
         		} catch (Exception e) {
         			// TODO: handle exception
         			e.printStackTrace();
         			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
         		}
         		
             }
        
	}
	
	
	
	
	@RequestMapping(value = "/fields" , method = RequestMethod.PUT)
	public ResponseEntity<Object> UpdateContact(@RequestBody HashMap<String,Object> inputs)
	{
		Map<String, Object> map = new HashMap<>();
		map.put("Field_Code", inputs.get("Field_Code"));
		
           if(inputs.isEmpty() || inputs==null) {
        	   
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Wrong input !! Please check");
			
		   }
           else {
        	   try {
        			this.fieldservice.updateFields(inputs);
        			return ResponseEntity.ok().build();
        		} catch (Exception e) {
        			// TODO: handle exception
        			e.printStackTrace();
        			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        		}
        		
        		}
		}
}
