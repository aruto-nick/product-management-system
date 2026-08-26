package com.geek.productmanagement.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.geek.productmanagement.dto.AdminListDto;
import com.geek.productmanagement.entity.Admin;

@Mapper
public interface AdminMapper {
	Admin findByEmail(String email);
	
	//1人分の管理者情報を受け取り、DBにINSERTするメソッド
	int insert(Admin admin);
	
	//管理者一覧画面のデータを復習取得して、返すメソッド
	List<AdminListDto> findAll();
}
