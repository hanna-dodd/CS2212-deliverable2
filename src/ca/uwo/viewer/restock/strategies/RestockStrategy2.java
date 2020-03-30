package ca.uwo.viewer.restock.strategies;

public class RestockStrategy2 implements RestockStrategy {

	@Override
	/**
	 * Calculate Quantity
	 * If the item is an apple, restock 100 items. Otherwise, restock 25 items.
	 * @param - itemName
	 * @param - quantity
	 * @param - price
	 * @return int - quantity to restock
	 */
	public int calculateQuantity(String itemName, int quantity, double price) {

		if (itemName.equals("apple")) {
			
			return 100;
			
		} else {
			
			return 25;
			
		}
		
	}

}
