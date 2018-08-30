 package com.demo.wp.service;

import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import com.demo.wp.model.AssessCustomerRequest;
import com.demo.wp.model.CreditCheckResponse;
import com.demo.wp.util.RestUtility;



@RunWith(MockitoJUnitRunner.class)
public class CustomerServiceTest {
	
	 @InjectMocks
	    private CustomerService customerService;

	    @Mock
	    private RestUtility restUtility;
	    
	    
	    
	    @Test
	    public void testGetAssessCustomer() {
	    	AssessCustomerRequest objMock = Mockito.mock(AssessCustomerRequest.class);
	    	//  CreditCheckResponse data = new CreditCheckResponse().addQuotesItem(new Quote()).addQuotesItem(new Quote()).pagination(new Pagination().count(10));
	    	// when(restUtility.doCreditCheck(objMock).thenReturn(data);

}
}