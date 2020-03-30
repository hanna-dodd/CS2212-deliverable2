package ca.uwo.viewer.restock.strategies;

public class RestockStrategy1 implements RestockStrategy {

	@Override
	/**
	 * Calculate Quantity
	 * Returns 50 as the quantity to restock.
	 * @param - itemName
	 * @param - quantity
	 * @param - price
	 * @return int - quantity to restock
	 */
	public int calculateQuantity(String itemName, int quantity, double price) {

		return 50;
		
	}

}
