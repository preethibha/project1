package com.chubb.dgmk.caf.domain.resource;

import java.util.Comparator;

public class ProductResource {

	private String productName;
	private String productCode;

	/**
	 * @return the productName
	 */
	public String getProductName() {
		return productName;
	}

	/**
	 * @param productName the productName to set
	 */
	public void setProductName(String productName) {
		this.productName = productName;
	}

	/**
	 * @return the productCode
	 */
	public String getProductCode() {
		return productCode;
	}

	/**
	 * @param productCode the productCode to set
	 */
	public void setProductCode(String productCode) {
		this.productCode = productCode;
	}
	
	/**
	 * Comparator for ProductResource (product) list to sort by product name
	 */
	public static final Comparator<ProductResource> ProductComparator = new Comparator<ProductResource>(){

		@Override
		public int compare(ProductResource object1, ProductResource object2) {
			return object1.getProductName().compareTo(object2.getProductName());
		}

	};
	
	@Override
	public String toString() {
		StringBuffer sb = new StringBuffer();
		
		sb.append("Product Name: " + this.getProductName());
		sb.append("ProductCode: " + this.getProductCode());
		return sb.toString();
	}
}
