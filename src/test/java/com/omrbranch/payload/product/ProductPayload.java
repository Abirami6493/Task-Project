package com.omrbranch.payload.product;

import com.omrbranch.pojo.getsearchresult.SearchResult_Input_Pojo;
import com.omrbranch.pojo.productlist.ProductList_Input_Pojo;
import com.omrbranch.pojo.searchproduct.SearchProduct_Input_Pojo;

public class ProductPayload {
	
	public ProductList_Input_Pojo addProductPayLoad(String category_id,String page_no) {
		
		ProductList_Input_Pojo productList = new ProductList_Input_Pojo(category_id, page_no);
		return productList;
		

	}
	
	
	public SearchProduct_Input_Pojo addSearchProductPayload(String text) {
		SearchProduct_Input_Pojo searchProduct = new SearchProduct_Input_Pojo( text);
		return searchProduct;
	}
	
	public SearchResult_Input_Pojo addSearchResultProduct(String category_id, String id, String type) {
		SearchResult_Input_Pojo searchResult = new  SearchResult_Input_Pojo(category_id, id, type);
		return searchResult;
	
	}

}
