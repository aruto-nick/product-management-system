package com.geek.productmanagement.mapper;

import org.apache.ibatis.annotations.Mapper;

import com.geek.productmanagement.entity.Admin;

@Mapper
public interface AdminMapper {
	Admin findByEmail(String email);
	
	//1人分の管理者情報を受け取り、DBにINSERTするメソッド
	int insert(Admin admin);
}
