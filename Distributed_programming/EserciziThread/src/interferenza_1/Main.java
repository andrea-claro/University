package interferenza_1;

public class Main {

	public static void main(String[] args) throws InterruptedException {
		
		final int N= 40000;
		int first= 0;
		Counter counter= new Counter(N, first);
		long start= System.currentTimeMillis();
		counter.count();
		int n= counter.getN();
		long end= System.currentTimeMillis();
		System.out.println("Incrementato fino a: "+n+" nel tempo di: "+(end-start));
		
		final int ND= 10000;
		final int NTREAD= 4;
		Tred[] t= new Tred[NTREAD];
		Counter count= new Counter(ND, 0);
		n= 0;
		start= System.currentTimeMillis();
		for (int k= 0; k < NTREAD; k++) {
			t[k]= new Tred(count);
			t[k].start();
			//t[k].join()	per non avere race condition
			n= t[k].getN();
			System.out.println(n);
		}
		end= System.currentTimeMillis();
		System.out.println("Incrementato fino a: "+n+" nel tempo di: "+(end-start));
	}

}
