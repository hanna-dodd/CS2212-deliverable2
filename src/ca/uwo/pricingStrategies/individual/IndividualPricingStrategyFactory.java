package ca.uwo.pricingStrategies.individual;
/*
 * This class creates different strategies using the Factory Design method
 */
public class IndividualPricingStrategyFactory {
/*
 * The method create will return a pricing strategy that corresponds to the type passed through the parameter
 * @param type the type of strategy requested
 * @return the appropriate individual pricing strategy
 */
	public static IndividualPricingStrategy create(String type) {
		switch(type) {
		case "test":
			return new IndividualPricingStrategy2();
		default:
			return new IndividualPricingStrategy1();
		}
	}
}
