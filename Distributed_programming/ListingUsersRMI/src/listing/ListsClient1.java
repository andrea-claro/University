package listing;

import java.rmi.Naming;
import java.util.Scanner;
import java.util.logging.Logger;

public class ListsClient1 {

	private static Logger logger = Logger.getLogger("global");

	public static void main(String[] args) {
		logger.info("Starting CLIENT 1");
		Scanner in = new Scanner(System.in);

		try {
			logger.info("Searching remote object");
			Lists obj = (Lists) Naming.lookup("rmi://localhost/ListingUsers");
			String user;
			String cmd;

			while (true) {
				logger.info("Please, insert command: [add, delete, list]");
				cmd = in.next();

				if (cmd.equals("add")) {
					logger.info("Please, insert user to add: ");
					user = in.next();
					obj.insertInList(user);

				} else if (cmd.equals("delete")) {
					logger.info("Please, insert user to remove: ");
					user = in.next();
					boolean isRemoved = obj.deleteFromList(user);
					if (isRemoved)
						System.out.println("Been removed");
					else
						System.out.println("Haven't been removed");
					
				} else if (cmd.equals("list")) {
					System.out.println("The actual list is: " + obj.getList());
				} else {
					continue;
				}
			}			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			in.close();
		}
	}
}
