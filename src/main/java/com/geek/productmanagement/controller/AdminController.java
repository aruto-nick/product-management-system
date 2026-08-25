package com.geek.productmanagement.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.geek.productmanagement.service.AdminAuthorityService;
import com.geek.productmanagement.service.AdminPositionService;
import com.geek.productmanagement.service.StoreService;

@Controller
public class AdminController {
	
	private final AdminAuthorityService adminAuthorityService;	
	private final AdminPositionService adminPositionService;
	private final StoreService storeService;
	public AdminController(AdminAuthorityService adminAuthorityService, 
							AdminPositionService adminPositionService, 
							StoreService storeService) {
		this.adminAuthorityService = adminAuthorityService;
		this.adminPositionService = adminPositionService;
		this.storeService = storeService;
	}
	
	//管理者登録画面に遷移
	@GetMapping("/admin-register")
	String showAdminRegister(Model model) {
		//Serviceから取得したデータをModelに入れる
		model.addAttribute("authorities", adminAuthorityService.findAll());
		model.addAttribute("positions", adminPositionService.findAll());
		model.addAttribute("stores", storeService.findAll());
		return "admin-register";
	}

	//管理者一覧画面に遷移
	@GetMapping("/admin-list")
	String showAdminList() {
		return "admin-list";
	}
	

	
}
