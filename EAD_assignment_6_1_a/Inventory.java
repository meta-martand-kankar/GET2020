package com.inventory.Assignment_5_a;

import javax.xml.bind.annotation.XmlRootElement;

/**
 * This class provides attributes for items in inventory.
 * @author Martand
 *
 */
@XmlRootElement
public class Inventory {
	private String itemName;
	private int quantity;

	/**
	 * This constructor is while taking Json array input from client.
	 */
	public Inventory() {

	}

	/**
	 * This constructor is used to initialize the item.
	 * @param name of item
	 * @param quantity of item
	 */
	public Inventory(String name, int quantity) {
		this.itemName = name;
		this.quantity = quantity;
	}

	public String getItemName() {
		return itemName;
	}

	public void setItemName(String itemName) {
		this.itemName = itemName;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
}
