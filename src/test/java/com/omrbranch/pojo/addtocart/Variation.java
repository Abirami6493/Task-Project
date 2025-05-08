package com.omrbranch.pojo.addtocart;

import java.util.ArrayList;

import com.omrbranch.pojo.categorylist.CategoryList;
import com.omrbranch.pojo.categorylist.categoryList_Output_Pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Variation {
	 public int id;
	    public int product_id;
	    public String weight;
	    public int unit_id;
	    public int qty;
	    public String price;
	    public String special_price;
	    public int max_qty;
	    public String status;
	    public String created_at;
	    public String updated_at;
	    public int cart_count;
	    public String original_special_price;
	    public int discount;
	    public int is_available;
	    public int is_favorite;
	    public String specifications;
	    public ArrayList<Options> options;

}
