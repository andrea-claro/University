package impiegato_socket_1;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

public class Impiegato_Stub implements Impiegato{

	public Impiegato_Stub(String host) throws Throwable {
		socket = new Socket(host, 7000);
		out = new ObjectOutputStream(socket.getOutputStream());
		in = new ObjectInputStream(socket.getInputStream());
	}

	public String getNome() throws Throwable {
		out.writeObject("getNome");
		out.flush();
		return (String) in.readObject();
	}

	public String getID() throws Throwable {
		out.writeObject("getID");
		out.flush();
		return (String) in.readObject();
	}

	public int getStipendio() throws Throwable {
		out.writeObject("getStipendio");
		out.flush();
		return in.readInt();
	}

	public int aumentaStipendio(int tot) throws Throwable {
		out.writeObject("aumentaStipendio");
		out.writeInt(tot);
		out.flush();
		return in.readInt();
	}
	
	public void close() {
		try {
			socket.close();
		}catch (IOException e) {
			System.out.println("Chiusura socket non effettutata con successo!");
		}
	}
	
	
	Socket socket;
	ObjectOutputStream out;
	ObjectInputStream in;
}
