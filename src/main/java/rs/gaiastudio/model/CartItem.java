package rs.gaiastudio.model;

public class CartItem {
	
	private Candle candle;
	private int quantity;
	
	public CartItem(Candle candle) {
		this.quantity = 1;
		this.candle = candle;
	}
	
	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	
	public Candle getCandle() {
		return candle;
	}

	public void setCandle(Candle candle) {
		this.candle = candle;
	}
	public String toString(){
            return candle.toString() + "\n" + "broj komada: " + quantity + "\n";
        }
}
