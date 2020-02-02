package sum;

import java.rmi.Naming;
import java.rmi.RMISecurityManager;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.logging.Logger;

public class SumImpl extends UnicastRemoteObject implements Sum{

	private static final long serialVersionUID = 1L;
	private static Logger logger = Logger.getLogger("global");
	
	public SumImpl() throws RemoteException {
	}
	
	public int getN() throws RemoteException {
		logger.info("returning number");
		return number;
	}

	public void sumN(int n) throws RemoteException {
		logger.info("summing n to number");
		number += n;
	}

	
	
	public static void main(String[] args) {
		logger.info("Starting SERVER");
		
		System.setSecurityManager(new RMISecurityManager());
		try {
			logger.info("Creating object");
			SumImpl obj = new SumImpl();
			
			logger.info("Rebinding");
			Naming.rebind("SummingNumbers", obj);
			
			logger.info("Waiting numbers...");
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	private static int number = 0;
}
