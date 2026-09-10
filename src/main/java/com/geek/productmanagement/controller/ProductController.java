package com.geek.productmanagement.controller;

import java.util.List;

import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.geek.productmanagement.dto.ProductListDto;
import com.geek.productmanagement.entity.Admin;
import com.geek.productmanagement.service.AdminService;
import com.geek.productmanagement.service.ProductService;

@Controller
public class ProductController {
	
	private final ProductService productService;
	private final AdminService adminService;
	
	public ProductController(ProductService productService,
								AdminService adminService) {
		this.productService = productService;
		this.adminService = adminService;
	}
	
	@GetMapping("/product-list")
	String showProductList(Authentication authentication, Model model) {
		
		//ログイン管理者のメルアド取得
		String loginEmail = authentication.getName();
		
		//メルアドからログイン管理者の情報取得
		Admin loginAdmin = adminService.findByEmail(loginEmail);
		
		//ログイン管理者情報から店舗ID取得
		Integer storeId = loginAdmin.getStoreId();
		
		//所属店舗の商品一覧情報を取得
		List<ProductListDto> productList = productService.findAllByStoreId(storeId);
		
		//商品一覧をmodelに格納
		model.addAttribute("productList", productList);
		
		return "product-list";
	}

}
