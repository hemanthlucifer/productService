package com.localOrder.productService.dto;

import java.util.List;

import lombok.Data;

@Data
public class HomePageDataDTO {
	
	private String city;
	
	private String state;
	
	private String country;
	
	private List<ProductListDTO> productList;

}
