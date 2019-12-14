package impiegato_locale;

public class ImpiegatoServer {

	public ImpiegatoServer(String n, String I, int s) {
		nome = n;
		ID = I;
		stipendio = s;
	}
	
	public String getNome() {
		return nome;
	}
	
	public String getID() {
		return ID;
	}
	
	public int getStipendio() {
		return stipendio;
	}
	
	public int aumentaStipendio(int tot) {
		if (tot > 0)
			stipendio += tot;
		return stipendio;
	}
	
	private String nome;
	private String ID;
	private int stipendio;
}
