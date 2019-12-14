package esercizio_1;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Skeleton1 extends Thread{

	public Skeleton1(Server dati) {
		this.server = dati;
	}

	public static void main(String[] args) {
		Socket socket = null;
		ObjectInputStream in = null;
		try {
			ServerSocket serverSocket = new ServerSocket(5000);
			while (true) {
				System.out.println("Waiting data");
				socket = serverSocket.accept();
				System.out.println("Got data connection");
				in = new ObjectInputStream(socket.getInputStream());
				int x = in.readInt();
				int y = in.readInt();
				System.out.println("x: "+x+"		y: "+y);
				Skeleton1 skeleton = new Skeleton1(new Server(x, y));
				skeleton.start();
			}
		}catch (Throwable t) {
			t.printStackTrace();
			System.out.println("Problemi in ricezioni dati SERVER");
		}
	}
	
	public void run() {
		Socket socket= null;
		ServerSocket serverSocket = null;
		ObjectOutputStream out = null;
		String method = null;
		ObjectInputStream in = null;
		try {
			serverSocket = new ServerSocket(6000);
			System.out.println("Waiting sending");
			socket = serverSocket.accept();
			System.out.println("Got reading connection");
			out = new ObjectOutputStream(socket.getOutputStream());
			in = new ObjectInputStream(socket.getInputStream());
			while (true) {				
				try {
					method = (String) in.readObject();
					if (method.equals("getA")){
						out.writeInt(server.getA());
						out.flush();
					}else if (method.equals("getB")) {
						out.writeInt(server.getB());
						out.flush();
					}else if (method.equals("sum")) {
						out.writeInt(server.sum());
						out.flush();
					}else
						break;
				}catch(Throwable t) {
					break;
				}
			}
		}catch (Throwable t) {
			t.printStackTrace();
			System.out.println("Problemi in lettura dati SERVER");
		}finally {
			try {
				out.close();
				in.close();
				socket.close();
				serverSocket.close();
			}catch (Throwable t) {
				t.printStackTrace();
				System.out.println("Problemi in chiusura SERVER");
			}
		}
	}
	
	private Server server;
}
