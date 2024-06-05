package com.localOrder.productService.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data
public class Product {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column
	private long productId;
	
	@Column
	private String productName;
    
	@Column(columnDefinition = "TEXT")
	private String productDesc;
    
	@Column
	private double productPrice;
    
	@Column
	private String storeName;
    
	@Column
	private String storeLocation;

	@Column
	private String productImage;

	@Column
	private long storePhone;
	
	@Column
	private String city;
	
	@Column
	private String category;
}
