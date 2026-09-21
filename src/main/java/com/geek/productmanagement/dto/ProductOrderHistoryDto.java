package com.geek.productmanagement.dto;

import java.time.LocalDateTime;

import lombok.Data;

@Data
public class ProductOrderHistoryDto {
	
	//productsテーブルのカラム
	private String productImage;
	private String productName;
	private Integer purchaseCost;
	
	//order_historiesテーブル
	private Integer id;
	private Integer orderNumber;
	private Integer sumPrice;
	private LocalDateTime createdAt;
	
	//adminsテーブル
	private String lastName;
	private String firstName;

}
