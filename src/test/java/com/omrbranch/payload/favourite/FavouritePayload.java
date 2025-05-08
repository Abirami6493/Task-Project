package com.omrbranch.payload.favourite;

import com.omrbranch.pojo.favourites.ManageFavourite_Input_Pojo;

public class FavouritePayload {
	public ManageFavourite_Input_Pojo addFavourite(String product_id,String product_variation_id) {

		ManageFavourite_Input_Pojo favourite_Input_Pojo = new ManageFavourite_Input_Pojo(product_id, product_variation_id);
		return favourite_Input_Pojo;
	}

}

