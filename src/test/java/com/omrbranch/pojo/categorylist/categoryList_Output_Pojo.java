package com.omrbranch.pojo.categorylist;

import java.util.ArrayList;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class categoryList_Output_Pojo {
	
	
	   private int status;
	    private String message;
	    private ArrayList<CategoryList> data;
	

}
