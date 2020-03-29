package ca.uwo.pricingStrategies.individual;

public class IndividualPricingStrategy2 implements IndividualPricingStrategy {

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
