package efficienzaConIThread_2;

public class Tred extends Thread{
	
	public Tred(int start, int end, int array[]) {
		this.start= start;
		this.end= end;
		this.array= array;
		this.sum= 0;
		this.max= 0;
	}
	
	public void run() {
		array[0]= 1;
		max= array[0];
		for (int k= start+1; k < end; k++) {
			array[k]= 1 + array[k-1];
			sum+= array[k];
			if (max < array[k])
				max= array[k];
		}
	}
	
	public long getSum() {
		return this.sum;
	}
	
	public long getMax() {
		return this.max;
	}
	
	private int[] array;
	private int start;
	private int end;
	private long sum;
	private long max;
}
