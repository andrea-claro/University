package helloworld;

public interface Hello extends java.rmi.Remote{
	String dimmiQualcosa(String daChi) throws java.rmi.RemoteException;
}
