package ca.uwo.model.item.states;

import ca.uwo.model.Item;
import ca.uwo.utils.ItemResult;
import ca.uwo.utils.ResponseCode;

public class OutOfStockState implements ItemState {
	public ItemResult deplete(Item item, int quantity) {
		ItemResult itemResult = new ItemResult("OUT OF STOCK", ResponseCode.Not_Completed);
		
		return itemResult;
		
	}
	
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
