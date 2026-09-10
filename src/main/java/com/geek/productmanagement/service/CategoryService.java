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
	
	//大カテゴリ情報取得
	public List<MainCategory> findAllMainCategories(){
		return categoryMapper.findAllMainCategories();
	}

}
