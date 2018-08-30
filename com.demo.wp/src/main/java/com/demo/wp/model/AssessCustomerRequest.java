package com.demo.wp.model;

public class AssessCustomerRequest {
	private String customerAbn;
    public String getCustomerAbn() {
		return customerAbn;
	}
	public void setCustomerAbn(String customerAbn) {
		this.customerAbn = customerAbn;
	}
 public Integer productIds[];

	public Long getExpectedAnnualTurnover() {
		return expectedAnnualTurnover;
	}
	public Integer[] getProductIds() {
		return productIds;
	}
	public void setProductIds(Integer[] productIds) {
		this.productIds = productIds;
	}
	public void setExpectedAnnualTurnOver(Long expectedAnnualTurnover) {
		this.expectedAnnualTurnover = expectedAnnualTurnover;
	}

    private Long expectedAnnualTurnover;
}
