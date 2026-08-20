package com.geek.productmanagement.Service;

import org.springframework.stereotype.Service;

import com.geek.productmanagement.mapper.AdminMapper;

@Service
public class AdminService {
	
	private final AdminMapper adminMapper;

	public AdminService(AdminMapper adminMapper) {
		this.adminMapper = adminMapper;
	}
}
