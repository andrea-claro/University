package impiegato_socket_2;

public interface Impiegato {
	public String getNome() throws Throwable;
	public String getID() throws Throwable;
	public int getStipendio() throws Throwable;
	public int aumentaStipendio(int tot) throws Throwable;
}
