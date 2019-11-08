public class Parola5{
	public static void main( String args[] ){
		int n= args[0].length();
		System.out.println(args[0].substring(0, 1).toUpperCase() + args[0].substring(1, n).toLowerCase());
	}
}
