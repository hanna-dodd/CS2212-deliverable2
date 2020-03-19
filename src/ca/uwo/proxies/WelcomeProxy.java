package ca.uwo.proxies;

import java.util.Map;
import java.util.Scanner;

import ca.uwo.client.Buyer;
import ca.uwo.client.Supplier;
import ca.uwo.frontend.Facade;

/**
 * @author kkontog, ktsiouni, mgrigori
 * This is one concrete implementation of {@link ca.uwo.proxies.Proxy} base class, it is the first proxy
 * the {@link ca.uwo.client.Client} will encounter. If the request of client is not issued by this class, 
 * it is forwarded to the {@link ca.uwo.proxies.SupplierProxy}, then {@link ca.uwo.proxies.LowQuantityProxy}, 
 * lastly {@link ca.uwo.proxies.HighQuantityProxy}. The link between those proxies implements Chain of Responsibility 
 * design pattern.
 */
public class WelcomeProxy extends Proxy {
	
	private static WelcomeProxy instance = null;
	
	/**
	 * constructor for WelcomeProxy class.
	 */
	public WelcomeProxy() {
		
		
	}

	public static WelcomeProxy getInstance() {
		
		if (instance == null) {
			instance = new WelcomeProxy();
			
		}
		
		return instance;
		
	}
	
	/* (non-Javadoc)
	 * @see ca.uwo.frontend.interfaces.FacadeCommands#placeOrder(java.util.Map, ca.uwo.client.Buyer)
	 */
	@Override
	public void placeOrder(Map<String, Integer> orderDetails, Buyer buyer) {
		
		SupplierProxy Supplier = SupplierProxy.getInstance();
		
		if (authenticate(buyer)) {
			
			Supplier.placeOrder(orderDetails, buyer);

		}
		
	}

	/* (non-Javadoc)
	 * @see ca.uwo.frontend.interfaces.FacadeCommands#restock(java.util.Map, ca.uwo.client.Supplier)
	 */
	@Override
	public void restock(Map<String, Integer> restockDetails, Supplier supplier) {
		
		SupplierProxy Supplier = SupplierProxy.getInstance();
		Supplier.restock(restockDetails, supplier);
		
	}
	
	public boolean authenticate(Buyer buyer) {
	
		Scanner user_input = new Scanner(System.in);
		
		System.out.println("Enter your user name:");
		String username = user_input.nextLine();
		
		System.out.println("Enter your password:");
		String password = user_input.nextLine();
		
		if((username.equals(buyer.getUserName())) && (password.equals(buyer.getPassword()))) {
			
			System.out.println("Authenticated.");
			return true;
			
		}
		
		System.out.println("Invalid username or password.");
		return false;
		
	}

}
