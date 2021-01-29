package com.cognizant.truyum.model;

import java.util.ArrayList;
import java.util.List;

public class Cart {
	private List<MenuItem> menuItemList = new ArrayList<>();
	private double total;

	public Cart(List<MenuItem> menu, double total) {
		super();
		this.menuItemList = menu;
		this.total = total;
	}

	public List<MenuItem> getMenu() {
		return menuItemList;
	}

	public void setMenu(List<MenuItem> menu) {
		this.menuItemList = menu;
	}

	public double getTotal() {
		return total;
	}

	public void setTotal(double total) {
		this.total = total;
	}

	@Override
	public String toString() {
		return "Cart [menu=" + menuItemList + ", total=" + total + "]";
	}

}
