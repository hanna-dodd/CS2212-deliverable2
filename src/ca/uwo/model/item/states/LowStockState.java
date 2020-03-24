package ca.uwo.model.item.states;

import ca.uwo.model.Item;
import ca.uwo.utils.ItemResult;
import ca.uwo.utils.ResponseCode;

// itemstate for when there are less then 10 available quantity
public class LowStockState implements ItemState {
	
	// deplete reduces the stock and changes the state to out of stock if quantity becomes 0
	public ItemResult deplete(Item item, int quantity) {
		
		ItemResult itemResult;
		int availableQuantity = item.getAvailableQuantity();
		
		// if the order quantity is larger then the quantity available, the item is out of stock
		if (availableQuantity < quantity) {
			itemResult = new ItemResult("OUT OF STOCK", ResponseCode.Not_Completed);
			item.notifyViewers();
		} 
		
		// else reduce the stock
		else {
			availableQuantity -= quantity;
			itemResult = new ItemResult("AVAILABLE", ResponseCode.Completed);
		}

		item.setAvailableQuantity(availableQuantity);
		
		if (availableQuantity == 0) {
			item.setState(new OutOfStockState());
			
		}
		
		
		return itemResult;
		
	}
	
	// replenish adds to the stock and changes the state if the quantity goes above 10
	public ItemResult replenish(Item item, int quantity) {
		item.setAvailableQuantity(item.getAvailableQuantity() + quantity);
		
		if (item.getAvailableQuantity() <= 10) {
			item.setState(new InStockState());
			
		}
		
		ItemResult itemResult = new ItemResult("RESTOCKED", ResponseCode.Completed);
		
		return itemResult;
		
	}
}
