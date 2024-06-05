package com.localOrder.productService.serviceImpl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.localOrder.productService.dto.HomePageDataDTO;
import com.localOrder.productService.dto.ProductListDTO;
import com.localOrder.productService.dto.ProductPageDTO;
import com.localOrder.productService.model.Product;
import com.localOrder.productService.repository.ProductRepository;
import com.localOrder.productService.service.LocationService;
import com.localOrder.productService.service.ProductService;

@Service
public class ProductServiceImpl implements ProductService {
	
	@Autowired
	private LocationService locationService;
	
	@Autowired
	private ProductRepository productRepository;

	@Override
	public HomePageDataDTO getProductsByLocation(double latitude, double longitude) {
		HomePageDataDTO homePageDataDTO = locationService.getLocation(latitude, longitude);
		List<ProductListDTO> productList = new ArrayList<>();
		List<Product> products = productRepository.findAllByCity(homePageDataDTO.getCity());
		for(Product product : products) {
			ProductListDTO productListDTO = new ProductListDTO();
			productListDTO.setProductImage(product.getProductImage());
			productListDTO.setProductName(product.getProductName());
			productListDTO.setProductId(product.getProductId());
			productList.add(productListDTO);
		}
		homePageDataDTO.setProductList(productList);
		return homePageDataDTO;
	}

	@Override
	public List<ProductListDTO> getProductsByCategory(String category, String city) {
		if(category.equalsIgnoreCase("all")) {
			List<Product> products = productRepository.findAllByCity(city);
			List<ProductListDTO> productList = new ArrayList<>();
			for(Product product : products) {
				ProductListDTO productListDTO = new ProductListDTO();
				productListDTO.setProductImage(product.getProductImage());
				productListDTO.setProductName(product.getProductName());
				productListDTO.setProductId(product.getProductId());
				productList.add(productListDTO);
			}
			
			return productList;
		}else {
			List<Product> products = productRepository.findAllByCategoryAndCity(category,city);
			List<ProductListDTO> productList = new ArrayList<>();
			for(Product product : products) {
				ProductListDTO productListDTO = new ProductListDTO();
				productListDTO.setProductImage(product.getProductImage());
				productListDTO.setProductName(product.getProductName());
				productListDTO.setProductId(product.getProductId());
				productList.add(productListDTO);
			}
			return productList;
		}
	}

	@Override
	public ProductPageDTO getProductPageDTO(long productId) {
		Product product = productRepository.findById(productId).get();
		ProductPageDTO productPage = new ProductPageDTO();
		productPage.setProductDesc(product.getProductDesc());
		productPage.setProductImage(product.getProductImage());
		productPage.setProductName(product.getProductName());
		productPage.setProductPrice(product.getProductPrice());
		productPage.setStoreLocation(product.getStoreLocation());
		productPage.setStoreName(product.getStoreName());
		productPage.setStorePhone(product.getStorePhone());
		return productPage;
	}

	
}
