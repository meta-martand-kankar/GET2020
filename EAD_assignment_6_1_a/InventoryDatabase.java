package com.inventory.Assignment_5_a;

import java.util.HashMap;

/**
 * This class is used instead of database to provide database. 
 * @author Martand
 *
 */
public class InventoryDatabase {
	private static HashMap<String,Inventory> inventoryList = new HashMap<>();

	/**
	 * This function returns Inventory list.
	 * @return Inventory list.
	 */
	public static HashMap<String, Inventory> getInventoryList() {
		return inventoryList;
	}
}
