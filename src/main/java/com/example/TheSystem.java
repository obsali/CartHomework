package com.example;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Scanner;

public abstract class TheSystem {

	private HashMap<String, Item> itemCollection;

	TheSystem() {
		// Your code here
		super();

		this.itemCollection = new HashMap<String, Item>();

		if (getClass().getSimpleName().equals("AppSystem")) {

			try {
				String file_path = "resources/sample.txt";
				String line = "";
				BufferedReader br = new BufferedReader(new FileReader(file_path));

				while ((line = br.readLine()) != null) {

					String[] values = line.split("  ");
					Item temp = new Item(values[0], values[1], Double.parseDouble(values[2]),
							Integer.parseInt(values[3]));
					String data = values[0];
					this.itemCollection.put(data, temp);
				}

			} catch (FileNotFoundException e) {
				System.out.println("An error occured");
				e.printStackTrace();

			} catch (IOException e) {
				e.printStackTrace();
			}
		}

	}

	public HashMap<String, Item> getItemCollection() {
		// Your code here
		return itemCollection;

	}

	public Boolean checkAvailability(Item item) {
		// Your code here
		if (item.getQuantity() >= item.getAvailableQuantity()) {
			System.out.println("System is unable to add" + item.getItemName() + "to the card." + "System only has"
					+ item.getAvailableQuantity() + item.getItemName());
			return false;

		} else {
			return true;
		}

	}

	public Boolean add(Item item) {
		// Your code here
		if (item == null) {
			return false;
		} else if (this.itemCollection.containsKey(item.getItemName())) {
			Item newItem = itemCollection.get(item.getItemName());
			newItem.setQuantity(newItem.getAvailableQuantity() + 1); // increasing shopping cart
			return true;
		} else {
			this.itemCollection.put(item.getItemName(), item);
			return true;
		}

	}

	public Item remove(String itemName) {
		// Your code here

		if (this.itemCollection.containsKey(itemName)) {
			return this.itemCollection.remove(itemName);
		}

		return null;
	}

	public abstract void display();

	public void setItemCollection(HashMap<String, Item> itemCollection) {
		this.itemCollection = itemCollection;
	}

}
