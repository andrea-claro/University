public class Auto{
		
	private String marca, nome, targa;
    private int serbatoio, autonomia;

	public Auto(){
		marca= null;
		nome= null;
		targa= null;
		serbatoio= 0;
		autonomia= 0;
	}

	public Auto(String info[], int capacity, int km){
		marca= info[0];
		nome= info[1];
		targa= info[2];
		serbatoio= capacity;
		autonomia= km;
	}

	public int getAutonomia(){
        int km= autonomia*serbatoio;
		return km;
	}

	public static void main(String args[]){ //passare al main nell'ordine:"marca, nome, targa"
		Auto a= new Auto(args, 88, 8);

		System.out.print("autonomia in km max: ");
		System.out.println(a.getAutonomia());

	}
}
