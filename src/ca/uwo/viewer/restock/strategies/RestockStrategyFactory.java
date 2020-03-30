package ca.uwo.viewer.restock.strategies;

public class RestockStrategyFactory {

	/**
	 * Create
	 * Constructs and returns the correct restock strategy, depending on the value read in.
	 * @param type - restock strategy to change to
	 * @return - the correct restock strategy
	 */
	public static RestockStrategy create(String type) {
		
		if (type.contentEquals("strategy1")) {
			
			return new RestockStrategy1();
			
		} else {
			
			return new RestockStrategy2();
			
		}
		
	}
}
