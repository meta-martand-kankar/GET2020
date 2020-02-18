package com.inventory.Assignment_5_a;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * This class performs operation on database.
 * @author Martand
 *
 */
public class InventoryService {

	private HashMap<String, Inventory> inventoryList = InventoryDatabase.getInventoryList(); 

	public ArrayList<Inventory> getInventoryList() {
		return new ArrayList<Inventory>(inventoryList.values());
	}

	/**
	 * Initializes the List.
	 */
	public InventoryService() {
		Inventory obj1 = new Inventory("Apple",10);
		Inventory obj2 = new Inventory("Orange",20);
		Inventory obj3 = new Inventory("Mango",30);
		inventoryList.put("Apple",obj1);
		inventoryList.put("Orange",obj2);
		inventoryList.put("Mango",obj3);
	}

	/**
	 * This function is used to get the list of items in inventory
	 * @return
	 */
	public ArrayList<Inventory> getAllItems() {
		return getInventoryList();
	}

	/**
	 * This function is used to get item from inventory
	 * @param name to be fetched from list
	 * @return required inventory object
	 */
	public Inventory getItem(String name) {
		if(!inventoryList.keySet().contains(name))
			return null;
		return inventoryList.get(name);
	}

	/**
	 * This function adds item to the list
	 * @param invObject to be added in the list
	 * @return updated list
	 */
	public ArrayList<Inventory> addItem(Inventory invObject) {
		inventoryList.put(invObject.getItemName(),invObject);
		return new ArrayList<Inventory>(inventoryList.values());
	}

	/**
	 * This function is used to update the item present in list
	 * @param name item to be replaced
	 * @param invObject item to be updated
	 * @return updated list
	 */
	public ArrayList<Inventory> updateItem(String name,Inventory invObject) {
		if(inventoryList.keySet().contains(name))
			inventoryList.remove(name);
		inventoryList.put(invObject.getItemName(),invObject);
		return new ArrayList<Inventory>(inventoryList.values());
	}

	/**
	 * This function is used to update the whole list
	 * @param newItemList list to be updated
	 * @return updated list
	 */
	public ArrayList<Inventory> updateAllItems(ArrayList<Inventory> newItemList) {
		deleteAllItems();
		for(int i= 0;i<newItemList.size();i++) {
			inventoryList.put(newItemList.get(i).getItemName(),newItemList.get(i));
		}
		return new ArrayList<Inventory>(inventoryList.values());
	}

	/**
	 * This function is used to delete an item from inventory
	 * @param name item to be deleted
	 * @return the updated list
	 */
	public ArrayList<Inventory> deleteItem(String name) {
		inventoryList.remove(name);
		return new ArrayList<Inventory>(inventoryList.values());
	}

	/**
	 * This function is used to delete all items from inentory
	 * @return the updated list
	 */
	public ArrayList<Inventory> deleteAllItems() {
		inventoryList.clear();
		return new ArrayList<Inventory>(inventoryList.values());
	}
}
