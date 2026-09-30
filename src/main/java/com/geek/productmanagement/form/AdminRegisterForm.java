package com.geek.productmanagement.form;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class AdminRegisterForm {
	
	@NotNull
	private Integer storeId;
	
	@NotBlank
	@Size(max = 10)
	private String lastName;
	
	@NotBlank
	@Size(max = 10)
	private String firstName;
	
	@NotBlank
	@Email
	private String email;
	
	@NotNull
	private Integer positionId;
	
	@NotNull
	private Integer authorityId;
	
	@NotBlank
	@Pattern(regexp = "[0-9]{10,11}")
	private String phoneNumber;
	
	@NotBlank
	@Size(max = 64, min = 8)
	private String password;

}
