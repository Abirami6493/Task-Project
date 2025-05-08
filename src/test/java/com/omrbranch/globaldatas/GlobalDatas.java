package com.omrbranch.globaldatas;



import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor

public class GlobalDatas {
	private int statusCode;
	private String logToken;
	//private String addressId;
	private String responseBody;
	private String stateIdText;
	private int stateIdNum;
	private String city_id;
	private int cityId;
	
    private String address_id;
    private String category_id;
    private String id;
   private String variation_id;
   private String cart_id;
   private String order_id;
	

}
