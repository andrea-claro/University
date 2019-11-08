import java.util.Scanner;
public class Azzard{
	public static void main(String args[]){
		BankAccount player= BankAccount.insert(1000);
		BankAccount casino= BankAccount.insert(100000);

		System.out.println();
		System.out.print("inseririe la faccia del dado su cui puntare: ");
		Scanner in= new Scanner(System.in);

		int face= in.nextInt();

		System.out.println();
		System.out.println("inserire la somma da puntare:	[deve essere < "  +  player.getBalance()  +  " e < di "  +  casino.getBalance()/5  +  " ]");
		int summ= in.nextInt();
		while(summ  >  player.getBalance()  &&  summ  >  casino.getBalance()/5){
			System.out.println("inserire la somma da puntare:	[deve essere < "  +  player.getBalance()  +  " e < di "  +  casino.getBalance()/5  +  " ]");
			summ= in.nextInt();
		}

		Dado foo= Dado.insert(6);

		int result= foo.lancio();

		System.out.println();
		System.out.println("il numero uscito dal lancio del dado risulta "  + result);
		
		if(result  ==  face){
			player.deposit(5*summ);
			casino.withdrawls(5*summ);
			System.out.println("WIN");
		}

		else{
			casino.deposit(5*summ);
			player.withdrawls(5*summ);
			System.out.println("LOST");
		}
	}
}
