package impiegato_locale;

public class Client {
	
	public static void main(String[] args) {
		ImpiegatoServer imp = new ImpiegatoServer("Mario Rossi", "01721", 30000);
		System.out.println("Nome: "+imp.getNome());
		System.out.println("ID: "+imp.getID());
		System.out.println("Stipendio: "+imp.getStipendio());
		System.out.println("Aumentiamo lo stipendio di 1000 euro");
		System.out.println("Ora il suo stipendio è di: "+imp.aumentaStipendio(1000));
	}
}
