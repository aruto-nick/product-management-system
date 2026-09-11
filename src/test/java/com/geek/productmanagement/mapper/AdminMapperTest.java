package com.geek.productmanagement.mapper;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.geek.productmanagement.entity.Admin;

@SpringBootTest
public class AdminMapperTest {

	@Autowired
	private AdminMapper adminMapper;
	
	@Test
	void findByEmailTest(){
		String email = "tanaka@gmail.com";
	
		Admin admin = adminMapper.findByEmail(email);
	
		assertNotNull(admin);
		
		assertEquals(email, admin.getEmail());
		
		
	}
	
	
}
