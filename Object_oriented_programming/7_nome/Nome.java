public class Nome{

	public Nome(){
		name=  null;
	}

	public Nome(String a){
		this.name= a;
	}

	public String getNome(){
		return this.name;
	}
	
	public void printName(){
		System.out.print(this.name);
	}

	private String name;
}
