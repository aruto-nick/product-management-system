package com.geek.productmanagement.controller;

import java.util.List;

import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.geek.productmanagement.dto.ProductListDto;
import com.geek.productmanagement.entity.Admin;
import com.geek.productmanagement.entity.ChildCategory;
import com.geek.productmanagement.entity.MainCategory;
import com.geek.productmanagement.entity.SubCategory;
import com.geek.productmanagement.service.AdminService;
import com.geek.productmanagement.service.CategoryService;
import com.geek.productmanagement.service.ProductService;

@Controller
public class ProductController {
	
	private final ProductService productService;
	private final AdminService adminService;
	private final CategoryService categoryService;
	
	public ProductController(ProductService productService,
								AdminService adminService,
								CategoryService categoryService) {
		this.productService = productService;
		this.adminService = adminService;
		this.categoryService = categoryService;
	}
	
	@GetMapping("/product-list")
	String showProductList(@RequestParam(required = false) String productName, 
							@RequestParam(required = false) Integer mainCategoryId,
							@RequestParam(required = false) Integer subCategoryId,
							@RequestParam(required = false) Integer childCategoryId,
							@RequestParam(name = "page", defaultValue = "1") Integer page,
						Authentication authentication, Model model) {
		
		//ログイン管理者のメルアド取得
		String loginEmail = authentication.getName();
		
		//メルアドからログイン管理者の情報取得
		Admin loginAdmin = adminService.findByEmail(loginEmail);
		
		//ログイン管理者情報から店舗ID取得
		Integer storeId = loginAdmin.getStoreId();
		
		//1ページに表示する商品数
		Integer limit = 4;
		
		//次ページ遷移時に飛ばす商品件数
		Integer offset = (page -1)* limit;
		
		//検索結果に該当する商品件数
		Integer totalProducts = productService.countProducts(storeId, productName, mainCategoryId, subCategoryId, childCategoryId);
		
		//検索条件に該当する総ページ数
		Integer totalPages = (totalProducts + limit - 1 ) / limit;
		
		//検索条件に該当する総商品数をmodelに格納
		model.addAttribute("totalProducts", totalProducts);
		
		//検索条件に該当する総ページ数をmodelに格納
		model.addAttribute("totalPages", totalPages);
		
		//現在のページ数をmodelに格納
		model.addAttribute("currentPage",page);
		
		//大カテゴリ一覧を取得
		List<MainCategory> mainCategoryList = categoryService.findAllMainCategories();
		
		//大カテゴリ一覧をmodelに格納
		model.addAttribute("mainCategoryList", mainCategoryList);
		
		//中カテゴリ一覧（未選択大カテゴリ除く）を取得
		List<SubCategory> subCategoryList = categoryService.findSubCategoriesByMainCategoryId(mainCategoryId);
		
		//中カテゴリ一覧をmodelに格納
		model.addAttribute("subCategoryList", subCategoryList);
		
		//小カテゴリ一覧を取得
		List<ChildCategory> childCategoryList = categoryService.findChildCategoriesBySubCategoryId(subCategoryId);
		
		//小カテゴリ一覧をmodelに格納
		model.addAttribute("childCategoryList", childCategoryList);
		
		//現在ページに表示する商品一覧を取得
		List<ProductListDto> productList = productService.searchByStoreIdAndProductName(
				storeId,productName,mainCategoryId,subCategoryId,childCategoryId,limit,offset);
		
		//商品一覧をmodelに格納
		model.addAttribute("productList", productList);
		
		//検索ボックスに入力された商品名をmodelに格納
		model.addAttribute("productName", productName);
		
		//大カテゴリIDを格納
		model.addAttribute("mainCategoryId", mainCategoryId);
		
		//中カテゴリIDを格納
		model.addAttribute("subCategoryId", subCategoryId);
		
		//小カテゴリIDを格納
		model.addAttribute("childCategoryId", childCategoryId);
		
		return "product-list";
	}
	
	

}
