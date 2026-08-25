package com.geek.productmanagement.dto;

import lombok.Data;

@Data
//最終的に受け取るデータ名を定義する
public class AdminListDto {
	private Integer id;
	
	private String storeName;
	
	private String lastName;
	
	private String firstName;
	
	private String positionName;
	
	private String authorityName;

}
