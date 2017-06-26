package StockMarket;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

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

	public StockInfo[] getStockInfo() {
		StockInfo[] stockInfos = new StockInfo[myStock.size()];
		
		Set<String> keys = myStock.keySet();
		
		Iterator<String> it = keys.iterator();
		
		for(int i = 0; i < myStock.size(); i++){
			String key = it.next();
			stockInfos[i] = new StockInfoImpl(key, myStock.get(key));
		}
		
		return stockInfos;
	}

}
