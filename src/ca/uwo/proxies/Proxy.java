package ca.uwo.proxies;

import java.util.Map;

import ca.uwo.client.Buyer;
import ca.uwo.client.Supplier;
import ca.uwo.frontend.interfaces.FacadeCommands;

/**
 * @author kkontog, ktsiouni, mgrigori
 * The base class for the implementation of Proxy design pattern, which provides interfaces 
 * to the {@link ca.uwo.client.Client} for accessing the system.
 */
public abstract class Proxy implements FacadeCommands{
	public abstract void placeOrder(Map<String, Integer> orderDetails, Buyer buyer);
	
	public abstract void restock(Map<String, Integer> restockDetails, Supplier supplier);
	
}