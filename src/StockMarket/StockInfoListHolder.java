package StockMarket;


/**
* StockMarket/StockInfoListHolder.java .
* Generated by the IDL-to-Java compiler (portable), version "3.2"
* from StockMarket.idl
* Segunda-feira, 26 de Junho de 2017 16h14min10s BRT
*/

public final class StockInfoListHolder implements org.omg.CORBA.portable.Streamable
{
  public StockMarket.StockInfo value[] = null;

  public StockInfoListHolder ()
  {
  }

  public StockInfoListHolder (StockMarket.StockInfo[] initialValue)
  {
    value = initialValue;
  }

  public void _read (org.omg.CORBA.portable.InputStream i)
  {
    value = StockMarket.StockInfoListHelper.read (i);
  }

  public void _write (org.omg.CORBA.portable.OutputStream o)
  {
    StockMarket.StockInfoListHelper.write (o, value);
  }

  public org.omg.CORBA.TypeCode _type ()
  {
    return StockMarket.StockInfoListHelper.type ();
  }

}
