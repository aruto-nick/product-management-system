package com.geek.productmanagement.controller;

import java.util.List;

import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.geek.productmanagement.dto.ProductDetailDto;
import com.geek.productmanagement.dto.ProductListDto;
import com.geek.productmanagement.dto.ProductOrderDto;
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
	
	//商品詳細画面
	@GetMapping("/product-detail")
	String showProductDetail(
			@RequestParam("productId") Integer productId,Authentication authentication,Model model) {
		//ログイン管理者のメルアド取得
		String loginEmail = authentication.getName();
		
		//メルアドから管理者情報を取得
		Admin loginAdmin = adminService.findByEmail(loginEmail);
		
		//管理者情報から店舗ID取得
		Integer storeId = loginAdmin.getStoreId();
		
		//商品詳細情報取得
		ProductDetailDto productDetailDto = productService.findProductDetailById(storeId, productId);
		
		//商品詳細情報を格納
		model.addAttribute("productDetailDto", productDetailDto);
		
		return "product-detail";
	}
	
	//商品発注画面遷移
	@GetMapping("/product-order")
	String showProductOrder(Authentication authentication,Model model,
			@RequestParam("productId") Integer productId) {
		
		//ログイン管理者のメルアド取得
		String loginEmail = authentication.getName();
		
		//メルアドから管理者情報取得
		Admin loginAdmin = adminService.findByEmail(loginEmail);
		
		//管理者情報から店舗IDを取得
		Integer storeId = loginAdmin.getStoreId();
		
		//店舗IDと商品IDを基に、発注商品の情報取得
		ProductOrderDto productOrderDto = productService.findProductOrder(storeId, productId);
		
		//発注商品情報を格納
		model.addAttribute("productOrderDto", productOrderDto);
		
		return "product-order";
	}
	

}
