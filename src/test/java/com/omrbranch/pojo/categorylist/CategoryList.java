package com.omrbranch.pojo.categorylist;

import java.util.ArrayList;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@NoArgsConstructor
@AllArgsConstructor
public class CategoryList {
	 private int id;
	    private String name;
	    private String image;
	    private int subcategory_count;
	    private ArrayList<ChildCategoryList> child_cat_list;

}
