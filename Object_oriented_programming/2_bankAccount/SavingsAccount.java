public class SavingsAccount{
	
	private double interestRate;
	private double balance;
	
	public SavingsAccount(double initialBalance){
		balance= initialBalance;
		interestRate= ((balance/100)*5)/4;
	}

	public void SavingsAccount(){
		balance= 0;
		interestRate= 0;
	}

	public void deposit(double amount){
		balance= balance + amount;
	}

	public void withdrawls(double amount){
		balance= balance - amount;
	}

	public double getBalance(){
		return balance;
	}

	public void addInterest(){
		balance= balance + interestRate;
	}

	public static void main(String args[]){
		SavingsAccount andrea= new SavingsAccount(300.00);

		System.out.print("Il conto risulta di: ");
		System. out. println(andrea.getBalance());

		andrea.addInterest();
		System.out.print("Il conto risulta di: ");
		System. out. println(andrea.getBalance());
	}
}

