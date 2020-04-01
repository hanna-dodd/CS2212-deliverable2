package ca.uwo.proxies;

import java.util.Map;

import ca.uwo.client.Buyer;
import ca.uwo.client.Supplier;
import ca.uwo.frontend.Facade;

public class SupplierProxy extends Proxy {
	private static SupplierProxy instance = null;
	
	// private constructor for supplierproxy for singleton
	private SupplierProxy() {
		
	}
	
	// returns the instance so there can only be one
	public static SupplierProxy getInstance() {
		if (instance == null) {
			instance = new SupplierProxy();
			
		}
		
		return instance;
		
	}
	
	
	
	public void placeOrder(Map<String, Integer> orderDetails, Buyer buyer) {
		LowQuantityProxy LowQuantity = LowQuantityProxy.getInstance();
		LowQuantity.placeOrder(orderDetails, buyer);
		
	}
	
	public void restock(Map<String, Integer> restockDetails, Supplier supplier) {
		Facade facade = Facade.getInstance();
		facade.restock(restockDetails, supplier);
		
	}
}
