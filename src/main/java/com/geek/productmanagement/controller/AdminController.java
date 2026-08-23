package com.geek.productmanagement.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AdminController {
	
	//管理者登録画面に遷移
	@GetMapping("/admin-register")
	String showAdminRegister() {
		return "admin-register";
	}

	//管理者一覧画面に遷移
	@GetMapping("/admin-list")
	String showAdminList() {
		return "/admin-list";
	}
	

	
}
