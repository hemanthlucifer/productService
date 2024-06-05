package com.localOrder.productService.service;

import java.util.List;

import com.localOrder.productService.dto.HomePageDataDTO;
import com.localOrder.productService.dto.ProductListDTO;
import com.localOrder.productService.dto.ProductPageDTO;

public interface ProductService {
	
	public HomePageDataDTO getProductsByLocation(double latitude, double longitude);
	
	public List<ProductListDTO> getProductsByCategory(String category, String location);
	
	public ProductPageDTO getProductPageDTO(long productId);

}
