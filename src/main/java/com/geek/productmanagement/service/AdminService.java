package com.geek.productmanagement.service;

import org.springframework.stereotype.Service;

import com.geek.productmanagement.entity.Admin;
import com.geek.productmanagement.mapper.AdminMapper;

@Service
public class AdminService {
	
	private final AdminMapper adminMapper;

	public AdminService(AdminMapper adminMapper) {
		this.adminMapper = adminMapper;
	}
	
	
	public Admin findByEmail(String email) {
		return adminMapper.findByEmail(email);
	}
	
	//管理者登録画面で入力した値をMapperに渡してDBに登録する
	public int insert(Admin admin) {
		return adminMapper.insert(admin);
	}
}
