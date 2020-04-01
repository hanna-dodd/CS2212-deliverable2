package ca.uwo.proxies;

import java.util.Map;

import ca.uwo.client.Buyer;
import ca.uwo.frontend.Facade;

public class LowQuantityProxy {
	private static LowQuantityProxy instance = null;
	
	// constructor for lowquantityproxy private for singleton
	private LowQuantityProxy() {
		
	}
	
	// returns the instance so there can only be one
	public static LowQuantityProxy getInstance() {
		if (instance == null) {
			instance = new LowQuantityProxy();
			
		}
		
		return instance;
		
	}
	
	public void placeOrder(Map<String, Integer> orderDetails, Buyer buyer) {
		if (orderDetails.size() > 10) {
			HighQuantityProxy HighQuantity = HighQuantityProxy.getInstance();
			HighQuantity.placeOrder(orderDetails, buyer);
			
		}
		
		else {
			Facade facade = Facade.getInstance();
			facade.placeOrder(orderDetails, buyer);
			
		}
	}
}