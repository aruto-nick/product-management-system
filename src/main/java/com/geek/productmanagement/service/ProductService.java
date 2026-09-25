package com.geek.productmanagement.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.geek.productmanagement.dto.ProductDetailDto;
import com.geek.productmanagement.dto.ProductListDto;
import com.geek.productmanagement.dto.ProductOrderDto;
import com.geek.productmanagement.dto.ProductOrderHistoryDto;
import com.geek.productmanagement.mapper.ProductMapper;


@Service
public class ProductService {
	private final ProductMapper productMapper;
	
	public ProductService(ProductMapper productMapper) {
		this.productMapper = productMapper;
	}
	
	public List<ProductListDto> findAllByStoreId(Integer storeId){
		return productMapper.findAllByStoreId(storeId);
	}
	
	public List<ProductListDto> searchByStoreIdAndProductName(Integer storeId,
										String productName,Integer mainCategoryId,
										Integer subCategoryId, Integer childCategoryId,
										Integer limit, Integer offset){
		return productMapper.searchByStoreIdAndProductName(storeId, productName, mainCategoryId, 
						subCategoryId,childCategoryId, limit, offset);
	}
	
	//商品一覧画面の商品数をカウント
	public Integer countProducts(Integer storeId,
				String productName,Integer mainCategoryId,
				Integer subCategoryId, Integer childCategoryId) {
		
		return productMapper.countProducts(storeId, productName, mainCategoryId, subCategoryId, childCategoryId);
	}
	
	//商品詳細画面に表示
	public ProductDetailDto findProductDetailById(Integer storeId, Integer productId) {
		return productMapper.findProductDetailById(storeId, productId);
	}
	
	//商品発注画面の表示
	public ProductOrderDto findProductOrder(Integer storeId, Integer productId) {
		return productMapper.findProductOrder(storeId, productId);
	}
	
	//発注メソッド①と②を１つにまとめる
	@Transactional
	public void orderProduct(Integer adminId, Integer storeId, Integer productId, Integer orderNumber) {
		
		//発注数の入力チェック
		if (orderNumber == null || orderNumber <= 0) {
			throw new IllegalArgumentException("発注数は１以上で入力してください");
		}
		
		//DBから商品の仕入れ原価を取得
		ProductOrderDto productOrderDto = productMapper.findProductOrder(storeId, productId);
		
		//商品IDが不正な場合　(例)別店舗の商品IDなど
		if (productOrderDto == null) {
			throw new IllegalArgumentException("発注対象の商品が存在しません");
		}
		
		//合計金額＝仕入れ金額×発注数
		Integer sumPrice = productOrderDto.getPurchaseCost() * orderNumber;
		
		//①在庫数を発注数分増やす
		int updateRows = productMapper.increaseStoreStock(storeId, productId, orderNumber);
		
		if (updateRows != 1) {
			throw new IllegalArgumentException("在庫数を更新できませんでした");
		}
		
		//②発注履歴を登録
		int insertedRows = productMapper.insertOrderHistory(storeId, productId, adminId, orderNumber, sumPrice);
		
		if (insertedRows != 1) {
			throw new IllegalArgumentException("発注履歴を登録できませんでした");
		}
		
	}
	
	//発注履歴の取得
	public List<ProductOrderHistoryDto> findOrderHistories(Integer storeId) {
		return productMapper.findOrderHistories(storeId);
	}
	


}
