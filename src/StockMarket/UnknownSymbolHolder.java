package StockMarket;

/**
* StockMarket/UnknownSymbolHolder.java .
* Generated by the IDL-to-Java compiler (portable), version "3.2"
* from StockMarket.idl
* Segunda-feira, 26 de Junho de 2017 16h14min09s BRT
*/

public final class UnknownSymbolHolder implements org.omg.CORBA.portable.Streamable
{
  public StockMarket.UnknownSymbol value = null;

  public UnknownSymbolHolder ()
  {
  }

  public UnknownSymbolHolder (StockMarket.UnknownSymbol initialValue)
  {
    value = initialValue;
  }

  public void _read (org.omg.CORBA.portable.InputStream i)
  {
    value = StockMarket.UnknownSymbolHelper.read (i);
  }

  public void _write (org.omg.CORBA.portable.OutputStream o)
  {
    StockMarket.UnknownSymbolHelper.write (o, value);
  }

  public org.omg.CORBA.TypeCode _type ()
  {
    return StockMarket.UnknownSymbolHelper.type ();
  }

}
