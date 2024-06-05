package com.localOrder.productService.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.localOrder.productService.dto.HomePageDataDTO;
import com.localOrder.productService.dto.LocationResponse;
import com.localOrder.productService.service.LocationService;
import com.localOrder.productService.util.URLBuilder;

@Service
public class LocationServiceImpl implements LocationService {
	
	@Autowired
	private URLBuilder urlBuilder;
	
	

	@Override
	public HomePageDataDTO getLocation(double latitude, double longitude) {
		RestTemplate restTemplate = new RestTemplate();
		String url = urlBuilder.urlBuilder(latitude, longitude);
		ResponseEntity<LocationResponse> locationResponse = restTemplate.getForEntity(url, LocationResponse.class);
		String city = locationResponse.getBody().getCity();
		String state = locationResponse.getBody().getLocalityInfo().getAdministrative().get(1).getName();
		String country = locationResponse.getBody().getCountryName();
		HomePageDataDTO homePageDTO = new HomePageDataDTO();
		homePageDTO.setCity(city.replace(" ", ""));
		homePageDTO.setCountry(country);
		homePageDTO.setState(state);
		return homePageDTO;
	}

}
