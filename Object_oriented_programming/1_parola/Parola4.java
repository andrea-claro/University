public class Parola4{
	public static void main( String args[] ){
		char first= args[0].charAt(0);
		int n= args[0].indexOf(first, 1);
		if(n != -1)
		System.out.println("Il primo carattere viene ritrovato");
	}
}
