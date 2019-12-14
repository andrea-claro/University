package impiegato_socket_1;

import java.io.EOFException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.logging.Logger;

public class Impiegato_Skeleton extends Thread{
	
	static Logger logger = Logger.getLogger("global");

	public Impiegato_Skeleton(ImpiegatoServer server) {
		mioServer = server;
	}

	public static void main(String[] args) {
		ImpiegatoServer impiegato = new ImpiegatoServer("Mario Rossi", "01721", 30000);
		Impiegato_Skeleton skeleton = new Impiegato_Skeleton(impiegato);
		skeleton.start();
	}
	
	public void run() {
		Socket socket = null;
		String metodo;
		int par;
		System.out.println("Attendo connessioni...");
		try {
			@SuppressWarnings("resource")
			ServerSocket serverSocket = new ServerSocket(7000);
			socket = serverSocket.accept();
			System.out.println("Accettata una connessione... attendo comandi.");
			ObjectOutputStream outStream = new ObjectOutputStream(socket.getOutputStream());
			ObjectInputStream inStream = new ObjectInputStream(socket.getInputStream());
			while (true) {
				metodo = (String) inStream.readObject();
				System.out.println("Comando richiesto: "+metodo);
				if (metodo.equals("getNome")) {
					outStream.writeObject(mioServer.getNome());
					outStream.flush();
				}else if (metodo.equals("getID")) {
					outStream.writeObject(mioServer.getID());
					outStream.flush();
				}else if (metodo.equals("getStipendio")) {
					outStream.writeInt(mioServer.getStipendio());
					outStream.flush();
				}else if (metodo.equals("aumentaStipendio")) {
					par = inStream.readInt();
					outStream.writeInt(mioServer.aumentaStipendio(par));
					outStream.flush();
				}else break;
			}
		}catch (EOFException e) {
			System.out.println("Terminata la connessione.");
		}catch (Throwable t) {
			t.printStackTrace();
			System.out.println("Skeleton: "+t.getMessage());
		}finally {
			try {
				socket.close();
			}catch (IOException e) {
				e.printStackTrace();
				System.exit(0);
			}
		}
	}

	ImpiegatoServer mioServer;
}
