package interferenza_2;

public class Main {

	public static void main(String[] args) throws InterruptedException {
		Smiley s1= new Smiley();
		Smiley s2= new Smiley();
		s1.start();
		s1.join();
		s2.start();
	}

}
