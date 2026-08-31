package com.geek.productmanagement.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.geek.productmanagement.entity.Admin;
import com.geek.productmanagement.service.AdminAuthorityService;
import com.geek.productmanagement.service.AdminPositionService;
import com.geek.productmanagement.service.AdminService;
import com.geek.productmanagement.service.StoreService;

@Controller
public class AdminController {
	//画面のドロップダウン方式のための３つのServiceクラスを使えるようにするため
	private final AdminAuthorityService adminAuthorityService;	
	private final AdminPositionService adminPositionService;
	private final StoreService storeService;
	//AdminServiceクラスを使えるようにするため	
	private final AdminService adminService;
	public AdminController(AdminAuthorityService adminAuthorityService, 
							AdminPositionService adminPositionService, 
							StoreService storeService,
							AdminService adminService) {
		this.adminAuthorityService = adminAuthorityService;
		this.adminPositionService = adminPositionService;
		this.storeService = storeService;
		this.adminService = adminService;
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
	
	@PostMapping("/admin-register")
	String connectAdminService(@RequestParam Integer storeId,
								@RequestParam String lastName,
								@RequestParam String firstName,
								@RequestParam String email,
								@RequestParam Integer positionId,
								@RequestParam Integer authorityId,
								@RequestParam String phoneNumber,
								@RequestParam String password) {
		
		//Adminオブジェクトを作成
		Admin admin = new Admin();
		
		//setterで８項目をadminに格納
		admin.setStoreId(storeId);
		admin.setPositionId(positionId);
		admin.setAuthorityId(authorityId);
		admin.setLastName(lastName);
		admin.setFirstName(firstName);
		admin.setEmail(email);
		admin.setPhoneNumber(phoneNumber);
		admin.setPassword(password);
		
		//管理者登録を実行して、登録「件数」をresultに入れる
		int result = adminService.insert(admin);
		
		//登録成功時、TOP画面に遷移
		if(result == 1) {
			return "redirect:/top";		
		}else
		//登録失敗時、管理者登録画面のまま遷移しない
			{
			return "admin-register";
		}

	}

	//管理者一覧画面に遷移
	@GetMapping("/admin-list")
	String showAdminList(Model model) {
		//Serviceから取得したデータをModelに格納。"admins"と名付け
		model.addAttribute("admins", adminService.findAll());
		return "admin-list";
	}
	
	//管理者詳細画面に遷移
	@GetMapping("/admin-detail")
	String showAdminDetail(@RequestParam("id") Integer id,Model model) {
		model.addAttribute("admin", adminService.findDetailById(id));
		return "admin-detail";
	}
	
	//管理者編集画面に遷移
	@GetMapping("/admin-edit")
	String showAdminEdit(@RequestParam("id")Integer id) {
		return "admin-edit";
	}
	
	//管理者詳細画面の「削除機能」
	@PostMapping("/admin-delete")
	String deleteById(@RequestParam("id") Integer id) {
		adminService.deleteById(id);
		return "redirect:/admin-list";
	}

	
}
