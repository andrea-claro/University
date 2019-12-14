package montecarlo;

public class Tred extends Thread{

	
	public Tred(Punto p[], int start, int stop) {
		this.start= start;
		this.stop= stop;
		this.punti= p;
		this.c= 0;
	}

	public void run() {
		for (int k= this.start; k < this.stop; k++) {
			punti[k]= new Punto();
			if (punti[k].inside())
				this.c++;
		}
	}
	
	public float getC() {
		return this.c;
	}
	
	
	private Punto[] punti;
	private int start;
	private int stop;
	private float c;
}
