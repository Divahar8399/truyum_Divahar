package com.cognizant.truyum.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.cognizant.truyum.model.Cart;
import com.cognizant.truyum.model.MenuItem;

public class CartDaoSqlImpl implements CartDao {

	@Override
	public void addCartItem(long userId, long menuItemId) {
		// TODO Auto-generated method stub
		Connection con = ConnectionHandler.getConnection();
		String query = "insert cart(user_id,menu_id) values(?,?)";
		try {
			PreparedStatement ps = con.prepareStatement(query);
			ps.setLong(1, userId);
			ps.setLong(2, menuItemId);
			ps.executeQuery();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@Override
	public List<MenuItem> getAllCartItems(long userId) throws CartEmptyException {
		Connection con = ConnectionHandler.getConnection();
		List<MenuItem> menuItem = new ArrayList<MenuItem>();
		@SuppressWarnings("unused")
		Cart cart = new Cart(menuItem,0);
		String query = "select * from cart c join menu_item m on m.id = c.menu_id where c.user_id = ?;";
		try {
			PreparedStatement ps = con.prepareStatement(query);
			ps.setLong(1, userId);
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
				menuItem.add(menu); }
			} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
		return menuItem;
	}

	@Override
	public void removeCartItem(long userId, long menuItemId) {
		// TODO Auto-generated method stub
		Connection con = ConnectionHandler.getConnection();
		String query = "delete from cart where user_id =? and menu_id = ?;";
		PreparedStatement ps;
		try {
			ps = con.prepareStatement(query);
			ps.setLong(1, userId);
			ps.setLong(2, menuItemId);
			ps.executeQuery();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
