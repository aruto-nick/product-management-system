package com.geek.productmanagement.controller;

import java.util.List;

import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.geek.productmanagement.dto.ProductOrderHistoryDto;
import com.geek.productmanagement.entity.Admin;
import com.geek.productmanagement.service.AdminService;
import com.geek.productmanagement.service.ProductService;

@Controller
public class OrderHistoryController {
	
	private final ProductService productService;
	private final AdminService adminService;
	
	public OrderHistoryController(ProductService productService, AdminService adminService) {
		this.productService = productService;
		this.adminService = adminService;
	}

	@GetMapping("/order-history")
	String showOrderHistory(Authentication authentication,Model model) {
		
		//ログイン管理者のメルアド取得
		String loginEmail = authentication.getName();
		
		//ログイン管理者情報取得
		Admin loginAdmin = adminService.findByEmail(loginEmail);
		
		//ログイン管理者の店舗IDを取得
		Integer storeId = loginAdmin.getStoreId();
		
		//商品発注履歴を取得
		List<ProductOrderHistoryDto> productOrderHistoryList = productService.findOrderHistories(storeId);
		
		//商品発注履歴を格納
		model.addAttribute("productOrderHistoryList", productOrderHistoryList);
		
		return "order-history";
	}
}
