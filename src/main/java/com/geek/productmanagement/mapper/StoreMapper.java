package com.geek.productmanagement.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.geek.productmanagement.entity.Store;

@Mapper
public interface StoreMapper {
	List<Store> findAll();

}
