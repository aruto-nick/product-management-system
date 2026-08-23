package com.geek.productmanagement.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ProductController {
	
	@GetMapping("/product-list")
	String showProductList() {
		return "product-list";
	}

}
