package com.demo.wp.model;

public class AssessCustomerResponse {
	
	private String customerAbn;
	 public Integer productIds[];
	private String creditStatus;
	private String riskStatus;
	private long totalAnnualCost;
	public String getCustomerAbn() {
		return customerAbn;
	}
	public void setCustomerAbn(String customerAbn) {
		this.customerAbn = customerAbn;
	}
	
	public Integer[] getProductIds() {
		return productIds;
	}
	public void setProductIds(Integer[] productIds) {
		this.productIds = productIds;
	}
	public String getCreditStatus() {
		return creditStatus;
	}
	public void setCreditStatus(String creditStatus) {
		this.creditStatus = creditStatus;
	}
	public String getRiskStatus() {
		return riskStatus;
	}
	public void setRiskStatus(String riskStatus) {
		this.riskStatus = riskStatus;
	}
	public long getTotalAnnualCost() {
		return totalAnnualCost;
	}
	public void setTotalAnnualCost(long totalAnnualCost) {
		this.totalAnnualCost = totalAnnualCost;
	}
	
}
