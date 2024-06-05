package com.localOrder.productService.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.localOrder.productService.dto.HomePageDataDTO;
import com.localOrder.productService.dto.LocationDTO;
import com.localOrder.productService.dto.ProductListDTO;
import com.localOrder.productService.dto.ProductPageDTO;
import com.localOrder.productService.service.ProductService;

@RestController
public class ProductController {
	
	@Autowired
	private ProductService productService;
	
	@GetMapping("/getProducts")
	public ResponseEntity<HomePageDataDTO> getProductsByLocation(@RequestParam("latitude") double latitude, @RequestParam("longitude") double longitude ){
		HomePageDataDTO homePageDataDTO = productService.getProductsByLocation(latitude, longitude);
		return new ResponseEntity<>(homePageDataDTO,HttpStatus.OK);
	}
	
	@GetMapping("/getProducts/{category}")
	public ResponseEntity<List<ProductListDTO>> getProductsByCategory(@PathVariable("category") String category,@RequestParam("userLocation") String location){
		List<ProductListDTO> productList = productService.getProductsByCategory(category, location);
		return new ResponseEntity<>(productList,HttpStatus.OK);
	}
	
	@GetMapping("/getProduct/{productId}")
	public ResponseEntity<ProductPageDTO> getProductById(@PathVariable("productId") long productId){
		ProductPageDTO productPageDTO = productService.getProductPageDTO(productId);
		return new ResponseEntity<>(productPageDTO,HttpStatus.OK);
	}

}
