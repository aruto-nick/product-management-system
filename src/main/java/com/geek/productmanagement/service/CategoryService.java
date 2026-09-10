package com.geek.productmanagement.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.geek.productmanagement.entity.MainCategory;
import com.geek.productmanagement.mapper.CategoryMapper;

@Service
public class CategoryService {
	private final CategoryMapper categoryMapper;
	
	public CategoryService(CategoryMapper categoryMapper) {
		this.categoryMapper = categoryMapper;
	}
	
	public List<MainCategory> findMainCategoriesByStoreId(Integer storeId){
		return categoryMapper.findMainCategoriesByStoreId(storeId);
	}

}
