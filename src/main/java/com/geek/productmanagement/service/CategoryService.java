package com.geek.productmanagement.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.geek.productmanagement.entity.ChildCategory;
import com.geek.productmanagement.entity.MainCategory;
import com.geek.productmanagement.entity.SubCategory;
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
	
	//中カテゴリ情報取得
	public List<SubCategory> findSubCategoriesByMainCategoryId(Integer mainCategoryId){
		return categoryMapper.findSubCategoriesByMainCategoryId(mainCategoryId);
	}
	
	//小カテゴリ情報取得
	public List<ChildCategory> findChildCategoriesBySubCategoryId(Integer subCategoryId){
		return categoryMapper.findChildCategoriesBySubCategoryId(subCategoryId);
	}

}
