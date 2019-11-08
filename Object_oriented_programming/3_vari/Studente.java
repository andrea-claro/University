public class Studente{

	public class Esame{
		
		private int voto;

		public Esame(){
			voto= 0;
		}

		public Esame(int punteggio){
			voto= punteggio;
		}

		public int getVoto(){
			return voto;
		}
	}

	private Esame P1, PSD, Java;
	private int media;

	public Studente(){
		P1= new Esame();
		PSD= new Esame();
		Java= new Esame();
	
		media= 0;
	}

	public Studente(int pr1, int pr2, int j){
		P1= new Esame(pr1);
		PSD= new Esame(pr2);
		Java= new Esame(j);
		
		media= (P1.getVoto() + PSD.getVoto() + Java.getVoto())/3;
	}

	public int getMedia(){
		return media;	
	}

	public static void main(String args[]){
		Studente andrea= new Studente(23, 25, 30);

		System.out.print("la media: ");
		System.out.println(andrea.getMedia());
	}
}
