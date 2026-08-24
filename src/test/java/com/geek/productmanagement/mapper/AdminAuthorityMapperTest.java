package com.geek.productmanagement.mapper;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.geek.productmanagement.entity.AdminAuthority;

@SpringBootTest
public class AdminAuthorityMapperTest {
	
	@Autowired
	private AdminAuthorityMapper adminAuthorityMapper;
	
	@Test
	void findAllTest() {
		//右：管理者権限テーブルからデータ取得→左：authoritiesに入れる
		List<AdminAuthority> authorities = adminAuthorityMapper.findAll() ;
		//Listがnullではないと確認
		assertNotNull(authorities);
		//Listの中にデータが1件以上あると確認
		assertFalse(authorities.isEmpty());
		//1件目のidを確認
		assertEquals(1,authorities.get(0).getId());
		//1件目の権限名を確認
		assertEquals("管理者",authorities.get(0).getAuthorityName());
	}
		


}
