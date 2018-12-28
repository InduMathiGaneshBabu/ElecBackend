package com.electronics.Dao;

import java.util.List;

import com.electronics.model.Cart;

public interface CartDao
{
	public boolean addToCart(Cart cart);
	public boolean deleteItemFromCart(Cart cart);
	public boolean updateCartItem(Cart cart);
	public Cart getCartItem(int cartid);
	public List<Cart> listCartItems(String username);

}
