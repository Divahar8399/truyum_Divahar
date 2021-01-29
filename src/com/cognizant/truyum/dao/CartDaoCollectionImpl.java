package com.cognizant.truyum.dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import com.cognizant.truyum.model.Cart;
import com.cognizant.truyum.model.MenuItem;

public class CartDaoCollectionImpl implements CartDao{
	public  Map<Long,Cart> userCarts ;
	MenuItemDaoCollectionImpl menuItem = new MenuItemDaoCollectionImpl();
	public CartDaoCollectionImpl() {
		if(userCarts == null) {
			userCarts = new HashMap<Long,Cart>();	
		}
	}

	@Override
	public void addCartItem(long userId, long menuItemId) {
		MenuItemDao menuItemDao = new MenuItemDaoCollectionImpl();
		MenuItem menuItem = menuItemDao.getMenuItem(menuItemId);
        if(!userCarts.containsKey(userId)) {
        	userCarts.put(userId, new Cart(new ArrayList<MenuItem>(),0));
        }
        List<MenuItem> menuItemList = userCarts.get(userId).getMenu();
        menuItemList.add(menuItem);
	}

	@Override
	public List<MenuItem> getAllCartItems(long userId)  throws CartEmptyException{
		Cart cart = userCarts.get(userId);
		if(cart.getMenu().isEmpty()) {
			throw new CartEmptyException();
		}
		else {
			for(MenuItem value:cart.getMenu()) {
				double total = cart.getTotal() + value.getPrice();
				cart.setTotal(total);
			}
		}
		return cart.getMenu();
	}

	@Override
	public void removeCartItem(long userId, long menuItemId) {
		Cart cart = userCarts.get(userId);
		List<MenuItem> menuItem = cart.getMenu();
		for(MenuItem value:menuItem) {
			if(menuItemId == value.getId()) {
				menuItem.remove(value);
			}
		}
		
		
	}

}
