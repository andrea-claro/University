package esercizio_2;

public class Server implements Methods{

	public Server() {
		N = 0;
	}
	
	public void add(int n) {
		N += n;
	}
	
	public int getN() {
		return N;
	}
	
	private static int N;
}
