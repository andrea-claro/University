public class BankAccount{
	
	private double balance;
	
	public BankAccount(double initialBalance){
		balance= initialBalance;
	}

	public BankAccount(){
		balance= 0;
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

	public static void main(String args[]){
		BankAccount andrea= new BankAccount(300.00);

		System.out.print("Il conto risulta di: ");
		System. out. println(andrea.getBalance());
	}
}

