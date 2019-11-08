public class Parola3{
	public static void main( String args[] ){
		int n= args[0].length();
		String firstmd= args[0].substring(0, n/2);
		String secondmd= args[0].substring(n/2, n);
		System.out.println(secondmd + firstmd);
	}
}
