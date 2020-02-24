package com.inventory.Assignment_5_a;

import java.util.ArrayList;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;


/**
 * This class performs operation with Resources.
 * @author Martand
 *
 */
@Path("/inventory")
public class InventoryResources {

	InventoryService invServiceObj = new InventoryService();

	/**
	 * This function all items present in Inventory list
	 * @return Inventory List
	 */
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public ArrayList<Inventory> getAllItemsList() {
		return invServiceObj.getAllItems();
	}

	/**
	 * This function returns required item from the Inventory List
	 * @param name to be returned from Inventory List
	 * @return inventory object
	 */
	@GET
	@Path("/{itemName}")
	@Produces(MediaType.APPLICATION_JSON)
	public Inventory getItem(@PathParam("itemName") String name) {
		return invServiceObj.getItem(name);
	}

	/**
	 * This function adds item to inventory list
	 * @param invObject to be added in inventory
	 * @return ArrayList<Invntory> items in inventory 
	 */
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public ArrayList<Inventory> addItemToInventory( Inventory invObject) {
		return invServiceObj.addItem(invObject);
	}

	/**
	 * This function updates item in inventory list
	 * @param name Item to be replaced
	 * @param invObject to be updated
	 * @return updated inventory list
	 */
	@PUT
	@Path("/{itemName}")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public ArrayList<Inventory> updateItemInInventory(@PathParam("itemName") String name ,Inventory invObject) {
		return invServiceObj.updateItem(name,invObject);
	}

	/**
	 * This function updates all item in inventory list
	 * @param newInventoryList to be updated
	 * @return updated inventory list
	 */
	@PUT
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public ArrayList<Inventory> updateAllItemInInventory(ArrayList<Inventory> newInventoryList) {
		return invServiceObj.updateAllItems(newInventoryList);
	}

	/**
	 * This function deletes item from inventory list
	 * @param name item to be deleted
	 * @return updated inventory list
	 */
	@DELETE
	@Path("/{itemName}")
	public ArrayList<Inventory> deleteItem(@PathParam("itemName") String name) {
		return invServiceObj.deleteItem(name);
	}

	/**
	 * This function deletes the inventory list
	 * @return updated list
	 */
	@DELETE
	@Produces(MediaType.APPLICATION_JSON)
	public ArrayList<Inventory> deleteAllItem() {
		return invServiceObj.deleteAllItems();
	}
}
