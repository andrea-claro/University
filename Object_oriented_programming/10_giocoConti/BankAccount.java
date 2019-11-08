public class BankAccount{	
	public BankAccount(){
		balance= 0;
	}

	public BankAccount(double initialBalance){
		balance= initialBalance;
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
	
	public static BankAccount insert(int amount){
		return new BankAccount(amount);
	}
	private double balance;
}

