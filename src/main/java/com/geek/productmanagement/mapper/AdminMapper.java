package com.geek.productmanagement.mapper;

import org.apache.ibatis.annotations.Mapper;

import com.geek.productmanagement.entity.Admin;

@Mapper
public interface AdminMapper {
	Admin findByEmail(String email);
}
