package shoppingCart;

import java.util.*; 

public class Cart {

	Map< String,Item> selectedItems =  new HashMap< String,Item>(); 
	static Map< String,Integer> listOfItems =  new LinkedHashMap< String,Integer>(); 
	List<String> listKeys = new ArrayList<String>();

// Initializes the Product List
	Cart(){
		listOfItems.put("egg",20); 
		listOfItems.put("milk",30); 
		listOfItems.put("bread",40); 
		listOfItems.put("butter",50);
		listOfItems.put("choco",60);

		listKeys.add(0,"egg");
		listKeys.add(1,"milk");
		listKeys.add(2,"bread");
		listKeys.add(3,"butter");
		listKeys.add(4,"choco");
	}

//New Item Object is added to Selected Items Map
	void add(int id,int quantity){		
		Item obj = new Item();
		obj.id = id;
		obj.quantity = quantity;
		obj.price = listOfItems.get(listKeys.get(id))*quantity;
		obj.name = listKeys.get(id);

		selectedItems.put(obj.name,obj);
	}

//Removes Item Object From Selected Items Map
	void remove(int id){
		selectedItems.remove(listKeys.get(id));
	}

//Displays Item From Selected Items Map
	void showCart(){
		for (Map.Entry<String,Item> entry : selectedItems.entrySet())  
			System.out.println("Item = " + entry.getKey() + "	quantity = " + entry.getValue().quantity + "	Price = " + entry.getValue().price); 
	}

//Generates Bill of Items present in Selected Items Map 	
	void getBill(){
		int totalAmount = 0;
		for (Map.Entry<String,Item> entry : selectedItems.entrySet()){
			System.out.println("Item = " + entry.getKey() + "	quantity = " + entry.getValue().quantity + "	price = " + entry.getValue().price); 
			totalAmount += entry.getValue().price;
		}
		System.out.println("\nTotal Amount to pay : " + totalAmount + "\n");
	}

	public static void main(String[] args){

		Cart cartItem = new Cart();
		Scanner readInp = new Scanner(System.in);
		while(true) {
			int index = 0;
			System.out.println("\nItems you can select : \n");
			for (Map.Entry<String,Integer> entry : listOfItems.entrySet())  {
				System.out.println(index + ".Item = " + entry.getKey() + "	Price = " + entry.getValue()); 
				index++;
			}
			System.out.println("\nSelect the below options :");
			System.out.println("1.Add Item \n 2.Remove Item \n 3.Show Cart \n 4.Generate Bill \n 5.Exit");

			try {		//To handle exception on Switch case input
				int userInput = readInp.nextInt();

				switch(userInput){
				case 1:
					System.out.println("enter Item id you want to add:");
					try {
						int id = readInp.nextInt();
						System.out.println("enter quantity of the item you want to add:");
						int quantity = readInp.nextInt();
						if(quantity != 0 ){
							cartItem.add(id, quantity);
						}
						else {
							System.out.println("\npls provide quantity\n");
						}
					} catch (Exception e) {
						System.out.println("\nError : Enter valid input\n");
						readInp.nextLine();
					}
					break;

				case 2:
					System.out.println("enter Item id you want to remove:");
					int itemId = readInp.nextInt();
					if(cartItem.selectedItems.isEmpty()){
						System.out.println("\nCart is empty: nothing to remove\n");
					}
					else if(!cartItem.selectedItems.containsKey(cartItem.listKeys.get(itemId))){
						System.out.println("\nItem not present in cart\n");
					}
					else if(itemId>=0 && itemId<=cartItem.listKeys.size()){
						cartItem.remove(itemId);
						System.out.println(cartItem.listKeys.get(itemId) + " successfully removed\n");
					}
					else{
						System.out.println("\nError: Provide valid Item ID\n");
					}
					break;

				case 3:
					if(cartItem.selectedItems.isEmpty()){
						System.out.println("\nCart is empty: no items to show\n");
					}else{
						System.out.println("\nItems present in Cart : ");
						cartItem.showCart();
					}
					break;

				case 4:
					if(cartItem.selectedItems.isEmpty()){
						System.out.println("\nCart is empty: nothing to bill\n");
					}else{
						System.out.println("\nBill of items present in Cart : ");
						cartItem.getBill();
					}
					break;

				case 5:
					System.exit(0);

				default:
					System.out.println("\ninvalid input, pls try again: \n");
					break;
				}
			} catch (Exception e) {
				System.out.println("\nError : enter the valid input\n");
				readInp.nextLine();
			}
		}

	}
}
