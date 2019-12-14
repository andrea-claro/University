package montecarlo;

import java.util.Random;

public class Punto {

	public Punto() {
		gen= new Random();
		this.x= gen.nextFloat();
		this.y= gen.nextFloat();
	}

	public boolean inside() {
		return ((this.x * this.x) + (this.y * this.y) < 1);
	}
	
	
	private float x;
	private float y; 
	private Random gen;
}
