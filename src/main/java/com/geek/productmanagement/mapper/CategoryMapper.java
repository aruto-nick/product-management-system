package com.geek.productmanagement.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.geek.productmanagement.entity.MainCategory;

@Mapper
public interface CategoryMapper {
	//大カテゴリー取得メソッド
	List<MainCategory> findAllMainCategories();

}
