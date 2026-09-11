package com.geek.productmanagement.dto;

import lombok.Data;

@Data
public class ProductListDto {
	//productsテーブルのカラム
	private Integer id;	
	private String productName;
	private String productImage;
	//child_categoriesテーブル
	private String childCategoryName;
	//store_productsテーブル
	private Integer storePrice;
	private Integer storeStock;
	

}
