package com.omrbranch.pojo.login;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@NoArgsConstructor
@AllArgsConstructor
public class PostmanBasicLoginAuth_Output_Pojo  {
	
	public int status;
    public String message;
    public Login data;
    public String refer_msg;
    public int cart_count;
    public String role;
}