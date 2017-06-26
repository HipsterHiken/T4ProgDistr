package StockMarket;

import java.util.HashMap;
import java.util.Map;

public class StockServerImpl extends StockServerPOA{

	private Map<String, Float> myStock;
	
	public StockServerImpl(){
		myStock = new HashMap<String,Float>();
		
		myStock.put("BRL", 3120.0f);
		myStock.put("USD", 1230.0f);
		myStock.put("INR", 1033.0f);
		myStock.put("CNY", 4870.0f);
		myStock.put("JPY", 5031.0f);
	}
	
	public synchronized float getStockValue(String symbol) throws UnknownSymbol {
		if(myStock.containsKey(symbol)){
			return myStock.get(symbol);
		}
		
		return 0f;
	}

	public synchronized String[] getStockSymbols() {
		return myStock.keySet().toArray(new String[0]);
	}

}
