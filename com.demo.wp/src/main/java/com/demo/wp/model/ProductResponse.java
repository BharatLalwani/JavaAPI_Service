package com.demo.wp.model;

import java.util.List;

public class ProductResponse {

	private List<Long> productList;
	private  Long total;

	public List<Long> getProductList() {
		return productList;
	}

	public void setProductList(List<Long> productList) {
		this.productList = productList;
	}
	
	public Long getTotal() {
		return total;
	}
	public void setTotal(Long total) {
		this.total = total;
	}
}