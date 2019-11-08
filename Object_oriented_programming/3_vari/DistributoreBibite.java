public class DistributoreBibite{

	private int numeroLattine;
	private int numeroGettoni;

	public DistributoreBibite(){
		numeroLattine= 10;
		numeroGettoni= 0;
	}

	public DistributoreBibite(int initialLattine, int initialGettoni){
		numeroLattine= initialLattine;
		numeroGettoni= initialGettoni;
	}
	
	public void getLattina(){
		numeroLattine= numeroLattine - 1;
		numeroGettoni= numeroGettoni + 1;
	}

	public int getNLattine(){
		return numeroLattine;
	}

	public int getNGettoni(){
		return numeroGettoni;
	}

	public static void main(String args[]){
		DistributoreBibite condom= new DistributoreBibite(5, 6);

		System.out.print("Il distribbutore possiede: ");
		System.out.print(condom.getNLattine());
		System.out.print(" lattine, ");
		System.out.print(condom.getNGettoni());
		System.out.println(" gettoni");

		condom.getLattina();

		System.out.print("Il distribbutore possiede: ");
		System.out.print(condom.getNLattine());
		System.out.print(" lattine, ");
		System.out.print(condom.getNGettoni());
		System.out.println(" gettoni");

	}
}
