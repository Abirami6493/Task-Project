package com.omrbranch.payload.address;


import com.omrbranch.pojo.address.AddAddress_Input_Pojo;
import com.omrbranch.pojo.address.CityList_Input_Pojo;
import com.omrbranch.pojo.address.DeleteAddress_Input_Pojo;
import com.omrbranch.pojo.address.SetAddress_Input_Pojo;
import com.omrbranch.pojo.address.UpdateAddress_Input_Pojo;

public class AddressPayLoad {
	public CityList_Input_Pojo addCityListPayload(String stateId) {
		CityList_Input_Pojo cityList = new CityList_Input_Pojo(stateId);
		return cityList;
		
	}
	
	
	public AddAddress_Input_Pojo addAddressPa(String first_name,String last_name,String mobile,String apartment,int state, int city, int country, String zipcode, String address, String address_type) {
		AddAddress_Input_Pojo addAddress = new AddAddress_Input_Pojo(first_name, last_name, mobile, apartment, state, city, country, zipcode, address, address_type);
		return addAddress;
		

	}
	
	public UpdateAddress_Input_Pojo addUpdatedAddressPayload(String address_id,String first_name,String last_name,String mobile,String apartment,int state, int city, int country, String zipcode, String address, String address_type) {
		UpdateAddress_Input_Pojo updateAddress = new UpdateAddress_Input_Pojo(address_id, first_name, last_name, mobile, apartment, state, city, country, zipcode, address, address_type);
		return updateAddress;
	}
	
	public SetAddress_Input_Pojo setAddressPayload(String address_id,String cart_id) {
		SetAddress_Input_Pojo setAddress = new SetAddress_Input_Pojo(address_id, cart_id);
		return setAddress;
		
		
	}
	
	
	public DeleteAddress_Input_Pojo deleteAddress(String address_id) {
		DeleteAddress_Input_Pojo deleteAddress = new DeleteAddress_Input_Pojo(address_id);
		return deleteAddress;
		

	}

}
