package listing;

import java.util.ArrayList;

public interface Lists extends java.rmi.Remote{
	void insertInList(String str) throws java.rmi.RemoteException;
	ArrayList<String> getList() throws java.rmi.RemoteException;
	boolean deleteFromList(String str) throws java.rmi.RemoteException;
}
