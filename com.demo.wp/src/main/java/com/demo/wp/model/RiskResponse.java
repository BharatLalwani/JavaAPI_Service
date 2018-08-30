package com.demo.wp.model;

public class RiskResponse {
	private String customerAbn;
	private Long riskScore;
	private String riskStatus;
	public String getCustomerAbn() {
		return customerAbn;
	}
	public void setCustomerAbn(String customerAbn) {
		this.customerAbn = customerAbn;
	}
	public Long getRiskScore() {
		return riskScore;
	}
	public void setRiskScore(Long riskScore) {
		this.riskScore = riskScore;
	}
	public String getRiskStatus() {
		return riskStatus;
	}
	public void setRiskStatus(String riskStatus) {
		this.riskStatus = riskStatus;
	}
}