package efficienzaConIThread_2;

public class Main {

	public static void main(String[] args) throws InterruptedException {
		
		final int NTREAD= 16;
		final int DIMENSION= 12000000;
		final int NDIVISION= DIMENSION/NTREAD;
		int[] array= new int[DIMENSION];
		long sum= 0;
		long max= 0;
		
		Tred[] prox= new Tred[NTREAD];
		long start= System.currentTimeMillis();
		for (int k= 0; k < NTREAD; k++) {
			prox[k]= new Tred(k*NDIVISION, (k+1)*NDIVISION, array);
			prox[k].start();
		}
		for (Tred p: prox) {
			p.join();
			sum+= p.getSum();
			System.out.println(sum);
			long mix= p.getMax();
			if (max < mix)
				max= mix;
		}
		long end= System.currentTimeMillis();
		System.out.println("La somma risulta: "+ sum+ " ed il massimo: " + max + " calcolata in un tempo di: "+(end-start));
	}

}
