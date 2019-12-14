package interferenza_1;

public class Counter {
	
	public Counter(int n, int first) {
		this.NC= n;
		this.cn= first;
		this.i= new Incrementatore();
	}
	
	public void count() {
		for (int k= 0; k < NC; k++)
			this.cn= this.i.incrementa(this.cn);
	}
	
	public int getN() {
		return this.cn;
	}
	
	private int cn;
	private Incrementatore i;
	final int NC;
}
