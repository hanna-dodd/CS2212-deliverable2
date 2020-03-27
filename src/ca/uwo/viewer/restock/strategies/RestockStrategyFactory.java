package ca.uwo.viewer.restock.strategies;

public class RestockStrategyFactory {

	public static RestockStrategy create(String type) {
		
		if (type.contentEquals("strategy1")) {
			
			return new RestockStrategy1();
			
		} else {
			
			return new RestockStrategy2();
			
		}
		
	}
}
