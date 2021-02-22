package com.cognizant.truyum.dao;

import java.util.List;

import com.cognizant.truyum.model.MenuItem;
import com.cognizant.truyum.util.DateUtil;

public class MenuItemDaoSqlImplTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		testGetMenuItemListAdmin();
		testGetMenuItemListCustomer();
		testModifyMenuItem();
		testGetMenuItem();
	}

	public static void testGetMenuItemListAdmin() {
		MenuItemDao menuitemDao = new MenuItemDaoSqlImpl();
		List<MenuItem> menuItemList = menuitemDao.getMenuItemListAdmin();
		for (MenuItem value : menuItemList) {
			System.out.println(value);
		}
	}

	public static void testGetMenuItemListCustomer() {
		MenuItemDao menuItemDao = new MenuItemDaoSqlImpl();
		List<MenuItem> customerList = menuItemDao.getMenuItemListCustomer();
		for (MenuItem value : customerList) {
			System.out.println(value);
		}

	}

	public static void testModifyMenuItem() {
		MenuItem menuItem = new MenuItem(5, "Chocalate Browine", 64.00f, true, DateUtil.convertToDate("02/11/2022"),
				"Dessert", true);
		MenuItemDao menuItemDao = new MenuItemDaoSqlImpl();
		menuItemDao.modifyMenuItem(menuItem);

	}

	public static void testGetMenuItem() {
		MenuItemDao menuItemDao = new MenuItemDaoSqlImpl();
		MenuItem menu = menuItemDao.getMenuItem(1);
		System.out.println(menu);
		
	}

}
