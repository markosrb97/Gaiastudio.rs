package rs.gaiastudio.model;

import java.util.ArrayList;

public class Cart extends ArrayList<CartItem>{

	private static final long serialVersionUID = 1L;
	
	private int sumPrice;
	private int numberOfItems;
	
	public Cart() {
		this.numberOfItems = 0;
	}
	
	public int getSumPrice() {
		sumPrice = 0;
		for(int i = 0; i < this.size(); i++) {
			sumPrice += (this.get(i).getCandle().getPrice() * this.get(i).getQuantity());
		}
		return sumPrice;
	}
	
	public int getNumberOfItems() {
		return numberOfItems;
	}
	
	public void addItem(CartItem item) {
		if(this.containsCandle(item.getCandle().getType())) {
			int i = this.get(this.indexOfCandle(item.getCandle().getType())).getQuantity();
			i++;
			this.get(this.indexOfCandle(item.getCandle().getType())).setQuantity(i);
		}else {
			this.add(item);
		}
		numberOfItems++;
	}
	
	
	public void removeItem(CartItem item) {
            String candleType = item.getCandle().getType();
		if(this.containsCandle(candleType)) {
			long id = this.indexOfCandle(candleType);
			
		}
		numberOfItems--;
	}
        
	
	// returns true if candle of passed type is found, otherwise returns false
	public boolean containsCandle(String candleType) {
		for(int i = 0; i < this.size(); i++) {
			if(this.get(i).getCandle().getType() == candleType) {
				return true;
			}
		}
		return false;
	}
	
	// returns index of first occurrence of passed candle type
	// -1 if not found
	public int indexOfCandle(String candleType) {
		for(int i = 0; i < this.size(); i++) {
			if(this.get(i).getCandle().getType() == candleType) {
				return i;
			}
		}
		return -1;
	}
	
        public void removeCandleId(long id){
            this.get((int)(id-1)).setQuantity(this.get((int)(id-1)).getQuantity()-1);
            this.numberOfItems -= 1;
            this.removeIf(e -> e.getCandle().getId() == id);
        }

}
