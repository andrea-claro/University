import java.util.Random;

public class Dado{

	public Dado(int n){
		face= n;
		gen= new Random();
	}

	public int lancio(){
		return  (1  +  gen.nextInt(face));
	}

	private int face;
	private Random gen;
		
}
