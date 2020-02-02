package sum;

import java.rmi.Naming;
import java.util.Scanner;
import java.util.logging.Logger;

public class SumClient2{

	private static Logger logger = Logger.getLogger("global");
	
	public static void main(String[] args) {
		logger.info("Starting CLIENT 2");
		Scanner in = new Scanner(System.in);
		
		try {
			logger.info("Searching remote object");
			Sum obj = (Sum) Naming.lookup("rmi://localhost/SummingNumbers");
			System.out.println("The actual number is: "+obj.getN());
			
			logger.info("Please, insert value to sum: ");
			int n = in.nextInt();
			obj.sumN(n);
			System.out.println("The actual number is: "+obj.getN());
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			in.close();
		}
		
		
	}
}
