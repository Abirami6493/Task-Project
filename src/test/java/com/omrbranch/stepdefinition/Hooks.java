package com.omrbranch.stepdefinition;

import io.cucumber.java.After;
import io.cucumber.java.Scenario;

public class Hooks {
	@After
	public void afterHook(Scenario scenario) {
		scenario.log(TC001_LoginStep.globalDatas.getResponseBody());
		
	}

}
