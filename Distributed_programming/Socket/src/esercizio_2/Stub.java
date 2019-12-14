package esercizio_2;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

public class Stub implements Methods{

	public Stub() throws Throwable{
		for (long k = 0; k < 1000000000L; k++);
		this.socket = new Socket("localhost", 7000);
		this.out = new ObjectOutputStream(socket.getOutputStream());
		this.in = new ObjectInputStream(socket.getInputStream());
	}
	
	public int getN() throws Throwable {
		out.writeObject("getN");
		out.flush();
		return in.readInt();
	}
	
	public void close() {
		try {
			out.close();
			in.close();
			socket.close();
		}catch (IOException e) {
			System.out.println("Chiusura socket non effettutata con successo!");
		}
	}

	private Socket socket;
	private ObjectOutputStream out;
	private ObjectInputStream in;
}
