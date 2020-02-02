package ex2;

import java.io.EOFException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.Scanner;
import java.util.logging.Logger;

public class Client1 {

	private static Logger logger = Logger.getLogger("global");
	
	public static void main(String[] args) {
		logger.info("Starting CLIENT 1");
		Scanner inScanner = new Scanner(System.in);
		Socket socket = null;
		
		try {
			socket = new Socket("localhost", 9000);
			ObjectOutputStream out = new ObjectOutputStream(socket.getOutputStream());
			ObjectInputStream in = new ObjectInputStream(socket.getInputStream());
			
			logger.info("Please, insert the number to pass:");
			int n = inScanner.nextInt();
			out.writeInt(n);
			out.flush();
			
			System.out.println("The number now is: "+in.readInt());
		}catch (EOFException e) {
			e.printStackTrace();
		}catch (Throwable t) {
			logger.severe("Lanciata Throwable. "+t.getMessage());
			t.printStackTrace();
		} finally {
			try {
				socket.close();
			} catch (Exception e) {
				
			}
			
		}
	}

}
