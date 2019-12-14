package esercizio_1;

public class Server implements Som{

	public Server(int a, int b) {
		this.a = a;
		this.b = b;
	}
	
	public void setA(int x) {
		this.a = x;
	}
	
	public void setB(int x) {
		this.b = x;
	}
	
	public int getA() {
		return this.a;
	}
	
	public int getB() {
		return this.b;
	}
	
	public int sum() {
		return this.a+this.b;
	}

	private int a;
	private int b;
}
