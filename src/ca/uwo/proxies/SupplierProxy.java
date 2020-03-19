package ca.uwo.proxies;

import java.util.Map;

import ca.uwo.client.Buyer;
import ca.uwo.client.Supplier;
import ca.uwo.frontend.Facade;

public class SupplierProxy extends Proxy {
	private static SupplierProxy instance = null;
	
	private SupplierProxy() {
		
	}
	
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
		Facade facade = new Facade();
		facade.restock(restockDetails, supplier);
		
	}
}
