package com.omrbranch.pojo.createorder;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CreateOrder_Output_Pojo {
	 private int status;
	    private String message;
	    private String currency;
	    private CreateOrder data;
	    private int order_id;

}
