public class TestAuto{

	private Auto a, b;

	public TestAuto(){
		a= new Auto();
		b= new Auto();
	}

	public TestAuto(String info[]){
		a= new Auto(info, 55, 5);
		b= new Auto(info, 66 , 6);
	}

	public static void main(String args[]){
		TestAuto ciaccio= new TestAuto(args);

		System.out.print("autonomia in km max di a: ");
		System.out.println(ciaccio.a.getAutonomia());

		System.out.print("autonomia in km max di b: ");
		System.out.println(ciaccio.b.getAutonomia());
	}
}
