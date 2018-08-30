package com.demo.wp.model;

public class PricingRequest {
	
	private String customerAbn;
	private Long expectedAnnualTurnover;

	
	public Integer productIds[];
	public Long getExpectedAnnualTurnOver() {
		return expectedAnnualTurnover;
	}
	public void setProductIds(Integer[] productIds) {
		this.productIds = productIds;
	}
	public String getCustomerAbn() {
		return customerAbn;
	}
	public void setCustomerAbn(String customerAbn) {
		this.customerAbn = customerAbn;
	}
	public Long getExceptedAnnualTurnOver() {
		return expectedAnnualTurnover;
	}
	public void setExpectedAnnualTurnOver(Long exceptedAnnualTurnOver) {
		this.expectedAnnualTurnover = exceptedAnnualTurnOver;
	}


}
