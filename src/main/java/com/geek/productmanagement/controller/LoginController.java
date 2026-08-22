package com.geek.productmanagement.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.geek.productmanagement.entity.Admin;
import com.geek.productmanagement.service.AdminService;

@Controller
public class LoginController {
	
//	ControllerがAdminServiceクラスのオブジェクト(adminService)を持つ
	private final AdminService adminService;
	
	//コンストラクタ:
	public LoginController(AdminService adminService) {
		this.adminService = adminService;
	}
	
	@GetMapping("/login")
	String showLogin() {
		return "login";
	}
	
	@PostMapping("/login")
	String connectService(@RequestParam String email, 
						  @RequestParam String password){
		
		//入力メルアドに一致する「管理者情報」をDBから取得
		Admin admin = adminService.findByEmail(email);
		
		//DBからメルアド取得できないなら、ログイン画面に戻る「ログイン失敗」
		if(admin == null) {
			return "login";
		}
		
		//入力パスワードとDB内のパスワードが一致する場合、TOP画面に移動「ログイン成功」
		if (password.equals(admin.getPassword())) {
			return "redirect:/top";
		}
		
		//パスワードが間違いの場合、ログイン画面に戻る「ログイン失敗」
		return "login";
	}
	

}
