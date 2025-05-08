package com.omrbranch.pojo.favourites;

import java.util.ArrayList;

import com.omrbranch.pojo.createorder.Acity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@NoArgsConstructor
@AllArgsConstructor
public class GetFavourite_Output_Pojo {
	private int status;
    private String message;
    private ArrayList<GetFavourite> data;
    private int cart_count;
    private String currency;
}
