package com.omrbranch.payload.order;

import com.omrbranch.pojo.cancelorder.CancelOrder_Input_Pojo;
import com.omrbranch.pojo.createorder.CreateOrder_Input_Pojo;

public class OrderPayLoad {
	public CreateOrder_Input_Pojo addCreateOrder(String payment_method,String card_no,String card_type, String year, String month,String cvv) {
		CreateOrder_Input_Pojo input_Pojo = new CreateOrder_Input_Pojo(payment_method, card_no,card_type, year, month, cvv);
		return input_Pojo;

	}
	
   

	
	public CancelOrder_Input_Pojo addCancelOrderPayload(String order_id) {
		CancelOrder_Input_Pojo input_Pojo = new CancelOrder_Input_Pojo(order_id);
		return input_Pojo;

	}

}
