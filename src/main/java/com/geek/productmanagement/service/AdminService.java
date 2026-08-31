package com.geek.productmanagement.service;

import java.util.List;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.geek.productmanagement.dto.AdminDetailDto;
import com.geek.productmanagement.dto.AdminListDto;
import com.geek.productmanagement.entity.Admin;
import com.geek.productmanagement.mapper.AdminMapper;

@Service
public class AdminService {
	
	private final AdminMapper adminMapper;
	//登録パスワードをハッシュ化するため、passwordEncoderを使用可能にする
	private final PasswordEncoder passwordEncoder;

	public AdminService(AdminMapper adminMapper,
			 			PasswordEncoder passwordEncoder) {
		this.adminMapper = adminMapper;
		this.passwordEncoder = passwordEncoder;
	}
	
	
	public Admin findByEmail(String email) {
		return adminMapper.findByEmail(email);
	}
	
	//管理者登録画面で入力したパスワードをハッシュ化した後に、Mapperに渡す
	public int insert(Admin admin) {
		//取得したパスワードをハッシュ化
		String encodedPasseword = passwordEncoder.encode(admin.getPassword());
		//Adminのパスワードをハッシュ化後の値に設定
		admin.setPassword(encodedPasseword);
		//ハッシュ化パスワードを含むAdminをMapperに渡す
		return adminMapper.insert(admin);
	}
	
	//管理者一覧画面に必要なデータをMapperから取得する
	public List<AdminListDto> findAll(){
		return adminMapper.findAll();
	}
	
	//管理者詳細画面に必要なデータをMapperから取得する
	public AdminDetailDto findDetailById(Integer id) {
		return adminMapper.findDetailById(id);
	}
	
	//管理者詳細画面にて管理者データを「削除」する機能
	public int deleteById(Integer id) {
		return adminMapper.deleteById(id);
	}
}
