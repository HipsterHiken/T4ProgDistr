package StockMarket;


/**
* StockMarket/_StockServerStub.java .
* Generated by the IDL-to-Java compiler (portable), version "3.2"
* from StockMarket.idl
* Segunda-feira, 26 de Junho de 2017 16h14min10s BRT
*/


// as informa��es sobre as a��es do mercado.
public class _StockServerStub extends org.omg.CORBA.portable.ObjectImpl implements StockMarket.StockServer
{


  // UnknownSymbol deve ser lan�ada.
  public float getStockValue (String symbol) throws StockMarket.UnknownSymbol
  {
            org.omg.CORBA.portable.InputStream $in = null;
            try {
                org.omg.CORBA.portable.OutputStream $out = _request ("getStockValue", true);
                StockMarket.StockSymbolHelper.write ($out, symbol);
                $in = _invoke ($out);
                float $result = $in.read_float ();
                return $result;
            } catch (org.omg.CORBA.portable.ApplicationException $ex) {
                $in = $ex.getInputStream ();
                String _id = $ex.getId ();
                if (_id.equals ("IDL:StockMarket/UnknownSymbol:1.0"))
                    throw StockMarket.UnknownSymbolHelper.read ($in);
                else
                    throw new org.omg.CORBA.MARSHAL (_id);
            } catch (org.omg.CORBA.portable.RemarshalException $rm) {
                return getStockValue (symbol        );
            } finally {
                _releaseReply ($in);
            }
  } // getStockValue


  // a��es.
  public String[] getStockSymbols ()
  {
            org.omg.CORBA.portable.InputStream $in = null;
            try {
                org.omg.CORBA.portable.OutputStream $out = _request ("getStockSymbols", true);
                $in = _invoke ($out);
                String $result[] = StockMarket.StockSymbolListHelper.read ($in);
                return $result;
            } catch (org.omg.CORBA.portable.ApplicationException $ex) {
                $in = $ex.getInputStream ();
                String _id = $ex.getId ();
                throw new org.omg.CORBA.MARSHAL (_id);
            } catch (org.omg.CORBA.portable.RemarshalException $rm) {
                return getStockSymbols (        );
            } finally {
                _releaseReply ($in);
            }
  } // getStockSymbols

  public StockMarket.StockInfo[] getStockInfo ()
  {
            org.omg.CORBA.portable.InputStream $in = null;
            try {
                org.omg.CORBA.portable.OutputStream $out = _request ("getStockInfo", true);
                $in = _invoke ($out);
                StockMarket.StockInfo $result[] = StockMarket.StockInfoListHelper.read ($in);
                return $result;
            } catch (org.omg.CORBA.portable.ApplicationException $ex) {
                $in = $ex.getInputStream ();
                String _id = $ex.getId ();
                throw new org.omg.CORBA.MARSHAL (_id);
            } catch (org.omg.CORBA.portable.RemarshalException $rm) {
                return getStockInfo (        );
            } finally {
                _releaseReply ($in);
            }
  } // getStockInfo

  // Type-specific CORBA::Object operations
  private static String[] __ids = {
    "IDL:StockMarket/StockServer:1.0"};

  public String[] _ids ()
  {
    return (String[])__ids.clone ();
  }

  private void readObject (java.io.ObjectInputStream s) throws java.io.IOException
  {
     String str = s.readUTF ();
     String[] args = null;
     java.util.Properties props = null;
     org.omg.CORBA.ORB orb = org.omg.CORBA.ORB.init (args, props);
   try {
     org.omg.CORBA.Object obj = orb.string_to_object (str);
     org.omg.CORBA.portable.Delegate delegate = ((org.omg.CORBA.portable.ObjectImpl) obj)._get_delegate ();
     _set_delegate (delegate);
   } finally {
     orb.destroy() ;
   }
  }

  private void writeObject (java.io.ObjectOutputStream s) throws java.io.IOException
  {
     String[] args = null;
     java.util.Properties props = null;
     org.omg.CORBA.ORB orb = org.omg.CORBA.ORB.init (args, props);
   try {
     String str = orb.object_to_string (this);
     s.writeUTF (str);
   } finally {
     orb.destroy() ;
   }
  }
} // class _StockServerStub
