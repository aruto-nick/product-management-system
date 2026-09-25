package com.geek.productmanagement.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.geek.productmanagement.entity.Store;
import com.geek.productmanagement.mapper.StoreMapper;

@Service
public class StoreService {
	private final StoreMapper storeMapper;
	
	public StoreService(StoreMapper storeMapper) {
		this.storeMapper = storeMapper;
	}
	
	public List<Store> findAll(){
		return storeMapper.findAll();
	}

}
