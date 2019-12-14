package efficienzaConIThread_1;

public class Main {

	public static void main(String[] args) throws InterruptedException {
		
		final int N= 12000000;
		int[] array= new int[N];
		long start= System.currentTimeMillis();
		for (int el: array)
			el= 42;
		long end= System.currentTimeMillis();
		System.out.println("Tempo impiegato inizializzazione= "+ (end-start));
		
		Tred[] prox= new Tred[2];
		final int ND= N/2;
		start= System.currentTimeMillis();
		for (int k= 0; k < 2; k++) {
			prox[k]= new Tred(k*ND, (k+1)*ND, array);
			prox[k].start();
		}
		for (Tred p: prox)
			p.join();
		end= System.currentTimeMillis();
		System.out.println("Tempo impiegato inizializzazione 2 thread= "+ (end-start));
		
		Tred[] prix= new Tred[4];
		final int NQ= N/4;
		start= System.currentTimeMillis();
		for (int k= 0; k < 4; k++) {
			prix[k]= new Tred(k*NQ, (k+1)*NQ, array);
			prix[k].start();
		}
		for (Tred p: prix)
			p.join();
		end= System.currentTimeMillis();
		System.out.println("Tempo impiegato inizializzazione 4 thread= "+ (end-start));
	}

}
