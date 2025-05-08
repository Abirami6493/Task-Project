package com.omrbranch.stepdefinition;



import java.io.FileNotFoundException;
import java.io.IOException;

import org.junit.Assert;

import com.omrbranch.baseclass.BaseClass;
import com.omrbranch.endpoints.Endpoints;
import com.omrbranch.globaldatas.GlobalDatas;
import com.omrbranch.pojo.login.PostmanBasicLoginAuth_Output_Pojo;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.response.Response;

public class TC001_LoginStep extends BaseClass {
	
	Response response;
	public static GlobalDatas globalDatas = new GlobalDatas();
   

	@Given("User add header")
	public void userAddHeader() {
		addHeader("accept","application/json");
	}   
	@When("User add basic authentication for login")
	public void userAddBasicAuthenticationForLogin() throws FileNotFoundException, IOException {
		System.out.println("Loading config file from: " + getProjectPath() + "\\config\\config.properties");

		addBasicAuth(getPropertyFileValue("userName"), getPropertyFileValue("password"));
		
		
	}
	
	
	@When("User send {string} request for login endpoint")
	public void userSendRequestForLoginEndpoint(String type) {
		 response = addRequest(type, Endpoints.POSTMANBASICAUTHLOGIN);
	int statusCode = getStatusCode(response);
	globalDatas.setStatusCode(statusCode);
	System.out.println(statusCode);
	   
	}
	
	@Then("User should verify the login response body firstName present as {string} and get the logtoken saved")
	public void userShouldVerifyTheLoginResponseBodyFirstNamePresentAsAndGetTheLogtokenSaved(String expFirstName){
		PostmanBasicLoginAuth_Output_Pojo loginAuthOutputPojo = response.as(PostmanBasicLoginAuth_Output_Pojo.class);
		String actfirst_name = loginAuthOutputPojo.getData().getFirst_name();
	   String logtoken = loginAuthOutputPojo.getData().getLogtoken();
	   globalDatas.setLogToken(logtoken);
		Assert.assertEquals("Verify Select Success Message", expFirstName, actfirst_name);
	       
	}




}
