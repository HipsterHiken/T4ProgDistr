package StockMarket;


/**
* StockMarket/StockServerOperations.java .
* Generated by the IDL-to-Java compiler (portable), version "3.2"
* from StockMarket.idl
* Segunda-feira, 26 de Junho de 2017 16h14min10s BRT
*/


// as informa��es sobre as a��es do mercado.
public interface StockServerOperations 
{

  // UnknownSymbol deve ser lan�ada.
  float getStockValue (String symbol) throws StockMarket.UnknownSymbol;

  // a��es.
  String[] getStockSymbols ();
  StockMarket.StockInfo[] getStockInfo ();
} // interface StockServerOperations
