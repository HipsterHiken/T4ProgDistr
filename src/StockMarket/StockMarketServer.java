package StockMarket;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Properties;

import org.jacorb.poa.POA;
import org.omg.CORBA.ORB;
import org.omg.CORBA.ORBPackage.InvalidName;
import org.omg.PortableServer.POAHelper;
import org.omg.PortableServer.POAManagerPackage.AdapterInactive;
import org.omg.PortableServer.POAPackage.ServantNotActive;
import org.omg.PortableServer.POAPackage.WrongPolicy;

public class StockMarketServer {
	
	public void initializeServer(){
		Properties orbProps = new Properties();
		orbProps.setProperty("org.omg.CORBA.ORBClass", "org.jacorb.orb.ORB");
		orbProps.setProperty("org.omg.CORBA.ORBSingletonClass", "org.jacorb.orb.ORBSingleton");
		
		ORB orb = ORB.init(new String[0], orbProps);
		
		StockServerImpl stockServer = new StockServerImpl();
		
		try {
			org.omg.PortableServer.POA poa = POAHelper.narrow(orb.resolve_initial_references("RootPOA"));
			try {
				poa.the_POAManager().activate();
				try {
					org.omg.CORBA.Object o = poa.servant_to_reference(stockServer);
					String ior = orb.object_to_string(o);
					
					File log = new File("IOR.txt");
					
					FileWriter fileWriter;
					try {
						fileWriter = new FileWriter(log, true);
						BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
						try {
							bufferedWriter.write(ior);
						} catch (IOException e) {
							System.out.println("unexpected error");
							System.exit(1);
						}
					} catch (IOException e1) {
						System.out.println("unexpected error");
						System.exit(1);
					}
					
					orb.run();
				} catch (ServantNotActive | WrongPolicy e) {
					System.out.println("unexpected error");
				}
			} catch (AdapterInactive e) {
				System.out.println("unexpected error");
			}
			
		} catch (InvalidName e) {
			System.out.println("unexpected error");
		}	
	}
}
