package ca.uwo.proxies;

import java.util.Map;

import ca.uwo.client.Buyer;
import ca.uwo.frontend.Facade;

public class HighQuantityProxy {
	private static HighQuantityProxy instance = null;
	
	private HighQuantityProxy() {
		
	}
	
	public static HighQuantityProxy getInstance() {
		if (instance == null) {
			instance = new HighQuantityProxy();
			
		}
		
		return instance;
		
	}
	
	public void placeOrder(Map<String, Integer> orderDetails, Buyer buyer) {
		Facade facade = new Facade();
		facade.placeOrder(orderDetails, buyer);
		
	}
}