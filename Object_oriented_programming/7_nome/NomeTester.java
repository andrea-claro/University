import java.util.Scanner;
import java.io.*;

public class NomeTester{

	public NomeTester(){
		x= new Nome();
	}

	public NomeTester(String a){
		x= new Nome(a);
	}

	public String getName(){
		return x.getNome();
	}


	public void printing(){
		x.printName();
		System.out.println();
		return;
	}


	private Nome x;

	public static void main(String a[]) throws FileNotFoundException{
		Scanner in= new Scanner(System.in);
		File data= new File("Nome.txt");
		PrintStream dataIn= new PrintStream(data);

		System.out.print("inserire nome: ");
		String nome= in.nextLine();
		dataIn.println(nome);
		
		NomeTester test= new NomeTester(nome);
		
		test.printing();
	}
}
