package com.geek.productmanagement.controller;

import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.geek.productmanagement.dto.AdminDetailDto;
import com.geek.productmanagement.entity.Admin;
import com.geek.productmanagement.service.AdminService;

@Controller
public class TopController {

	private final AdminService adminService;
	
	public TopController(AdminService adminService) {
		this.adminService = adminService;
	}
	
	@GetMapping("/top")
	String showTop(Authentication authentication, Model model) {
		
		//ログイン中のメルアド取得
		String loginEmail = authentication.getName();
		
		//メルアドからログイン管理者の情報取得
		Admin loginAdmin = adminService.findByEmail(loginEmail);
		
		//ログイン管理者情報から管理者IDを取得
		Integer adminId = loginAdmin.getId();
		
		//店舗IDから「ログイン管理者の姓名」と「店舗名」を取得
		AdminDetailDto adminNameAndStoreName = adminService.findAdminNameAndStoreNameById(adminId);
		
		model.addAttribute("adminNameAndStoreName", adminNameAndStoreName);
		return "top";
	}
	
}
