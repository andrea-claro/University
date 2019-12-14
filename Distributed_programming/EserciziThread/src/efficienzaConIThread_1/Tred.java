package efficienzaConIThread_1;

class Tred extends Thread{
	
	public Tred(int start, int end, int array[]) {
		this.start= start;
		this.end= end;
		this.array= array;
	}
	
	public void run() {
		for (int k= start; k < end; k++)
			array[k]= 42;
	}
	
	private int[] array;
	private int start;
	private int end;
}
