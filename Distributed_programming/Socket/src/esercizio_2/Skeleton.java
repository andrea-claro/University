package esercizio_2;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Skeleton extends Thread{

	public Skeleton(int n) {
		server.add(n);
	}

	public static void main(String[] args) {
		Socket socket = null;
		ObjectInputStream in = null;
		try {
			ServerSocket serverSocket = new ServerSocket(6000);
			while (true) {
				System.out.println("Waiting data");
				socket = serverSocket.accept();
				System.out.println("Data coming");
				in = new ObjectInputStream(socket.getInputStream());
				int x = in.readInt();
				System.out.println("x: "+x);
				Skeleton skeleton = new Skeleton(x);
				skeleton.start();
			}
		}catch (Throwable t) {
			t.printStackTrace();
			System.out.println("Problemi in ricezione dati - SERVER");
		}
	}

	public void run() {
		Socket socket = null;
		ObjectInputStream in = null;
		ObjectOutputStream out = null;
		ServerSocket serverSocket = null;
		String method;
		try {
			serverSocket = new ServerSocket(7000);
			System.out.println("Waiting to send");
			socket = serverSocket.accept();
			System.out.println("Got sending connection");
			out = new ObjectOutputStream(socket.getOutputStream());
			in = new ObjectInputStream(socket.getInputStream());
			while (true) {
				try {
					method = (String) in.readObject();
					if (method.equals("getN")) {
						out.writeInt(server.getN());
						out.flush();
					}else
						break;
				}
				catch (Throwable t) {
					break;
				}
			}
		}catch (Throwable t) {
			t.printStackTrace();
			System.out.println("Problemi in invio dati - SERVER");
		}finally {
			try {
				out.close();
				in.close();
				socket.close();
				serverSocket.close();
			}catch (Throwable t) {
				System.out.println("Problemi in chiusura - SERVER");
			}
			
		}
	}
	
	private static Server server = new Server();
}
