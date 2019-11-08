import java.util.Scanner;
public class SongLibraryRunner{
	public static void main(String args[])throws Exception{
		Scanner in= new Scanner(System.in);

		System.out.println();
		System.out.println("inserire nome file: ");
		String fileName= in.nextLine();

		SongLibrary attempt= new SongLibrary(fileName);
		
		System.out.println();
		System.out.println("inserire artista: ");
        String artistName= in.nextLine();
        
        attempt.lookUp(artistName);
	}
}
