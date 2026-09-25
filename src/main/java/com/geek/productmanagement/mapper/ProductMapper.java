package com.geek.productmanagement.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.geek.productmanagement.dto.ProductDetailDto;
import com.geek.productmanagement.dto.ProductListDto;
import com.geek.productmanagement.dto.ProductOrderDto;
import com.geek.productmanagement.dto.ProductOrderHistoryDto;

@Mapper
public interface ProductMapper {
	//商品一覧表示メソッド
	List<ProductListDto>  findAllByStoreId(
			@Param("storeId") Integer storeId);
	
	//商品検索メソッド
	List<ProductListDto> searchByStoreIdAndProductName(
			@Param("storeId") Integer storeId,
			@Param("productName") String productName,
			@Param("mainCategoryId")Integer mainCategoryId,
			@Param("subCategoryId")Integer subCategoryId,
			@Param("childCategoryId") Integer childCategoryId,
			@Param("limit") Integer limit, 
			@Param("offset") Integer offset);
	
	//商品一覧画面の総商品数をカウント
	public Integer countProducts(
			@Param("storeId")Integer storeId,
			@Param("productName") String productName,
			@Param("mainCategoryId")Integer mainCategoryId,
			@Param("subCategoryId")Integer subCategoryId,
			@Param("childCategoryId") Integer childCategoryId);
	
	//商品詳細画面の項目取得
	public ProductDetailDto findProductDetailById(
			@Param("storeId")Integer storeId,
			@Param("productId")Integer productId);
	
	//商品発注画面の表示項目を取得
	public ProductOrderDto findProductOrder(
			@Param("storeId")Integer storeId,
			@Param("productId")Integer productId);
	
	//発注画面：①在庫数＋発注数にDB更新
	int increaseStoreStock(
			@Param("storeId") Integer storeId,
			@Param("productId") Integer productId,
			@Param("orderNumber") Integer orderNumber);
	
	//発注画面:②在庫履歴をDB登録
	int insertOrderHistory(
			@Param ("storeId") Integer storeId,
			@Param ("productId") Integer productId,
			@Param ("adminId") Integer adminId,
			@Param("orderNumber") Integer orderNumber,
			@Param("sumPrice") Integer sumPrice);
	
	//	商品発注履歴取得
	List<ProductOrderHistoryDto> findOrderHistories(
			@Param("storeId") Integer storeId);
}
