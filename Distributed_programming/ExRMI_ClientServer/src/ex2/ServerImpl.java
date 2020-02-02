package ex2;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.logging.Logger;

public class ServerImpl extends Thread{

	private static Logger logger = Logger.getLogger("global");
	private static ServerSocket serverSocket;
	private static int number;
	private static Socket socket;
	private static ObjectOutputStream outStream;
	private static ObjectInputStream inStream;
	
	public ServerImpl() throws IOException {
		number = 0;
		serverSocket = new ServerSocket(9000);
	}
	
	private boolean acceptingSocket() {
		try {
			socket = serverSocket.accept();
			return true;
		} catch (Exception e) {
			return false;
		}
	}
	
	private boolean openStreams() {
		try {
			outStream = new ObjectOutputStream(socket.getOutputStream());
			inStream = new ObjectInputStream(socket.getInputStream());
			return true;
		} catch (Exception e) {
			return false;
		}
	}
	
	public void run() {
		while (true) {
			try {
				logger.info("Accepting any client");
				if (this.acceptingSocket()) {
					logger.info("Been Connected");
					if (this.openStreams()) {
						logger.info("Streams created");
						
						logger.info("Getting a number:");
						int n = (int) inStream.readInt();
						logger.info("recieved : "+n);
						
						number += n;
						
						logger.info("Sending all numbers");
						outStream.writeInt(number);
						outStream.flush();
					}
				}
				else
					logger.info("Haven't been connected");
				
			} catch (Exception e) {
				logger.info("ERROR");
			} finally {
				try {
					outStream.close();
					inStream.close();
					this.closeSocket();
					logger.info("closing");
				} catch (Exception e) {
					logger.info("ERROR");
				}
				
			}
		}
	}
	
	public void closeSocket() {
		try {
			socket.close();
		} catch(Exception e) {
			return;
		}
		
	}
	
	public static void main(String[] args) throws Exception {
		logger.info("Starting SERVER");
		ServerImpl server = null;
		try {
			server = new ServerImpl();
			server.start();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}