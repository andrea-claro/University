package helloworld;

import java.rmi.Naming;
import java.rmi.RMISecurityManager;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.logging.Logger;

public class HelloImpl extends UnicastRemoteObject implements Hello{
	static Logger logger = Logger.getLogger("global");
	
	public HelloImpl() throws RemoteException{
		
	}

	public String dimmiQualcosa(String daChi) throws RemoteException {
		logger.info("Sto salutando: "+ daChi);
		return "Ciao";
	}

	@SuppressWarnings("deprecation")
	public static void main(String[] args) {
		System.setSecurityManager(new RMISecurityManager());
		try {
			logger.info("Creo l'oggetto remoto...");
			HelloImpl obj = new HelloImpl();
			logger.info("... ora ne effettuo il rebind...");
			Naming.rebind("HelloServer", obj);
			logger.info("... pronto");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
