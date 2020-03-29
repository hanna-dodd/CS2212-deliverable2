package ca.uwo.pricingStrategies.individual;
/*
 * This class calculates the cost according to the secondary individual pricing strategy
 */
public class IndividualPricingStrategy2 implements IndividualPricingStrategy {
/*
 * Calculate will return the total cost of the order according to it's pricing strategy
 * @param Quantity quantity of items to be purchased
 * @param Price the price per item to be ordered
 * @return The total cost according to the product of the quantity and price per item. 
 * If 100 or more of the item is purchased a 10% discount is given
 */
	public double calculate(int quantity, double price) {
		double total = quantity * price;
		if (quantity >= 100) {
			return total * 0.90;
		}
		else {
			return total;
		}
	}
}
