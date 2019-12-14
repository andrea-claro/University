package montecarlo;

public class Main {

	public static void main(String[] args) throws InterruptedException {
		
		final int N= 20000000;
		Punto[] punti= new Punto[N];
		float c= 0;
		long start= System.currentTimeMillis();
		for (Punto p: punti) {
			p= new Punto();
			if (p.inside())
				c++;
		}
		double phi= 4*(c/N);
		long end= System.currentTimeMillis();
		System.out.println("Phi: "+phi+ " con c: "+c+" su n: "+N+" nel tempo: "+(end-start));
		
		final int NTREAD= 10;
		Punto[] puntix= new Punto[N];
		Tred[] prox= new Tred[NTREAD];
		c= 0;
		start= System.currentTimeMillis();
		for (int k= 0; k < NTREAD; k++) {
			prox[k]= new Tred(puntix, k*(N/NTREAD), (k+1)*(N/NTREAD));
			prox[k].start();
		}
		for (Tred p: prox) {
			p.join();
			c+= p.getC();
		}
		phi= 4*(c/N);
		end= System.currentTimeMillis();
		System.out.println("Phi: "+phi+ " con c: "+c+" su n: "+N+" nel tempo: "+(end-start));
	}

}
