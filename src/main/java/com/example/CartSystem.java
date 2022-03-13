package com.example;

public class CartSystem extends TheSystem {
	public double subTotal;

	CartSystem() {
		super();
	}

	@Override
	public void display() {
		// Your code here
		if (getItemCollection() == null) {
			System.out.println("No item in list");
		}

		System.out.printf("%-20s %-20s %-10s %-10s\n", "Name", "Description", "Price", "Quantity", "Sub Total");

		for (String i : this.getItemCollection().keySet()) {
			int quntity = this.getItemCollection().get(i).getQuantity() + 1;

			// increasing shopping cart

			System.out.println("Cart");
			System.out.printf("\nName: %-20s", i);
			System.out.printf("\nDescription: %-20s", this.getItemCollection().get(i).getItemDesc());
			System.out.printf("\nPrice: %-10.2f", this.getItemCollection().get(i).getItemPrice() * quntity);
			System.out.printf("\nQuantity: %-10d", quntity);

			subTotal += this.getItemCollection().get(i).getSubTotal();
		}

		double total = ((subTotal * .07) + subTotal);

		System.out.printf("\nPre-tax total: %20.2f", subTotal);
		System.out.printf("\nTax: %20.2f", (subTotal * 0.7));
		System.out.printf("\nTotal: %20.2f", total);

	}
}
