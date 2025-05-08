package com.omrbranch.stepdefinition;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class Tc004_AddFavouritesStep {
	

	@Given("User add headers for category List")
	public void userAddHeadersForCategoryList() {
	   
	}
	@When("User send {string} request for category List endpoint")
	public void userSendRequestForCategoryListEndpoint(String string) {
	    
	}
	@Then("User should verify the category List response message matches {string} and get the category id of main category Name {string} and the sub category Name of {string} saved")
	public void userShouldVerifyTheCategoryListResponseMessageMatchesAndGetTheCategoryIdOfMainCategoryNameAndTheSubCategoryNameOfSaved(String string, String string2, String string3) {
	    
	}
	
	@Given("User add headers for product List")
	public void userAddHeadersForProductList() {
	   
	}
	@When("User add request body for product list with category_id and page no {string}")
	public void userAddRequestBodyForProductListWithCategoryIdAndPageNo(String string) {
	   
	}
	@When("User send {string} request for product List endpoint")
	public void userSendRequestForProductListEndpoint(String string) {
	    
	}
	@Then("User should verify the product List response message matches {string} with product name of {string}  and save variant id with specifications {string}")
	public void userShouldVerifyTheProductListResponseMessageMatchesWithProductNameOfAndSaveVariantIdWithSpecifications(String string, String string2, String string3) {
	    
	}
	
	@Given("User add header and bearer authorization for accessing manage Favourite List endpoints")
	public void userAddHeaderAndBearerAuthorizationForAccessingManageFavouriteListEndpoints() {
	    
	}
	@When("User add request body for manage favorites list")
	public void userAddRequestBodyForManageFavoritesList() {
	    
	}
	@When("User send {string} request for manage favorites List endpoint")
	public void userSendRequestForManageFavoritesListEndpoint(String string) {
	    
	}
	@Then("User should verify the manage favorites List response message matches {string}")
	public void userShouldVerifyTheManageFavoritesListResponseMessageMatches(String string) {
	   
		
		
	}

	
	@Given("User add header and bearer authorization for accessing get Favourite List endpoints")
	public void userAddHeaderAndBearerAuthorizationForAccessingGetFavouriteListEndpoints() {
	    
	}
	@When("User send {string} request for favourite List endpoint")
	public void userSendRequestForFavouriteListEndpoint(String string) {
	    
	}
	@Then("User should verify the get favourite List response message matches {string}")
	public void userShouldVerifyTheGetFavouriteListResponseMessageMatches(String string) {
	    
	}
	
	














}
