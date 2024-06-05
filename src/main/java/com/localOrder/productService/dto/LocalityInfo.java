package com.localOrder.productService.dto;

import java.util.List;

import lombok.Data;

@Data
public class LocalityInfo {
	
	private List<Administrative> administrative;
	
	private List<Informative> informative;

}
