package sum;

public interface Sum extends java.rmi.Remote{
	int getN() throws java.rmi.RemoteException;
	void sumN(int n) throws java.rmi.RemoteException;
}
