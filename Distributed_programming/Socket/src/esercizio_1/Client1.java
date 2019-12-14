package esercizio_1;

import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.Random;


public class Client1 extends Thread{

	public static void main(String[] args) {
		Socket socket = null;
		Random gen = new Random();
		ObjectOutputStream out = null;
		Stub stub = null;
		try {
			socket = new Socket("localhost", 5000);
			System.out.println("Making data");
			out = new ObjectOutputStream(socket.getOutputStream());
			out.writeInt(gen.nextInt(50));
			out.writeInt(gen.nextInt(50));
			out.flush();
			stub = new Stub();
			System.out.println("Asking data");
			System.out.println("a: "+stub.getA());
			System.out.println("b: "+stub.getB());
			System.out.println("sum: "+stub.sum());
		}catch (Throwable t) {
			t.printStackTrace();
			System.out.println("Problemi in CLIENT");
		}finally {
			try {
				out.close();
				socket.close();
				((Stub) stub).close();
			}catch (Throwable t) {
				t.printStackTrace();
				System.out.println("Problemi in chiusura CLIENT");
			}
		}
	}
}
