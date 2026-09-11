package com.geek.productmanagement.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class AccessDeniedController {
	@RequestMapping("/access-denied")
	String showAccessDenied() {
		return "access-denied";
	}

}
