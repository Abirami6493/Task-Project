package com.omrbranch.pojo.getsearchresult;

import java.util.ArrayList;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class SearchResult_Output_Pojo {
	private int status;
    private String message;
    private String currency;
    private ArrayList<SearchProducts> data;
    private int cart_count;

}
