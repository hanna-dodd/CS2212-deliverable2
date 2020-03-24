package ca.uwo.model.item.states;

//The factory for the ItemState objects, creates ItemState objects.

public class ItemStateFactory {
	
   /** 
	* The create method returns the appropriate item state based on the quantity left of the item.
	*@param quantity amount left of the item
	*@return: Item State of the item based on quantity
	*/
	public static ItemState create(int quantity) {
		
		if (quantity == 0) {
			return new OutOfStockState();
		}
		else if (quantity <= 10) {
			return new LowStockState();
		}
		else {
			return new InStockState();
		}		
	}
}
