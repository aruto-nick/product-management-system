package com.geek.productmanagement.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.geek.productmanagement.dto.ProductListDto;

@Mapper
public interface ProductMapper {
	//商品一覧表示メソッド
	List<ProductListDto>  findAllByStoreId(
			@Param("storeId") Integer storeId);
	
	//商品検索メソッド
	List<ProductListDto> searchByStoreIdAndProductName(
			@Param("storeId") Integer storeId,
			@Param("productName") String productName,
			@Param("mainCategoryId")Integer mainCategoryId);
}
