//import java.util.Scanner;

public class CreatePasswordTester{
	
	public CreatePasswordTester(){
		password= new CreatePassword();
	}

	public CreatePasswordTester(String name, String surname, int birthDate){
		password= new CreatePassword(name, surname, birthDate);
	}
	
	public String getKey(){
		return password.getPassword();
	}
	private CreatePassword password;

	public static void main(String args[]){
//		Scanner in= new Scanner(System.in);

/*
		System.out.println("inserire nome: ");
		String a= nextLine();
		System.out.println("inserire cognome: ");
		String b= nextLine();
		System.out.println("inserire anno nascita: ");
		int c= nextInt();
/*
/*
		String a= JOptionPane.showInputDialog("inserire nome: ");
		String b= JOptionPane.showInputDialog("inserire cognome: ");
		String c= JOptionPane.showInputDIalog("inserire anno nascita: ");
		int d= Integer.parseInt(c);
*/

		System.out.println();
		int a= Integer.parseInt(args[2]);

		CreatePasswordTester test= new CreatePasswordTester(args[0], args[1], a);
		System.out.println("la password risulta: "  +  test.getKey());

//		exit(0);
	}
}
