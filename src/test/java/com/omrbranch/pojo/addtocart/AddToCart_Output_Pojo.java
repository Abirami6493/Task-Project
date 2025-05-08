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
public class AddToCart_Output_Pojo {
	private int status;
    private String message;
    private String currency;
    private int cart_count;
    private AddToCart data;

}
