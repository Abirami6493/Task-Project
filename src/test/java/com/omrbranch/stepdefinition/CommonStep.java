package com.omrbranch.stepdefinition;



import io.cucumber.java.en.Then;

public class CommonStep {
	
	@Then("User should verify the status code is {int}")
	public void userShouldVerifyTheStatusCodeIs(int expStatusCode) {
		TC001_LoginStep.globalDatas.getStatusCode();
	
	    
	}
	
}


