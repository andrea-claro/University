public class RegistratoreCassa{

	public class Articolo{
		
		private int prezzoArticolo;
		
		public Articolo(){
			prezzoArticolo= 0;
		}

		public Articolo(int prezzo){
			prezzoArticolo= prezzo;
		}

		public int getPrezzo(){
			return prezzoArticolo;
		}
	}
	
	private Articolo giornale;
	private int credito;
	private int resto;

	public RegistratoreCassa(){
		giornale= new Articolo();
		credito= 0;
		resto= 0;
	}

	public RegistratoreCassa(int prezzo, int soldi){
		giornale= new Articolo(prezzo);
		credito= soldi;

		resto= credito - giornale.getPrezzo();
	}

	public int getResto(){
		return resto;
	}	

	public static void main(String args[]){
		RegistratoreCassa edicola= new RegistratoreCassa(2, 5);

		System.out.print("Il prezzo: ");
		System.out.println(edicola.giornale.getPrezzo());
		System.out.print("Il credito: ");
		System.out.println(edicola.credito);
		System.out.print("Il resto: ");
		System.out.println(edicola.getResto());
	}
}
