package com.localOrder.productService.dto;

import lombok.Data;

@Data
public class ProductPageDTO {

	private String productName;

	private String productDesc;

	private double productPrice;

	private String storeName;

	private String storeLocation;

	private String productImage;

	private long storePhone;

}
