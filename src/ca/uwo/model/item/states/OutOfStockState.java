package ca.uwo.model.item.states;

import ca.uwo.model.Item;
import ca.uwo.utils.ItemResult;
import ca.uwo.utils.ResponseCode;


// item state for when quantity is 0
public class OutOfStockState implements ItemState {
	
	// cannot deplete because quantity is 0 so out of stock notification
	public ItemResult deplete(Item item, int quantity) {
		
		ItemResult itemResult = new ItemResult("OUT OF STOCK", ResponseCode.Not_Completed);
		
		item.notifyViewers();
		
		return itemResult;
		
	}
	
	// replenish adds to the stock and changes the state since the quantity will no longer be zero
	public ItemResult replenish(Item item, int quantity) {
		item.setAvailableQuantity(item.getAvailableQuantity() + quantity);
		
		if (quantity < 10) {
			item.setState(new LowStockState());
			
		}
		
		else {
			item.setState(new InStockState());
		
		}
		
		ItemResult itemResult = new ItemResult("RESTOCKED", ResponseCode.Completed);
		
		
		return itemResult;
		
	}

}
