package ca.uwo.proxies;

import java.util.Map;

import ca.uwo.client.Buyer;
import ca.uwo.frontend.Facade;

public class HighQuantityProxy {
	private static HighQuantityProxy instance = null;
	
	// constructor for highquantityproxy private for singleton
	private HighQuantityProxy() {
		
	}
	
	// returns the instance so there can only be one
	public static HighQuantityProxy getInstance() {
		if (instance == null) {
			instance = new HighQuantityProxy();
			
		}
		
		return instance;
		
	}
	
	// places order
	public void placeOrder(Map<String, Integer> orderDetails, Buyer buyer) {
		Facade facade = Facade.getInstance();
		facade.placeOrder(orderDetails, buyer);
		
	}
}