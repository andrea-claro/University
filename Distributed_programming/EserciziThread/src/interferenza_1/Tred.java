package interferenza_1;

public class Tred extends Thread{
	
	public Tred(Counter c) {
		this.c= c;
	}
	
	public void run() {
		this.c.count();
	}
	
	public int getN() {
		return this.c.getN();
	}
	
	
	private Counter c;
}
