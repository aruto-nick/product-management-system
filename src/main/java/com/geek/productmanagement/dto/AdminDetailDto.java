package com.geek.productmanagement.dto;

import java.time.LocalDateTime;

import lombok.Data;

@Data
public class AdminDetailDto {
	private Integer id;
	
	private String storeName;
	
	private String lastName;
	
	private String firstName;
	
	private String email;
	
	private String positionName;
	
	private String authorityName;
	
	private String phoneNumber;
	
	private LocalDateTime createdAt;
	
	private LocalDateTime updatedAt;

}
