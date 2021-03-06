package com.demo.wp.unitTest;


import static org.junit.Assert.assertNotNull;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import com.demo.wp.model.AssessCustomerRequest;
import com.demo.wp.model.CreditCheckResponse;
import com.demo.wp.model.PricingResponse;
import com.demo.wp.model.RiskRequest;
import com.demo.wp.model.RiskResponse;
import com.demo.wp.service.CustomerService;
import com.demo.wp.util.RestUtility;



@RunWith(MockitoJUnitRunner.Silent.class)
public class CustomerServiceTest {
	
	 @InjectMocks
	    private CustomerService customerService;

	    @Mock
	    private RestUtility restUtility;
 
	    @Test
	    public void testGetAssessCustomer() {
	 	 AssessCustomerRequest assCusRequest = new AssessCustomerRequest();
	    CreditCheckResponse creditResponsedata = new CreditCheckResponse();
	    PricingResponse pricingResponsedata = new PricingResponse();
	    RiskRequest riskRequestdata = new RiskRequest();
	    RiskResponse riskResponsedata = new RiskResponse();
	    creditResponsedata.setCreditScore(100l);
	    creditResponsedata.setCustomerAbn("ABN000023421");
	    creditResponsedata.setStatus("active");
  	
	    Integer[] pids = new Integer[]{10,11,12};
	    
	   
	    String strcustomerAbn ="ABN000023421";
	   
	    assCusRequest.setCustomerAbn(strcustomerAbn);
	    assCusRequest.setProductIds(pids);
	    assCusRequest.setExpectedAnnualTurnOver(100l);
	    Mockito.when(restUtility.doCreditCheck(assCusRequest)).thenReturn(creditResponsedata);
	      
	    Mockito.when(restUtility.computePrice(assCusRequest)).thenReturn(pricingResponsedata);
	    
	    riskRequestdata.setCreditScore(creditResponsedata.getCreditScore());
	    riskRequestdata.setCreditStatus(creditResponsedata.getStatus());
	    riskRequestdata.setCustomerAbn(assCusRequest.getCustomerAbn());
	    riskRequestdata.setExpectedAnnualTurnOver(pricingResponsedata.getExpectedAnnualTurnover());
	    riskRequestdata.setTotalAnnualCost(pricingResponsedata.getTotalAnnualCost());
		
	    
	    Mockito.when(restUtility.computeRiskStatus(riskRequestdata)).thenReturn(riskResponsedata);
	   
	    assertNotNull(riskResponsedata);
	                                        
	    } 
	    }


