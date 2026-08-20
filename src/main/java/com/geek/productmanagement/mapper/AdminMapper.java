package com.geek.productmanagement.mapper;

import com.geek.productmanagement.entity.Admin;

public interface AdminMapper {
	Admin findByEmail(String email);
}
