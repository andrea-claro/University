public class ContaPersone{
	
	private int nPersone;

	public ContaPersone(){
		nPersone= 0;
	}

	public ContaPersone(int n){
		nPersone= n;
	}

	public void addPersona(){
		nPersone++;
	}

	public int getNPersone(){
		return nPersone;
	}

	public static void main(String args[]){
		ContaPersone tool= new ContaPersone();

		tool.addPersona();
		
		System.out.print("numero: ");
		System.out.println(tool.getNPersone());
	}
}
