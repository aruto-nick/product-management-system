package com.geek.productmanagement.entity;

import java.time.LocalDateTime;

import lombok.Data;

@Data
public class Admin {

	private Integer id;
	
	private Integer storeId;
	
	private Integer positionId;
	
	private Integer authorityId;
	
	private String lastName;
	
	private String firstName;
	
	private String email;
	
	private String phoneNumber;
	
	private String password;
	
	private LocalDateTime createdAt;
	
	private LocalDateTime updatedAt;
}
