package com.omrbranch.stepdefinition;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.omrbranch.baseclass.BaseClass;
import com.omrbranch.endpoints.Endpoints;
import com.omrbranch.payloadmanager.PayloadObjectManager;
import com.omrbranch.pojo.address.AddAddress_Input_Pojo;
import com.omrbranch.pojo.address.CityList;
import com.omrbranch.pojo.address.CityList_Input_Pojo;
import com.omrbranch.pojo.address.CityList_Output_Pojo;
import com.omrbranch.pojo.address.StateList;
import com.omrbranch.pojo.address.StateList_Output_Pojo;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.response.Response;

public class TC002_AddressStep extends BaseClass{
	String logtoken ="eyJ0eXAiOiJKV1QiLCJhbGciOiJSUzI1NiIsImp0aSI6IjQ3ODZjYTU1MTAwNzY4MzM2Y2FhOTVhNzE0YjBhODMwY2Q0NjlkNGQ3MDg3YzNlZGMwYmEwNjQxZTY0N2ExZjVkOThhMGFiZWMwYWNmYmQxIn0.eyJhdWQiOiIzIiwianRpIjoiNDc4NmNhNTUxMDA3NjgzMzZjYWE5NWE3MTRiMGE4MzBjZDQ2OWQ0ZDcwODdjM2VkYzBiYTA2NDFlNjQ3YTFmNWQ5OGEwYWJlYzBhY2ZiZDEiLCJpYXQiOjE3NDY0NDM0NTksIm5iZiI6MTc0NjQ0MzQ1OSwiZXhwIjoxNzc3OTc5NDU5LCJzdWIiOiI0MSIsInNjb3BlcyI6W119.R6oLEqpEF_tw6T9cBGkoNQy4-NR-76NNBqFAzauDRDGfTsqfEo2Ip7LxtQCfqMHZYLBzSqIw1xFwbXw_E_NM2JBHpF62ht1AngLdsXJx3SUG7vjWqRvBZcNzd7qLyK3ouXLiCrZV0Q0Pc9V1wnb2TwGEUisJ3Y5uw8ACZeO9AgD8apBwzK_RxvFZLI2qvzexuJ9ge6crTsp-nxi8Adxx_LW-a0aNBEPZOW1qwEWoQUtMdbI5pK-tlrE6c866M-T_rn16hRtiFcsLInkRg8_98afdSkPu-CnD2zP5pUsvIKGM7wldbZYngPKlq9s4_UhUkIEpz8R1siOnmjYSxYwiieOgrMUCLPeqC9vAZ0lAFY2t8cvPraYiExj8G6KsGmJ1jBbJQdA7kwjNcGHqf9fYgdxFa1Ei1aP6Jno26a0z34ZEPyIJBu2CT3IBQWL0cDvcBb3WxnvaXfQhx881l52UmRZyJyG4YTLhNNuqsWh3mXV_CaCcO1P0Kf_-CSFlP8cSXHDeGxINuQ9hWc8dpPpKzW9Xwu7PgV9t3iH5JXQ3FbRzFDb2IjF72bSudIUGZq15Zspu96nqdT_j0F8xSlIShkgOMi2xsd66P4RYRPrf-1mC_jQrshm45W49UDGaVaqL1ZEnFP1FmX_wPb_avydMSl11-FIxWM9BAU7_MvCCdNE";
	PayloadObjectManager payloadObjectManager = new PayloadObjectManager();
	Response response;

	
	@Given("User add headers for to StateList")
	public void userAddHeadersForToStateList() {
		addHeader("accept", "application/json");

	   
	}
	@When("User send {string} request for StateList endpoint")
	public void userSendRequestForStateListEndpoint(String type) {
		 response= addRequest(type, Endpoints.STATELIST);
		 int statusCode = getStatusCode(response);
	     TC001_LoginStep.globalDatas.setStatusCode(statusCode);

	   
	}
	@Then("User should verify the stateList response message matches {string} and saved state id")
	public void userShouldVerifyTheStateListResponseMessageMatchesAndSavedStateId(String stateIdText1) {
		StateList_Output_Pojo stateListOutputPojo = response.as(StateList_Output_Pojo.class);
		   ArrayList<StateList> listStates = stateListOutputPojo.getData();
		   for (StateList stateList : listStates) {
			   String stateName = stateList.getName();
			   if(stateName.equals("Tamil Nadu")) {
				   int stateIdNum = stateList.getId();
				  String  stateIdText = String.valueOf(stateIdNum);
				  
				   System.out.println(stateIdText);
				 
				   TC001_LoginStep.globalDatas.setStateIdText(stateIdText);
				   break;
			   }
		   }
		
	   
	

	    
	}
	
	

	@Given("User add header  for to get CityList")
	public void userAddHeaderForToGetCityList() {
		 Header h1 = new Header("accept", "application/json");
	     Header h2 = new Header("Content-Type", "application/json");
	     List<Header>headerList= new ArrayList<Header>();
	     headerList.add(h1);
	     headerList.add(h2);
	     Headers headers = new Headers(headerList);
	     addHeader(headers);

	    
	}
	@When("User add request body state id for  get city list")
	public void userAddRequestBodyStateIdForGetCityList() {
		CityList_Input_Pojo cityListPayload = payloadObjectManager.getAddressPayload().addCityListPayload(TC001_LoginStep.globalDatas.getStateIdText());
		addPayload(cityListPayload);

	   
	}
	@When("User send {string} request for CityList endpoint")
	public void userSendRequestForCityListEndpoint(String type) {
		

		 response = addRequest(type, Endpoints.CITYLIST);
		 int statusCode = getStatusCode(response);
		 TC001_LoginStep.globalDatas.setStatusCode(statusCode);

	  
	}
	@Then("User verify the cityList response message matches {string} and saved city id")
	public void userVerifyTheCityListResponseMessageMatchesAndSavedCityId(String string) {
		CityList_Output_Pojo cityList = response.as(CityList_Output_Pojo.class);
		 ArrayList<CityList> listCities = cityList.getData();
		 for (CityList Citylist : listCities) {
			 String cityname = Citylist.getName();
			 if (cityname.equals("Chennai")) {
			int cityId = Citylist.getId();
				String city_id = String.valueOf(cityId);
				
				 System.out.println(city_id);
				TC001_LoginStep.globalDatas.setCity_id(city_id);
				TC001_LoginStep.globalDatas.setCityId(cityId);
				 break;
	   
	}}
	    
	}

	
	
	@Given("User add header and bearer authorization for accessing address endpoints")
	public void userAddHeaderAndBearerAuthorizationForAccessingAddressEndpoints() {
		Header h1 = new Header("accept","application/json");
		Header h2 = new Header("Content-Type","application/json");
		Header h3 = new Header("Authorization","Bearer "+logtoken);
		List<Header>listHeaders= new ArrayList<Header>();
		   listHeaders.add(h1);
           listHeaders.add(h2);
		   listHeaders.add(h3);
		   Headers headers = new Headers(listHeaders);
		   addHeader(headers);
		

	    
	}
	



	

	@When("User add request body for add new address {string},{string},{string},{string},{string},{string},{string},{string},{string},and {string}")
	public void userAddRequestBodyForAddNewAddressAnd(String first_name, String last_name, String mobile, String apartment,
            String state, String city, String country, String zipcode,
            String address, String address_type) throws JsonProcessingException {
		 int stateId = Integer.parseInt(state);
		    int cityId = Integer.parseInt(city);
		    int countryId = Integer.parseInt(country);

		    AddAddress_Input_Pojo input = new AddAddress_Input_Pojo(
		        first_name, last_name, mobile, apartment,
		        stateId, cityId, countryId, zipcode, address, address_type
		    );
		    addPayload(input);
	   
	}









	@When("User send {string} request for addUserAddress endpoint")
	public void userSendRequestForAddUserAddressEndpoint(String type) {
		 response = addRequest(type, Endpoints.ADDUSERADDRESS);
		 int statusCode = getStatusCode(response);
		 TC001_LoginStep.globalDatas.setStatusCode(statusCode);
		
	    
	}
	@Then("User should verify the addUserAddress response message matches {string} and get the address id saved")
	public void userShouldVerifyTheAddUserAddressResponseMessageMatchesAndGetTheAddressIdSaved(String expmessage) {
		
	com.omrbranch.pojo.address.AddAddress_Output_Pojo address = response.as(com.omrbranch.pojo.address.AddAddress_Output_Pojo.class);
		int addressid = address.getAddress_id();
		String address_id= String.valueOf(addressid);
		
		System.out.println(address_id);
		TC001_LoginStep.globalDatas.setAddress_id(address_id);
		String actmessage = address.getMessage();
		
		



	  
	}


	

	@When("User add request body to update new address {string},{string},{string},{string},{string},{string},{string},{string},{string} and 	\"home\"")
	public void userAddRequestBodyToUpdateNewAddressAndHome(String string, String string2, String string3, String string4, String string5, String string6, String string7, String string8, String string9) {
	    
	}
	@When("User send {string} request for update addUserAddress endpoint")
	public void userSendRequestForUpdateAddUserAddressEndpoint(String string) {
	    
	}
	@Then("User verify the update address response message matches {string}")
	public void userVerifyTheUpdateAddressResponseMessageMatches(String string) {
	   
	}
	
	
	

	@Given("User add Headers and Bearer authorization for accessing Get address endpoints")
	public void userAddHeadersAndBearerAuthorizationForAccessingGetAddressEndpoints() {
	   
	}



	@When("User Send {string} request for GetUserAddress endpoint")
	public void userSendRequestForGetUserAddressEndpoint(String string) {
	   
	}
	@Then("User verify the GetUserAddress response message matches {string}")
	public void userVerifyTheGetUserAddressResponseMessageMatches(String string) {
	    
	}



	

	
	@When("User add request body for address id")
	public void userAddRequestBodyForAddressId() {
	    
	}
	@When("User Send {string} request for DeleteAddress endpoint")
	public void userSendRequestForDeleteAddressEndpoint(String string) {
	  
	}
	@Then("User verify the DeleteAddress response message matches {string}")
	public void userVerifyTheDeleteAddressResponseMessageMatches(String string) {
	    
	}










	
	
	
}


