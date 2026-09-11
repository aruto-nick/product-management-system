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
	
	public List<ProductListDto> searchByStoreIdAndProductName(Integer storeId,
										String productName,Integer mainCategoryId,
										Integer subCategoryId, Integer childCategoryId,
										Integer limit, Integer offset){
		return productMapper.searchByStoreIdAndProductName(storeId, productName, mainCategoryId, 
						subCategoryId,childCategoryId, limit, offset);
	}
	
	//商品一覧画面の商品数をカウント
	public Integer countProducts(Integer storeId,
				String productName,Integer mainCategoryId,
				Integer subCategoryId, Integer childCategoryId) {
		
		return productMapper.countProducts(storeId, productName, mainCategoryId, subCategoryId, childCategoryId);
	}

}
