package interferenza_2;

public class Smiley extends Thread{

	public void run() {
		while (true) {
			try {
				System.out.print("Smiley ");
				this.printDuePunti();
				this.printTrattino();
				this.printParentesiChiusa();
				break;
			}catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
	
	private void printParentesiChiusa() throws InterruptedException{
		System.out.print(")	");
		Thread.sleep(100);
	}

	private void printTrattino() throws InterruptedException{
		System.out.print("-");
		Thread.sleep(100);
	}
	
	private void printDuePunti() throws InterruptedException{
		System.out.print(":");
		Thread.sleep(100);
	}
}
