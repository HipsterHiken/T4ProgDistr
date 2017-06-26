package StockMarket;

public class StockInfoImpl extends StockInfo {
	
	public StockInfoImpl(String name, float value){
		this.name = name;
		this.value = value;
	}

	public String _toString() {
		return this.name + " " + Float.toString(this.value);
	}

}
