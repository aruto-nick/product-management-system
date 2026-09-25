package com.geek.productmanagement.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

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
	
	//管理者編集画面にてデータ編集をするメソッド
	int updateById(Admin Admin);
	
	//管理者編集画面に「初期値＝現在の管理者情報」を表示するメソッド
	Admin findById(Integer id); 
	
	//TOP画面に「管理者姓名」と「店舗名」を表示するメソッド
	AdminDetailDto findAdminNameAndStoreNameById(
			@Param("adminId")Integer id);
	
}
