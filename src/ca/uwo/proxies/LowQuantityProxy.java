package ca.uwo.proxies;

import java.util.Map;

import ca.uwo.client.Buyer;
import ca.uwo.frontend.Facade;

public class LowQuantityProxy {
	private static LowQuantityProxy instance = null;
	
	private LowQuantityProxy() {
		
	}
	
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
			Facade facade = new Facade();
			facade.placeOrder(orderDetails, buyer);
			
		}
	}
}