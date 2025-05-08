package com.omrbranch.payloadmanager;

import com.omrbranch.payload.address.AddressPayLoad;
import com.omrbranch.payload.cart.CartPayload;
import com.omrbranch.payload.favourite.FavouritePayload;
import com.omrbranch.payload.order.OrderPayLoad;
import com.omrbranch.payload.product.ProductPayload;

public class PayloadObjectManager {
	
	private AddressPayLoad addressPayload;
	private CartPayload cartPayload;
	private FavouritePayload favouritePayload;
	private OrderPayLoad orderPayload;
	private ProductPayload productPayload;
	
	public AddressPayLoad getAddressPayload() {
		return (addressPayload==null)?addressPayload=new AddressPayLoad():addressPayload;
	}
	public CartPayload getCartPayload() {
		return (cartPayload==null)? cartPayload = new CartPayload():cartPayload;
	}
	public FavouritePayload getFavouritePayload() {
		return (favouritePayload==null)? favouritePayload = new FavouritePayload():favouritePayload;
	}
	public OrderPayLoad getOrderPayload() {
		return (orderPayload==null)? orderPayload = new OrderPayLoad():orderPayload;
	}
	public ProductPayload getProductPayload() {
		return (productPayload==null)? productPayload = new ProductPayload():productPayload;
	}

}
