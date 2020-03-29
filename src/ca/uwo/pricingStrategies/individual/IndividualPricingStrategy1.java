package ca.uwo.pricingStrategies.individual;
/*
 * This class calculates the cost according to the primary individual pricing strategy
 */
public class IndividualPricingStrategy1 implements IndividualPricingStrategy {
/*
 * Calculate will return the total cost according to it's pricing strategy
 * @param Quantity quantity of items to be purchased
 * @param Price the price per item to be ordered
 * @return The total cost according to the product of the quantity and price per item
 */
	public double calculate(int quantity, double price) {
		
		return (quantity * price);
		
	}
}
