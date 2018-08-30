package com.demo.wp.util;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.demo.wp.model.AssessCustomerRequest;
import com.demo.wp.model.CreditCheckResponse;
import com.demo.wp.model.PricingRequest;
import com.demo.wp.model.PricingResponse;
import com.demo.wp.model.RiskRequest;
import com.demo.wp.model.RiskResponse;
import com.google.gson.Gson; 

@Component
public class RestUtility 
{ 
@Value(value = "${creditendpointURL}") 
public String creditEndpointUrl; 
@Value(value = "${customerendpointURL}") 
public String customerEndpointUrl; 
@Value(value = "${pricingendpointURL}")
public String pricingEndpointURL; 
@Value(value = "${productsURL}") 
public String productsURL; 
@Value(value = "${riskcheckURL}") 
public String riskcheckURL; 


@Autowired RestTemplate restTemplate;
public CreditCheckResponse doCreditCheck(AssessCustomerRequest assCusRequest) 
{
try {
HttpHeaders headers = new HttpHeaders();
headers.set("X-Authorization", "m1P9bUOz6mitXxZZdvpubbWgsh1LSZGs");
HttpEntity entity = new HttpEntity<Object>(headers); 

ResponseEntity creditCheckResponseData = restTemplate.exchange(creditEndpointUrl +assCusRequest.getCustomerAbn(),
		HttpMethod.GET, entity, CreditCheckResponse.class);
CreditCheckResponse creditCheckobj = (CreditCheckResponse) creditCheckResponseData.getBody(); 
return creditCheckobj; 
}
catch(Exception ex)
{ex.getLocalizedMessage();
	return null;
}
   
}

public PricingResponse computePrice(AssessCustomerRequest assCusRequest)
{
	try {
	HttpHeaders headers = new HttpHeaders();
	headers.set("X-Authorization", "m1P9bUOz6mitXxZZdvpubbWgsh1LSZGs");
	headers.set(HttpHeaders.CONTENT_TYPE, "application/json");
		
	PricingRequest pricingRequestobj = new PricingRequest();
	PricingResponse pricingResponseobj = new PricingResponse();
	pricingRequestobj.setCustomerAbn(assCusRequest.getCustomerAbn()); 
	pricingRequestobj.setExpectedAnnualTurnOver(assCusRequest.getExpectedAnnualTurnover());
	pricingRequestobj.setProductIds(assCusRequest.productIds);
	Gson gson = new Gson();
	String pricingRequestInString = gson.toJson(pricingRequestobj);

	HttpEntity<String> requestEntity = new HttpEntity<String>(pricingRequestInString.toString(),headers);
	   ResponseEntity<PricingResponse> responseEntity = restTemplate.exchange(
			   pricingEndpointURL,
              HttpMethod.POST,
              requestEntity,
             PricingResponse.class
      );

	if(responseEntity.getStatusCode() == HttpStatus.OK){
		   pricingResponseobj = responseEntity.getBody();
           System.out.println("user response retrieved ");
        }
	if(responseEntity.getStatusCode() == HttpStatus.BAD_REQUEST){
		   pricingResponseobj = responseEntity.getBody();
        System.out.println("user response retrieved ");
     }
	   return pricingResponseobj;
	}catch(Exception ex)
	{ex.getLocalizedMessage();
		return null;
	}
	   
}

public RiskResponse computeRiskStatus(RiskRequest riskRequest)
{
	HttpHeaders headers = new HttpHeaders();
	headers.set("X-Authorization", "m1P9bUOz6mitXxZZdvpubbWgsh1LSZGs");
	headers.set(HttpHeaders.CONTENT_TYPE, "application/json");

	RiskRequest riskRequestobj = new RiskRequest();
	RiskResponse riskResponseobj = new RiskResponse();
	riskRequestobj.setCreditScore(riskRequest.getCreditScore());
	riskRequestobj.setCreditStatus(riskRequest.getCreditStatus());
	riskRequestobj.setCustomerAbn(riskRequest.getCustomerAbn());
	riskRequestobj.setExpectedAnnualTurnOver(riskRequest.getExpectedAnnualTurnOver());
	riskRequestobj.setTotalAnnualCost(riskRequest.getTotalAnnualCost());
	
	Gson gson = new Gson();
	String pricingRequestInString = gson.toJson(riskRequestobj);

	HttpEntity<String> requestEntity = new HttpEntity<String>(pricingRequestInString.toString(),headers);
	   ResponseEntity<RiskResponse> responseEntity = restTemplate.exchange(
			   riskcheckURL,
            HttpMethod.POST,
            requestEntity,
            RiskResponse.class
    );
	   if(responseEntity.getStatusCode() == HttpStatus.OK){
		   riskResponseobj = responseEntity.getBody();
           System.out.println("user response retrieved ");
        }
	   return riskResponseobj;
}
}



