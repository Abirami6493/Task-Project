package com.omrbranch.pojo.favourites;

import java.util.ArrayList;

import com.omrbranch.pojo.createorder.Acity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@NoArgsConstructor
@AllArgsConstructor
public class GetFavourite {
	private int id;
    private String product_code;
    private String image;
    private String name;
    private String description;
    private String manage_stock;
    private String quick_grab;
    private String is_exclusive;
    private String status;
    private String medium_image;
    private int cart_count;
    private ArrayList<Variation> variations;
    private String price;
    private String special_price;
    private String original_special_price;
    private int discount;
    private ArrayList<Integer> product_variation_option;
    private int product_variation_id;
    private int is_favorite;

}
