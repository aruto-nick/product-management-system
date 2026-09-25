package com.geek.productmanagement.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.geek.productmanagement.entity.AdminPosition;

@Mapper
public interface AdminPositionMapper {
	List<AdminPosition> findAll();
}
