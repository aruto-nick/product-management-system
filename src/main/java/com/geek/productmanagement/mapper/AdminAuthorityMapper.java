package com.geek.productmanagement.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.geek.productmanagement.entity.AdminAuthority;

@Mapper
public interface AdminAuthorityMapper {
	List<AdminAuthority> findAll();

}
