package com.localOrder.productService.dto;

import lombok.Data;

@Data
public class LocationResponse {
	
	private double latitude;
	
	private String lookupSource;
	
	private double longitude;
	
	private String localityLanguageRequested;
	
	private String continent;
	
	private String continentCode;
	
	private String countryName;
	
	private String countryCode;
	
	private String principalSubdivision;
	
	private String principalSubdivisionCode;
	
	private String city;
	
	private String locality;
	
	private String plusCode;
	
	private LocalityInfo localityInfo;

}
