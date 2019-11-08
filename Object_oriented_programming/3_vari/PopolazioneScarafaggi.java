public class PopolazioneScarafaggi{

	private float nScarafaggi;

	public PopolazioneScarafaggi(){
		nScarafaggi= 0;
	}

	public PopolazioneScarafaggi(float n){
		nScarafaggi= n;
	}

	public float getNScarafaggi(){
		return nScarafaggi;
	}

	public void doubleScarafaggi(){
		nScarafaggi= nScarafaggi*2;
	}

	public void killScarafaggi(){
		float killedBeatle= (nScarafaggi/100)*10;
		nScarafaggi= nScarafaggi - killedBeatle;
	}

	public static void main(String args[]){
		PopolazioneScarafaggi beatle= new PopolazioneScarafaggi(27);

		System.out.print("oggi abbiamo in cucina: ");
		System.out.printf("%.0f", beatle.getNScarafaggi());
		System.out.println();

		beatle.doubleScarafaggi();
		System.out.print("domani abbiamo in cucina: ");
		System.out.printf("%.0f", beatle.getNScarafaggi());
		System.out.println();

		beatle.killScarafaggi();
		System.out.print("dopodomani abbiamo in cucina: ");
		System.out.printf("%.0f", beatle.getNScarafaggi());
		System.out.println();
	}
}
