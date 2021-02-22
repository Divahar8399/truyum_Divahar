package com.cognizant.truyum.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.cognizant.truyum.model.MenuItem;

public class MenuItemDaoSqlImpl implements MenuItemDao {

	@Override
	public List<MenuItem> getMenuItemListAdmin() {
		Connection con = ConnectionHandler.getConnection();
		List<MenuItem> menuItem = new ArrayList<MenuItem>();
		String query = "Select * from menu_item";
		try {
			PreparedStatement ps = con.prepareStatement(query);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				long id = rs.getLong("id");
				String name = rs.getString("Name");
				long price = rs.getLong("Price");
				String active = rs.getString("Active");
				boolean Active = false;
				if (active.equalsIgnoreCase("Yes")) {
					Active = true;
				}
				Date date = rs.getDate("Date_of_Launch");
				String category = rs.getString("Category");
				String free_delivery = rs.getString("Free_Delivery");
				boolean Free_delivery = false;
				if (free_delivery.equalsIgnoreCase("Yes")) {
					Free_delivery = true;
				}
				MenuItem menu = new MenuItem(id, name, price, Active, date, category, Free_delivery);
				menuItem.add(menu);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return menuItem;

	}

	@Override
	public List<MenuItem> getMenuItemListCustomer() {
		Connection con = ConnectionHandler.getConnection();
		List<MenuItem> menuItem = new ArrayList<MenuItem>();
		String query = "select * from menu_item where ((year(Date_of_Launch)>=2021) and (Active like 'Yes')); ";
		try {
			PreparedStatement ps = con.prepareStatement(query);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				long id = rs.getLong("id");
				String name = rs.getString("Name");
				long price = rs.getLong("Price");
				String active = rs.getString("Active");
				boolean Active = false;
				if (active.equalsIgnoreCase("Yes")) {
					Active = true;
				}
				Date date = rs.getDate("Date_of_Launch");
				String category = rs.getString("Category");
				String free_delivery = rs.getString("Free_Delivery");
				boolean Free_delivery = false;
				if (free_delivery.equalsIgnoreCase("Yes")) {
					Free_delivery = true;
				}
				MenuItem menu = new MenuItem(id, name, price, Active, date, category, Free_delivery);
				menuItem.add(menu);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return menuItem;
	}

	@Override
	public MenuItem getMenuItem(long menuItemId) {
		Connection con = ConnectionHandler.getConnection();
		MenuItem menu = null;
		String query = "select * from menu_item where id = ?";
		try {
			PreparedStatement ps = con.prepareStatement(query);
			ps.setLong(1, menuItemId);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				long id = rs.getLong("id");
				String name = rs.getString("Name");
				long price = rs.getLong("Price");
				String active = rs.getString("Active");
				boolean Active = false;
				if (active.equalsIgnoreCase("Yes")) {
					Active = true;
				}
				Date date = rs.getDate("Date_of_Launch");
				String category = rs.getString("Category");
				String free_delivery = rs.getString("Free_Delivery");
				boolean Free_delivery = false;
				if (free_delivery.equalsIgnoreCase("Yes")) {
					Free_delivery = true;
				}
				menu = new MenuItem(id, name, price, Active, date, category, Free_delivery);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return menu;
	}

	@Override
	public void modifyMenuItem(MenuItem menuItem) {
		// TODO Auto-generated method stub
		Connection con = ConnectionHandler.getConnection();
		String query = "update menu_item set Name = ?,Price = ?,Active = ?,Date_of_Launch = ?,Category = ?,Free_delivery = ? where id = ?";
		try {
			PreparedStatement ps = con.prepareStatement(query);
			ps.setString(1, menuItem.getName());
			ps.setFloat(2, menuItem.getPrice());
			boolean active = menuItem.isActive();
			String Active = "No";
			if (active) {
				Active = "Yes";
			}
			ps.setString(3, Active);
			ps.setDate(4, (java.sql.Date) menuItem.getDateOFLaunch());
			ps.setString(5, menuItem.getCategory());
			boolean free_delivery = menuItem.isFreeDelivery();
			String Free_Delivery = "No";
			if (free_delivery) {
				Free_Delivery = "yes";
			}
			ps.setString(6, Free_Delivery);
			ps.setLong(7, menuItem.getId());
			ps.executeQuery();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}
