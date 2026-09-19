package com.geek.productmanagement.dto;

import lombok.Data;

@Data
public class ProductOrderDto {
	
	//productテーブルのカラム
	private Integer id;
	private String productImage;
	private String productName;
	private Integer purchaseCost;
	
	//store-productsテーブル
	private Integer storeStock;

}
