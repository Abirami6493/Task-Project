package com.omrbranch.pojo.profilepic;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Profilepic_Output_Pojo {
	 private int status;
	    private String message;
	    private ProfilePic data;
	    private int cart_count;

}
