package com.geek.productmanagement.entity;

import lombok.Data;

//DBのadmin_authoritiesテーブルのデータを扱うEntity
@Data
public class AdminAuthority {
	private Integer id;
	
	private String authorityName;

}
