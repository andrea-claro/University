import java.util.Scanner;

public class DadoTester{

	public static void main(String args[]){
		System.out.println();

		Scanner in= new Scanner(System.in);
		System.out.println("insert number of faces:");
		Dado a= new Dado(in.nextInt());
		
		System.out.println();
		System.out.println("do you wanna play?	[-1 to exit]");
		int n= in.nextInt();
		while(n  !=  -1){
			System.out.println("it goes:	"  +  a.lancio());

			System.out.println();
			System.out.println("do you wanna play?	[-1 to exit]");
			n= in.nextInt();
		}
	}
}
