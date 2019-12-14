package client_server_1;

import java.io.EOFException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.logging.Logger;

public class Server {
	static Logger logger = Logger.getLogger("global");

	public static void main(String[] args) {
		try {
			@SuppressWarnings("resource")
			ServerSocket serverSocket = new ServerSocket(9000);
			logger.info("Socket instanziato, accetto connessioni...");
			Socket socket = serverSocket.accept();
			logger.info("Accettata una connessione... attendo comandi.");
			ObjectOutputStream outStream = new ObjectOutputStream(socket.getOutputStream());
			ObjectInputStream inStream = new ObjectInputStream(socket.getInputStream());
			String nome = (String) inStream.readObject();
			logger.info("Riceuto: "+nome);
			outStream.writeObject("Hello "+nome+"!");
			socket.close();
		}catch (EOFException e) {
			logger.severe("Problemi con la connessione. "+e.getMessage());
			e.printStackTrace();
		}catch (Throwable t) {
			logger.severe("Lanciata Throwable. "+t.getMessage());
			t.printStackTrace();
		}

	}

}
