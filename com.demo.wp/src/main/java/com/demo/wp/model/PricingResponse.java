package com.demo.wp.model;

import java.util.List;

public class PricingResponse {

	private String customerAbn;
	private long expectedAnnualTurnover;
	private List<Long> productids;
	private long totalAnnualCost;
	
	public String getCustomerAbn() {
		return customerAbn;
	}
	public void setCustomerAbn(String customerAbn) {
		this.customerAbn = customerAbn;
	}
	public long getExpectedAnnualTurnover() {
		return expectedAnnualTurnover;
	}
	public void setExpectedAnnualTurnover(long expectedAnnualTurnover) {
		this.expectedAnnualTurnover = expectedAnnualTurnover;
	}
	public List<Long> getProductids() {
		return productids;
	}
	public void setProductids(List<Long> productids) {
		this.productids = productids;
	}
	public long getTotalAnnualCost() {
		return totalAnnualCost;
	}
	public void setTotalAnnualCost(long totalAnnualCost) {
		this.totalAnnualCost = totalAnnualCost;
	}

}

