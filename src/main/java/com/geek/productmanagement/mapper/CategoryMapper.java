package com.geek.productmanagement.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.geek.productmanagement.entity.MainCategory;
import com.geek.productmanagement.entity.SubCategory;

@Mapper
public interface CategoryMapper {
	//大カテゴリー取得メソッド
	List<MainCategory> findAllMainCategories();
	
	//中カテゴリ一覧取得メソッド
	List<SubCategory> findSubCategoriesByMainCategoryId(
			@Param("mainCategoryId")Integer mainCategoryId);
	

}
