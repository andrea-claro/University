package listing;

import java.rmi.Naming;
import java.rmi.RMISecurityManager;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.logging.Logger;

public class ListsImpl extends UnicastRemoteObject implements Lists{

	private static final long serialVersionUID = 1L;
	private static Logger logger = Logger.getLogger("global");
	private static ArrayList<String> list = new ArrayList<String>();
	
	protected ListsImpl() throws RemoteException {
	}

	public void insertInList(String str) throws RemoteException {
		logger.info("adding: "+str);
		list.add(str);
	}

	public ArrayList<String> getList() throws RemoteException {
		logger.info("returning: "+ list);
		return list;
	}

	public boolean deleteFromList(String str) throws RemoteException {
		boolean isRemoved = list.remove(str);
		logger.info("A "+isRemoved+" deleting from the list");
		return isRemoved;
	}

	
	
	public static void main(String[] args) {
		logger.info("Starting SERVER");
		
		System.setSecurityManager(new RMISecurityManager());
		try {
			logger.info("Creating object");
			ListsImpl obj = new ListsImpl();
			
			logger.info("Rebinding");
			Naming.rebind("ListingUsers", obj);
			
			logger.info("Waiting users...");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
