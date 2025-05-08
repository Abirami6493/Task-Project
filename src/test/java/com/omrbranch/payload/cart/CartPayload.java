package com.omrbranch.payload.cart;

import com.omrbranch.pojo.addtocart.AddToCart_Input_Pojo;

public class CartPayload {
	
public AddToCart_Input_Pojo addToCart(String product_id,String product_variation_id,String type) {
		
	AddToCart_Input_Pojo addToCart_Input_Pojo = new AddToCart_Input_Pojo(product_id, product_variation_id, type);
		return addToCart_Input_Pojo;
	}

}
