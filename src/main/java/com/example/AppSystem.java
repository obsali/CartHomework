package com.example;

import java.util.Iterator;
import java.util.Map;

public class AppSystem extends TheSystem {
	AppSystem() {
		super();
	}

	@Override
	public void display() {
		// Your code here
		System.out.println("\nAppSystem Inventory:");

		System.out.printf("%-20s %-20s %-10s %-10s\n", "Name", "Description", "Price",  "AvailableQuantity");
		Iterator displayIterator = super.getItemCollection().entrySet().iterator();

		while (displayIterator.hasNext()) {

			Map.Entry le = (Map.Entry) displayIterator.next();

			Item displayMethod = super.getItemCollection().get(le.getKey());
			System.out.printf("%-20s %-20s %-10s %-10s\n", displayMethod.getItemName(), displayMethod.getItemDesc(),
					String.format("%.2f", displayMethod.getItemPrice()), String.format("%d", displayMethod.getAvailableQuantity()));

		}

	}

	@Override      // this overwrites the parents class add method 
    public Boolean add(Item item) {
        // Your code here
    	
    	if ( item == null) {
    		
    		return false;
    
    	} else if( super.getItemCollection().containsKey(item.getItemName())) {
    		
    		Item it = super.getItemCollection().get(item.getItemName());
    		
    		it.setAvailableQuantity(it.getAvailableQuantity()+ 1 );
    		
    		System.out.printf("%s is already in the App System", item.getItemName());
    		return false;
    		
    	} else if (!super.getItemCollection().containsKey(item.getItemName())) {
    		super.getItemCollection().put(item.getItemName(), item);
    		return true;
    	} else {
    		return null;
    	}
    	
	}

	public Item reduceAvailableQuantity(String item_name) {
		// Your code here
		if (super.getItemCollection().containsKey(item_name)) {
			super.getItemCollection().get(item_name).setAvailableQuantity(super.getItemCollection().get(item_name).getAvailableQuantity()-1);
			return super.getItemCollection().get(item_name);
		
		}
		return null;
		}
	}
