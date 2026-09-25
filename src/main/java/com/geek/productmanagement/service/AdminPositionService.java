package com.geek.productmanagement.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.geek.productmanagement.entity.AdminPosition;
import com.geek.productmanagement.mapper.AdminPositionMapper;

@Service
public class AdminPositionService {
	//AdminPositionMapperインタフェース内のメソッドをServiceクラス内で使えるようにするため
	private final AdminPositionMapper adminPositionMapper;
	//右：(Mapperインタフェースの変数)を左:(Serviceクラスの変数)に入れた
	public AdminPositionService(AdminPositionMapper adminPositionMapper) {
		this.adminPositionMapper = adminPositionMapper;
	}
	//ServiceのfindAll()メソッド実行時、MapperのfindAll()メソッド実行して返す
	public List<AdminPosition> findAll() {
		return adminPositionMapper.findAll();
	}

}
