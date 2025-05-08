package com.omrbranch.stepdefinition;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.omrbranch.baseclass.BaseClass;
import com.omrbranch.endpoints.Endpoints;
import com.omrbranch.payload.order.OrderPayLoad;
import com.omrbranch.payloadmanager.PayloadObjectManager;
import com.omrbranch.pojo.address.SetAddress_Input_Pojo;
import com.omrbranch.pojo.addtocart.AddToCart_Input_Pojo;
import com.omrbranch.pojo.createorder.CreateOrder_Input_Pojo;
import com.omrbranch.pojo.createorder.CreateOrder_Output_Pojo;
import com.omrbranch.pojo.getcartitems.GetCartItems;
import com.omrbranch.pojo.getcartitems.GetCartItems_Output_Pojo;
import com.omrbranch.pojo.getsearchresult.SearchProducts;
import com.omrbranch.pojo.getsearchresult.SearchResult_Input_Pojo;
import com.omrbranch.pojo.getsearchresult.SearchResult_Output_Pojo;
import com.omrbranch.pojo.getsearchresult.Variation;
import com.omrbranch.pojo.getsearchresult.VariationOption;
import com.omrbranch.pojo.searchproduct.SearchProduct;
import com.omrbranch.pojo.searchproduct.SearchProduct_Input_Pojo;
import com.omrbranch.pojo.searchproduct.SearchProduct_Output_Pojo;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.response.Response;

public class TC006_CreateOrderBySearchStep extends BaseClass {
	
	PayloadObjectManager payloadObjectManager = new PayloadObjectManager();
	Response response;
	@Given("User add header and bearer authorization for accessing clear cart endpoints")
	public void userAddHeaderAndBearerAuthorizationForAccessingClearCartEndpoints() {
	    
	}
	@When("User send {string} request for clear cart endpoint")
	public void userSendRequestForClearCartEndpoint(String string) {
	  
	}
	@Then("User should verify the response message {string}")
	public void userShouldVerifyTheResponseMessage(String string) {
	    
	}
	

	@Given("User add headers for search product")
	public void userAddHeadersForSearchProduct() {
		Header h1 = new Header("accept", "application/json");
	     Header h2 = new Header("Content-Type", "application/json");
	     List<Header>headerList= new ArrayList<Header>();
	     headerList.add(h1);
	     headerList.add(h2);
	     Headers headers = new Headers(headerList);
	     addHeader(headers);
		
		
	    
	}
	@When("User add request body for search product {string}")
	public void userAddRequestBodyForSearchProduct(String string) {
		SearchProduct_Input_Pojo searchProduct = payloadObjectManager.getProductPayload().addSearchProductPayload("nuts");
		addPayload(searchProduct);
	   
	}
	@When("User send {string} request for search product endpoint")
	public void userSendRequestForSearchProductEndpoint(String type) {
		
		 response = addRequest(type, Endpoints.SEARCHPRODUCT);
		 int statusCode = getStatusCode(response);
		 TC001_LoginStep.globalDatas.setStatusCode(statusCode);
		
	   
	}
	@Then("User should verify the search product response message matches {string} and save category id and product id with category name {string}")
	public void userShouldVerifyTheSearchProductResponseMessageMatchesAndSaveCategoryIdAndProductIdWithCategoryName(String string, String string2) {
		
		
		 SearchProduct_Output_Pojo output = response.as(SearchProduct_Output_Pojo.class);
	     ArrayList<SearchProduct> data = output.getData();
	     for (SearchProduct searchProduct : data) {
	    	 String productName = searchProduct.getText();
	    	 if(productName.equals("Happilo 100% Natural Premium California Almonds | Premium Badam Giri in Fruit & Nuts"))
	    	 {
	    	 int categoryid = searchProduct.getCategory_id();
	    	String category_id = String.valueOf(categoryid);
	    	System.out.println(category_id);
	    	TC001_LoginStep.globalDatas.setCategory_id(category_id);
	    	 
	    	 int id1 = searchProduct.getId();
	    	String id = String.valueOf(id1);
	    	 System.out.println("Prductid="+id);
	    	 TC001_LoginStep.globalDatas.setId(id);
	    	 
	    	 
	    	 break;
	    	 
	    	 }	 
			
		}
	   
	}
	
	
	

	@Given("User add header and bearer authorization for accessing get search product List endpoints")
	public void userAddHeaderAndBearerAuthorizationForAccessingGetSearchProductListEndpoints() {
		Header h1 = new Header("accept", "application/json");
	     Header h2 = new Header("Content-Type", "application/json");
	     Header h3 = new Header("Authorization","Bearer "+TC001_LoginStep.globalDatas.getLogToken());
	     List<Header>headerList= new ArrayList<Header>();
	     headerList.add(h1);
	     headerList.add(h2);
	     headerList.add(h3);
	     Headers headers = new Headers(headerList);
	     addHeader(headers);
		
		
	    
	}
	@When("User add request body for get search product")
	public void userAddRequestBodyForGetSearchProduct() {
		 SearchResult_Input_Pojo input=payloadObjectManager.getProductPayload().addSearchResultProduct(TC001_LoginStep.globalDatas.getCategory_id(), TC001_LoginStep.globalDatas.getId(),"category");
	     addPayload(input);
	}
	@When("User send {string} request for get search product List endpoint")
	public void userSendRequestForGetSearchProductListEndpoint(String type) {
		 response = addRequest(type, Endpoints.GETSEARCHRESULT);
		 int statusCode = getStatusCode(response);
		 TC001_LoginStep.globalDatas.setStatusCode(statusCode);
		
		
	   
	}
	@Then("User should verify the get search product response message matches {string} with product id and save variant id with specifications {string}")
	public void userShouldVerifyTheGetSearchProductResponseMessageMatchesWithProductIdAndSaveVariantIdWithSpecifications(String string, String string2) {
		SearchResult_Output_Pojo output = response.as(SearchResult_Output_Pojo.class);
	    ArrayList<SearchProducts> data = output.getData();

	    for (SearchProducts searchProducts : data) {
	    	String name = searchProducts.getName();
	    	System.out.println(name);
	        ArrayList<Variation> variations = searchProducts.getVariations();
	       
	        for (Variation variation : variations) {
	            ArrayList<VariationOption> variation_option = variation.getVariation_option();
	           
	            if (variation_option != null) { 
	                for (VariationOption option : variation_option) {
	                    int variationid = option.getVariation_id();
	              String variation_id = String.valueOf(variationid);
	                    System.out.println(variation_id);
	                    TC001_LoginStep.globalDatas.setVariation_id(variation_id);
	                  
	                    break;
	                }
	            }
	        }
	    }
	}
	
	
	@Given("User add header and bearer authorization for accessing add to cart endpoints")
	public void userAddHeaderAndBearerAuthorizationForAccessingAddToCartEndpoints() {
		
		Header h1 = new Header("accept", "application/json");
	     Header h2 = new Header("Content-Type", "application/json");
	     Header h3 = new Header("Authorization","Bearer "+TC001_LoginStep.globalDatas.getLogToken());
	     List<Header>headerList= new ArrayList<Header>();
	     headerList.add(h1);
	     headerList.add(h2);
	     headerList.add(h3);
	     Headers headers = new Headers(headerList);
	     addHeader(headers);
	  
	}
	@When("User add request body for add to cart")
	public void userAddRequestBodyForAddToCart() {
		
	AddToCart_Input_Pojo addToCart = payloadObjectManager.getCartPayload().addToCart(TC001_LoginStep.globalDatas.getId(), TC001_LoginStep.globalDatas.getVariation_id(), "plus");
	addPayload(addToCart);
	
	
	}
	
	@When("User send {string} request for add to cart endpoint")
	public void userSendRequestForAddToCartEndpoint(String type) {
		response = addRequest(type, Endpoints.ADDTOCART);
		 int statusCode = getStatusCode(response);
		 TC001_LoginStep.globalDatas.setStatusCode(statusCode);
		 
	   
	}



	@Then("User should verify the add to cart response message matches {string}")
	public void userShouldVerifyTheAddToCartResponseMessageMatches(String string) {
		 int statusCode = getStatusCode(response);
		 TC001_LoginStep.globalDatas.setStatusCode(statusCode);
		
	   
	}
	
	
	@Given("User add header and bearer authorization for accessing get cart endpoints")
	public void userAddHeaderAndBearerAuthorizationForAccessingGetCartEndpoints() {
		
		Header h1 = new Header("accept", "application/json");
	    
	     Header h3 = new Header("Authorization","Bearer "+TC001_LoginStep.globalDatas.getLogToken());
	     List<Header>headerList= new ArrayList<Header>();
	     headerList.add(h1);
	    
	     headerList.add(h3);
	     Headers headers = new Headers(headerList);
	     addHeader(headers);
		
		
	    
	}
	@When("User send {string} request for get cart endpoint")
	public void userSendRequestForGetCartEndpoint(String type) {
		response = addRequest(type, Endpoints.GETCARTITEMS);
		

		 int statusCode = getStatusCode(response);
		 TC001_LoginStep.globalDatas.setStatusCode(statusCode);
		
		
	   
	}
	@Then("User should verify the get cart response message matches {string} and save the cart id")
	public void userShouldVerifyTheGetCartResponseMessageMatchesAndSaveTheCartId(String string) {
		
		System.out.println("Response null? " + (response == null));
		GetCartItems_Output_Pojo output = response.as(GetCartItems_Output_Pojo.class);
		System.out.println("Response null? " + (response == null));
		 
			ArrayList<GetCartItems> data = output.getData();
			for (GetCartItems getCartItems : data) {
				int cartid = getCartItems.getCart_id();
				 String cart_id = String.valueOf(cartid);
				 TC001_LoginStep.globalDatas.setCart_id(cart_id);
				System.out.println("CartId="+cart_id);
			}
	   
	}
	
	
	
	@Given("User add header and bearer authorization for accessing set address endpoints")
	public void userAddHeaderAndBearerAuthorizationForAccessingSetAddressEndpoints() {
		Header h1 = new Header("accept", "application/json");
	     Header h2 = new Header("Content-Type", "application/json");
	     Header h3 = new Header("Authorization","Bearer "+TC001_LoginStep.globalDatas.getLogToken());
	     List<Header>headerList= new ArrayList<Header>();
	     headerList.add(h1);
	     headerList.add(h2);
	     headerList.add(h3);
	     Headers headers = new Headers(headerList);
	     addHeader(headers);
		
	    
	}
	@When("User add request body for set address product")
	public void userAddRequestBodyForSetAddressProduct() {
		
		
		 SetAddress_Input_Pojo setAddressPayload = payloadObjectManager.getAddressPayload().setAddressPayload(TC001_LoginStep.globalDatas.getAddress_id(), TC001_LoginStep.globalDatas.getCart_id());
		addPayload(setAddressPayload);
		
	   
	}
	@When("User send {string} request for set address endpoint")
	public void userSendRequestForSetAddressEndpoint(String string) {
	    
	}
	@Then("User should verify the set address response message matches {string}")
	public void userShouldVerifyTheSetAddressResponseMessageMatches(String string) {
	   
	}


	@Given("User add header and bearer authorization for accessing create order endpoints")
	public void userAddHeaderAndBearerAuthorizationForAccessingCreateOrderEndpoints() {
		Header h1 = new Header("accept", "application/json");
	     Header h2 = new Header("Content-Type", "application/json");
	     Header h3 = new Header("Authorization","Bearer "+TC001_LoginStep.globalDatas.getLogToken());
	     List<Header>headerList= new ArrayList<Header>();
	     headerList.add(h1);
	     headerList.add(h2);
	     headerList.add(h3);
	     Headers headers = new Headers(headerList);
	     addHeader(headers);
		
	  
	}
	@When("User add request body for create order product")
	public void userAddRequestBodyForCreateOrderProduct(io.cucumber.datatable.DataTable dataTable) {
		Map<String, String> card = dataTable.asMaps().get(0);

	    String cardNo = card.get("CardNo");        // e.g., "5555555555554444"
	    String cardType = card.get("Select card").toLowerCase(); // Convert card type to lowercase
	    String cardName = card.get("CardName");    // e.g., "Your name"
	    String month = card.get("Month");          // e.g., "March"
	    String year = card.get("Year");            // e.g., "2028"
	    String cvv = card.get("CVV");              // e.g., "143"

	    // Now, payment_method is fixed to "debit_card"
	    String paymentMethod = "debit_card";       // Payment method set to debit_card

	    // Creating the payload using OrderPayLoad class
	    OrderPayLoad orderPayLoad = new OrderPayLoad();
	    CreateOrder_Input_Pojo createOrderPayload = orderPayLoad.addCreateOrder(paymentMethod, cardNo, cardType, year, month, cvv);

	    // Adding the payload to the request
	    addPayload(createOrderPayload);
	    
	    
	   
	   
	}

	
	@When("User send {string} request for create order endpoint")
	public void userSendRequestForCreateOrderEndpoint(String type) {
		response = addRequest(type, Endpoints.CREATEORDER);
		
		

		
		
		
		
	   
	}
	@Then("User should verify the create order response message matches {string}")
	public void userShouldVerifyTheCreateOrderResponseMessageMatches(String string) {
		 int statusCode = getStatusCode(response);
		 TC001_LoginStep.globalDatas.setStatusCode(statusCode);
		 CreateOrder_Output_Pojo output = response.as(CreateOrder_Output_Pojo.class);
			int orderid = output.getOrder_id();
		     String order_id = String.valueOf(orderid);
			System.out.println("OrderId="+order_id);
			TC001_LoginStep.globalDatas.setOrder_id(order_id);
			
			String message = output.getMessage();
			System.out.println(message);
		
		
	}
	
	@Then("User should verify the addUserAddress response message matches {string}")
	public void userShouldVerifyTheAddUserAddressResponseMessageMatches(String string) {
	
	}















	

	
	    
	}






















