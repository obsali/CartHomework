package com.example;

public class Item{
	private String itemName, itemDesc;
	private Double itemPrice;
	private int quantity, availableQuantity;
    
    
    public Item() {
        // Your code here
    	this.quantity = 1;
    }
    
    public Item(String itemName, String itemDesc, Double itemPrice, Integer availableQuantity) {
        // Your code here
    	this.itemName = itemName;
    	this.itemDesc = itemDesc;
    	this.itemPrice = itemPrice;
    	//this.quantity = quantity;
    	this.availableQuantity = availableQuantity;
    }

	public String getItemName() {
		return itemName;
	}

	public void setItemName(String itemName) {
		this.itemName = itemName;
	}

	public String getItemDesc() {
		return itemDesc;
	}

	public void setItemDesc(String itemDesc) {
		this.itemDesc = itemDesc;
	}

	public Double getItemPrice() {
		return itemPrice;
	}

	public void setItemPrice(Double itemPrice) {
		this.itemPrice = itemPrice;
	}

	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

	public int getAvailableQuantity() {
		return availableQuantity;
	}

	public void setAvailableQuantity(int availableQuantity) {
		this.availableQuantity = availableQuantity;
	}
	
	public Double getSubTotal() {
		return this.availableQuantity*this.itemPrice;
		
	}
    
    
    
}
