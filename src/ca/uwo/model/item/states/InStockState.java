package ca.uwo.model.item.states;

import ca.uwo.model.Item;
import ca.uwo.utils.ItemResult;
import ca.uwo.utils.ResponseCode;

//  itemstate for when available quantity is greater then or equal to 10
public class InStockState implements ItemState {
	
	// reduces the stock of an item when a order is placed
	public ItemResult deplete(Item item, int quantity) {
		
		ItemResult itemResult;
		int availableQuantity = item.getAvailableQuantity();
		
		if (availableQuantity < quantity) {
			itemResult = new ItemResult("OUT OF STOCK", ResponseCode.Not_Completed);
			item.notifyViewers();
		} 
		
		else {
			availableQuantity -= quantity;
			itemResult = new ItemResult("AVAILABLE", ResponseCode.Completed);
		}

		item.setAvailableQuantity(availableQuantity);
		
		// if no stock left then set out of stock
		if (availableQuantity == 0) {
			item.setState(new OutOfStockState());
			
		}
		
		// if less then 10 left set low stock
		else if (availableQuantity < 10) {
			item.setState(new LowStockState());
			
		}
		
		
		return itemResult;
		
	}
	
	// adds to stock when you get a item restock
	public ItemResult replenish(Item item, int quantity) {
		item.setAvailableQuantity(item.getAvailableQuantity() + quantity);
		
		ItemResult itemResult = new ItemResult("RESTOCKED", ResponseCode.Completed);
		
		return itemResult;
		
	}
}
