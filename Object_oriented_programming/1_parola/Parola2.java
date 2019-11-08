public class Parola2{
	public static void main( String args[] ){
		int n= args[0].length();
		char first= args[0].charAt(0);
		char last= args[0].charAt(n-1);
		System.out.println(last + args[0].substring(1, n-1) + first);
	}
}
