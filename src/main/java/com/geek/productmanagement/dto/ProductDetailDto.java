package com.geek.productmanagement.dto;

import lombok.Data;

@Data
public class ProductDetailDto {
	//productsテーブルのカラム
	private Integer id;
	private String productImage;
	private String productName;
	private String productExplanation;
	private Integer purchaseCost;
	private Integer makerPrice;

	//mainCategoriesテーブル
	private String mainCategoryName;
	
	//subCategoriesテーブル
	private String subCategoryName;
	
	//childCategoriesテーブル
	private String childCategoryName;
	
	//store_productsテーブル
	private Integer storePrice;
	private Integer storeStock;
	
	//makerテーブル
	private String makerName;

}
