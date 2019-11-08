import java.util.Scanner;
public class Combinazione{
	
	public Combinazione(){
        System.out.println("you're setting the combination:");
		set= inSet();
		door= false;
	}
	
	public void unlock(String word){ // apre la serratura se il codice passato è quello della serratura
		if( word.equals(set) )
			door= true;
		else	return;
	}

	public boolean isOpen(){ // verifica se la serratura è aperta
		return door;
	}
	
	public void lock(){ // chiude la serratura
		door= false;
	}

	public void newComb(){  // setta la nuova combinazione se la serratura è aperta
		if( this.isOpen() ){
            System.out.println("you're changing the combination:");
			set= inSet();
        }
		return;		
	}

	public String inSet(){
        Scanner in= new Scanner(System.in);
		System.out.println("insert combination:");
		String word= in.nextLine().toUpperCase();
		System.out.println();
		return word;
	}

	private String set;
	private boolean door;
}
