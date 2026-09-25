package com.geek.productmanagement.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.geek.productmanagement.entity.AdminAuthority;
import com.geek.productmanagement.mapper.AdminAuthorityMapper;

@Service
public class AdminAuthorityService {
	private final AdminAuthorityMapper adminAuthorityMapper;
	
	public AdminAuthorityService(AdminAuthorityMapper adminAuthorityMapper) {
		this.adminAuthorityMapper = adminAuthorityMapper;
	}
	
	public List<AdminAuthority> findAll() {
		return adminAuthorityMapper.findAll();
	}

}
