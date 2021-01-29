package com.cognizant.truyum.dao;

import java.util.List;
import com.cognizant.truyum.model.MenuItem;
import com.cognizant.truyum.util.DateUtil;


public class MenuItemDaoCollectionImplTest {
	
	public static void main(String[] args) {
		testGetMenuItemListAdmin();
		testGetMenuItemListCustomer();
		testModifyMenuItem();
	}
	public static void testGetMenuItemListAdmin() {
		MenuItemDao menuitemDao = new MenuItemDaoCollectionImpl();
		List<MenuItem> menuItemList = menuitemDao.getMenuItemListAdmin();
		for(MenuItem value:menuItemList) {
			System.out.println(value);
		}
	}
	public static void testGetMenuItemListCustomer() {
		MenuItemDao menuItemDao = new MenuItemDaoCollectionImpl();
		List<MenuItem> customerList = menuItemDao.getMenuItemListCustomer();
		for(MenuItem value:customerList) {
			System.out.println(value);
		}
	}
	
	public static void testModifyMenuItem() {
		MenuItem menuItem = new MenuItem(5,"Chocalate Browine",64.00f,true,DateUtil.convertToDate("02/11/2022"),"Dessert",true);
		long productId = menuItem.getId();
		MenuItemDao menuItemDao = new MenuItemDaoCollectionImpl();
		menuItemDao.modifyMenuItem(menuItem);
		menuItemDao.getMenuItem(productId);
	}

}
