package com.localOrder.productService.service;

import com.localOrder.productService.dto.HomePageDataDTO;

public interface LocationService {
	
	public HomePageDataDTO getLocation(double latitude,double longitude);

}
