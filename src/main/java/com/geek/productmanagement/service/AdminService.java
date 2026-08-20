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
}
