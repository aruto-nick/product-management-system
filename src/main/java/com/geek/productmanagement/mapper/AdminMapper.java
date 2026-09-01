package com.geek.productmanagement.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.geek.productmanagement.dto.AdminDetailDto;
import com.geek.productmanagement.dto.AdminListDto;
import com.geek.productmanagement.entity.Admin;

@Mapper
public interface AdminMapper {
	Admin findByEmail(String email);
	
	//1人分の管理者情報を受け取り、DBにINSERTするメソッド
	int insert(Admin admin);
	
	//管理者一覧画面のデータを複数件取得して、返すメソッド
	List<AdminListDto> findAll();
	
	//管理者詳細画面のデータ１件取得して、返すメソッド
	AdminDetailDto findDetailById(Integer id);
	
	//管理者詳細画面からデータを削除するメソッド
	//削除の影響を受けた行数「1」をintで受け取る
	int deleteById(Integer id); 
}
