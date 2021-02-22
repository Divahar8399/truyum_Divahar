package com.cognizant.truyum.dao;

import java.util.List;

import com.cognizant.truyum.model.MenuItem;

public class CartDaoSqlImplTest {

	public static void main(String[] args) throws CartEmptyException {
		// TODO Auto-generated method stub
		testAddCartItem();
		testGetAllCartItems();
		testRemoveCartItem();

	}
	
	public static void testAddCartItem() throws CartEmptyException {
		CartDao cartDao = new CartDaoSqlImpl();
		cartDao.addCartItem(1, 2);
		List<MenuItem> cartItems = cartDao.getAllCartItems(1);
		for (MenuItem value : cartItems) {
			System.out.println(value);
		}
	}
	
	public static void testGetAllCartItems() throws CartEmptyException {
		CartDao cartDao = new CartDaoSqlImpl();
		List<MenuItem> cartItems = cartDao.getAllCartItems(1);
		for (MenuItem value : cartItems) {
			System.out.println(value);
		}
	}
	
	public static void testRemoveCartItem() {
		CartDao cartDao = new CartDaoSqlImpl();
		cartDao.removeCartItem(1, 2);
		try {
			cartDao.getAllCartItems(1);
		} catch (CartEmptyException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}


}
