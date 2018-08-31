package com.demo.wp.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.demo.wp.model.AssessCustomerRequest;
import com.demo.wp.model.AssessCustomerResponse;
import com.demo.wp.service.CustomerService;

@RestController
public class CustomerAPI {
	@Autowired
	CustomerService customerService;
	
	@RequestMapping(value="/businessarrangement/assesscustomer",method=RequestMethod.POST)
	public com.demo.wp.model.AssessCustomerResponse assessCustomer(@RequestBody AssessCustomerRequest assCusRequest ) {
		AssessCustomerResponse assCutResponse = new AssessCustomerResponse();
			
		if(assCusRequest!= null)
		{
			assCutResponse =	customerService.getAssessCustomer(assCusRequest);
			
		}
	  return assCutResponse;
		
	}

	

	
	
}
