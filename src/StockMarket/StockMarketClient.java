package StockMarket;

import java.io.*;
import java.util.Properties;

import org.omg.CORBA_2_3.ORB;

public class StockMarketClient {
	public static void main(String args[]){
			Properties orbProps = new Properties();
			orbProps.setProperty("org.omg.CORBA.ORBClass", "org.jacorb.orb.ORB");
			orbProps.setProperty("org.omg.CORBA.ORBSingletonClass", "org.jacorb.orb.ORBSingleton");
			
			org.omg.CORBA.ORB orb = ORB.init(args, orbProps);
			
			BufferedReader reader;
			
			try {
				reader = new BufferedReader(new InputStreamReader(new FileInputStream(args[0])));
				String ior = reader.readLine();
				org.omg.CORBA.Object obj = orb.string_to_object(ior);
				StockServer server = StockServerHelper.narrow(obj);
			} catch (FileNotFoundException e) {
				System.out.println("unexpected error");
			} catch (IOException e) {
				System.out.println("unexpected error");
			}
	}
}
