package com.demo.wp.unitTest;

import static org.junit.Assert.assertNotNull;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import com.demo.wp.api.CustomerAPI;
import com.demo.wp.model.AssessCustomerRequest;
import com.demo.wp.model.AssessCustomerResponse;
import com.demo.wp.model.CreditCheckResponse;
import com.demo.wp.model.PricingResponse;
import com.demo.wp.model.RiskRequest;
import com.demo.wp.model.RiskResponse;
import com.demo.wp.service.CustomerService;



@RunWith(MockitoJUnitRunner.Silent.class)
public class CustomerAPITest {
	
	 @InjectMocks
	    private CustomerAPI customerApi;

	    @Mock
	    private CustomerService customerService;
	    
	    @Test
	    public void testAssessCustomer() {
	    AssessCustomerRequest assCusRequest = new AssessCustomerRequest();
	    CreditCheckResponse creditResponsedata = new CreditCheckResponse();
	    PricingResponse pricingResponsedata = new PricingResponse();
	    RiskRequest riskRequestdata = new RiskRequest();
	    RiskResponse riskResponsedata = new RiskResponse();
	    AssessCustomerResponse assCustResponseData = new AssessCustomerResponse();
	    creditResponsedata.setCreditScore(100l);
	    creditResponsedata.setCustomerAbn("ABN000023421");
	    creditResponsedata.setStatus("active");
  	
	    Integer[] pids = new Integer[]{10,11,12};
	    
	   
	    String strcustomerAbn ="ABN000023421";
	   
	    //Set AssessCustomer Request 
	    assCusRequest.setCustomerAbn(strcustomerAbn);
	    assCusRequest.setProductIds(pids);
	    assCusRequest.setExpectedAnnualTurnOver(100l);
	    assCustResponseData.setCustomerAbn(assCusRequest.getCustomerAbn());
	    assCustResponseData.setProductIds(assCusRequest.getProductIds());
	    assCustResponseData.setCreditStatus(creditResponsedata.getStatus());
	    assCustResponseData.setRiskStatus(riskResponsedata.getRiskStatus());
	    assCustResponseData.setTotalAnnualCost(pricingResponsedata.getTotalAnnualCost());
	    
	    Mockito.when(customerService.getAssessCustomer(assCusRequest)).thenReturn(assCustResponseData);
	    assertNotNull(assCustResponseData);
	      
	    } 
	  	    
}
