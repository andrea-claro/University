package esercizio_2;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.Random;

public class Client {

	public static void main(String[] args) {
		Socket socket = null;
		ObjectOutputStream out = null;
		Stub stub = null;
		Random gen = new Random();
		try {
			socket = new Socket("localhost", 6000);
			out = new ObjectOutputStream(socket.getOutputStream());
			int x = gen.nextInt(50);
			out.writeInt(x);
			out.flush();
			stub = new Stub();
			System.out.println("Aggiunto: "+x);
			System.out.println("Ora il valore risulta: "+ stub.getN());
		}catch (Throwable t) {
			t.printStackTrace();
			System.out.println("Problemi nel CLIENT");
		}finally {
			try {
				out.close();
				socket.close();
				((Stub) stub).close();
			}catch (Throwable t) {
				t.printStackTrace();
				System.out.println("Problemi in chiusura - CLIENT");
			}
		}
	}

}
