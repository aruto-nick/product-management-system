package com.geek.productmanagement.mapper;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import com.geek.productmanagement.entity.Admin;

@SpringBootTest
//テストデータ登録＆テスト実施後、ロールバックしてテストデータを削除する
@Transactional
public class AdminMapperTest {

	@Autowired
	private AdminMapper adminMapper;
	
	@Test
	void findByEmailTest(){
		
		//①テストデータの準備
		Admin testAdmin = new Admin();
		
		//テスト用のデータを入れる
		testAdmin.setStoreId(1);
		testAdmin.setPositionId(1);
		testAdmin.setAuthorityId(1);
		testAdmin.setLastName("テスト");
		testAdmin.setFirstName("A太朗");
		testAdmin.setEmail("test@gmail.com");
		testAdmin.setPhoneNumber("0120114514");
		testAdmin.setPassword("testtest");
		
		//②テストデータをDBに登録
		adminMapper.insert(testAdmin);
	
		//③テスト対象のfindByEmailを実行
		Admin admin = adminMapper.findByEmail(testAdmin.getEmail());
	
		//④結果の検証
		//テストデータが存在するか否か
		assertNotNull(admin);
		
		//テストデータとDB取得データが一致するか否か
		assertEquals(testAdmin.getEmail(), admin.getEmail());
		
		
	}
	
	
}
