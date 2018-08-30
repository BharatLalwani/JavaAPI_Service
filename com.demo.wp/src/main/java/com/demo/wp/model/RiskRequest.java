package com.demo.wp.model;

public class RiskRequest {

	private Long creditScore;
	private String creditStatus;
	private String customerAbn;
	private  Long expectedAnnualTurnover;
	private Long totalAnnualCost;
	public Long getCreditScore() {
		return creditScore;
	}
	public void setCreditScore(Long creditScore) {
		this.creditScore = creditScore;
	}
	public String getCreditStatus() {
		return creditStatus;
	}
	public void setCreditStatus(String creditStatus) {
		this.creditStatus = creditStatus;
	}
	public String getCustomerAbn() {
		return customerAbn;
	}
	public void setCustomerAbn(String customerAbn) {
		this.customerAbn = customerAbn;
	}
	public Long getExpectedAnnualTurnOver() {
		return expectedAnnualTurnover;
	}
	public void setExpectedAnnualTurnOver(Long expectedAnnualTurnOver) {
		this.expectedAnnualTurnover = expectedAnnualTurnOver;
	}
	public Long getTotalAnnualCost() {
		return totalAnnualCost;
	}
	public void setTotalAnnualCost(Long totalAnnualCost) {
		this.totalAnnualCost = totalAnnualCost;
	}
}
