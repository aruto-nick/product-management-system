package com.geek.productmanagement.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.geek.productmanagement.dto.ProductListDto;
import com.geek.productmanagement.mapper.ProductMapper;


@Service
public class ProductService {
	private final ProductMapper productMapper;
	
	public ProductService(ProductMapper productMapper) {
		this.productMapper = productMapper;
	}
	
	public List<ProductListDto> findAllByStoreId(Integer storeId){
		return productMapper.findAllByStoreId(storeId);
	}

}
