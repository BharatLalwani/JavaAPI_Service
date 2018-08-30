package com.demo.wp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import com.demo.wp.model.AssessCustomerRequest;
import com.demo.wp.model.AssessCustomerResponse;
import com.demo.wp.model.CreditCheckResponse;
import com.demo.wp.model.PricingResponse;
import com.demo.wp.model.RiskRequest;
import com.demo.wp.model.RiskResponse;
import com.demo.wp.util.RestUtility;


@Service public class CustomerService
{ 
	
	@Autowired 
	RestUtility restUtility;
public AssessCustomerResponse getAssessCustomer(@RequestBody AssessCustomerRequest assCusRequest) 
{ 
//Calling Credit Check
CreditCheckResponse creditCheckResponse = restUtility.doCreditCheck(assCusRequest);

// Calling Compute Price
PricingResponse pricingResponse = restUtility.computePrice(assCusRequest);

//Set RiskRequest parameters
RiskRequest riskRequest = new RiskRequest(); 
riskRequest.setCreditScore(creditCheckResponse.getCreditScore()); 
riskRequest.setCreditStatus(creditCheckResponse.getStatus());
riskRequest.setCustomerAbn(assCusRequest.getCustomerAbn()); 
riskRequest.setExpectedAnnualTurnOver(assCusRequest.getExpectedAnnualTurnover());
riskRequest.setTotalAnnualCost(pricingResponse.getTotalAnnualCost());

//Calling Risk Status
RiskResponse riskResponse = restUtility.computeRiskStatus(riskRequest);
AssessCustomerResponse assCustobj = new AssessCustomerResponse();
// Set AssessCustomer Object
assCustobj.setCustomerAbn(assCusRequest.getCustomerAbn());
assCustobj.setProductIds(assCusRequest.getProductIds());
assCustobj.setCreditStatus(creditCheckResponse.getStatus());
assCustobj.setRiskStatus(riskResponse.getRiskStatus());
assCustobj.setTotalAnnualCost(pricingResponse.getTotalAnnualCost());
return assCustobj;
}
}